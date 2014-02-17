/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package tutorial;

import org.junit.rules.ExternalResource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;

import tutorial.dao.EmployeeDao;
import tutorial.dao.EmployeeDaoImpl;

/**
 * @author nakamura-to
 *
 */
public class DbResource extends ExternalResource {

    EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    protected void before() throws Throwable {
        LocalTransactionManager tx = AppConfig.singleton()
                .getLocalTransactionManager();
        tx.required(() -> {
            dao.create();
        });
    }

    @Override
    protected void after() {
        LocalTransactionManager tx = AppConfig.singleton()
                .getLocalTransactionManager();
        tx.required(() -> {
            dao.drop();
        });
    }

}
