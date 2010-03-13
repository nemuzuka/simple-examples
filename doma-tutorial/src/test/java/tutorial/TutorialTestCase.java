package tutorial;

import java.sql.Connection;
import java.sql.Statement;

import junit.framework.TestCase;

import org.seasar.doma.jdbc.tx.LocalTransaction;

public abstract class TutorialTestCase extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        LocalTransaction tx = AppConfig.getLocalTransaction();
        try {
            tx.begin();
            Connection connection = AppConfig.dataSource.getConnection();
            try {
                Statement statement = connection.createStatement();
                try {
                    statement
                            .execute("create sequence employee_seq as integer start with 100 increment by 1;");
                    statement
                            .execute("create table employee (id integer not null primary key,name varchar(255) not null,age integer not null,salary integer,job_type varchar(20),hiredate timestamp, department_id integer, version integer not null, insertTimestamp timestamp, updateTimestamp timestamp)");
                    statement
                            .execute("insert into employee values(1,'ALLEN',30,1600,'SALESMAN','2008-01-20 12:34:56',1,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(2,'WARD',32,1250,'ANALYST','2008-02-20 12:34:56',2,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(3,'JONES',38,2975,'MANAGER','2008-03-20 12:34:56',3,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(4,'MARTIN',40,1250,'SALESMAN','2008-04-20 12:34:56',1,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(5,'BLAKE',50,2850,'SALESMAN','2008-05-20 12:34:56',2,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(6,'CLARK',23,2450,'MANAGER','2008-06-20 12:34:56',3,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(7,'SCOTT',28,3000,'SALESMAN','2008-07-20 12:34:56',1,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(8,'KING',38,5000,'CLERK','2008-08-20 12:34:56',2,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(9,'TURNER',33,1500,'ANALYST','2008-09-20 12:34:56',3,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(10,'ADAMS',62,1100,'SALESMAN','2008-10-20 12:34:56',1,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(11,'JAMES',44,950,'CLERK','2008-11-20 12:34:56',2,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(12,'FORD',55,3000,'ANALYST','2008-12-20 12:34:56',3,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(13,'MILLER',51,1300,'MANAGER','2009-01-20 12:34:56',1,1,CURRENT_TIMESTAMP,null)");
                    statement
                            .execute("insert into employee values(14,'SMITH',410,800,'PRESIDENT','2009-02-20 12:34:56',2,1,CURRENT_TIMESTAMP,null)");
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
            tx.commit();
        } finally {
            tx.rollback();
        }
    }

    @Override
    protected void tearDown() throws Exception {
        LocalTransaction tx = AppConfig.getLocalTransaction();
        try {
            tx.begin();
            Connection connection = AppConfig.dataSource.getConnection();
            try {
                Statement statement = connection.createStatement();
                try {
                    statement.execute("drop sequence employee_seq;");
                    statement.execute("drop table employee;");
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
            tx.commit();
        } finally {
            tx.rollback();
        }
        super.tearDown();
    }

}