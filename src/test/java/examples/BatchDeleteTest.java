package examples;

import examples.dao.EmployeeDao;
import examples.dao.EmployeeDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestEnvironment.class)
public class BatchDeleteTest {

  private final DbConfig config;
  private final EmployeeDao dao;

  BatchDeleteTest(DbConfig config) {
    this.config = config;
    dao = new EmployeeDaoImpl(config);
  }

  @Test
  public void testBatchDelete() {
    var tm = config.getTransactionManager();

    tm.required(
        () -> {
          var list = dao.selectAll();
          dao.batchDelete(list);
        });
  }
}
