package examples;

import javax.sql.DataSource;
import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class DbConfig implements Config {

  private static final DbConfig CONFIG = new DbConfig();

  private final Dialect dialect;

  private final LocalTransactionDataSource dataSource;

  private final TransactionManager transactionManager;

  private DbConfig() {
    String envDialect = System.getenv("DOMA2_DIALECT");
    switch (envDialect) {
      case "H2":
        dialect = new H2Dialect();
        break;
      case "PostgreSQL":
        dialect = new PostgresDialect();
        break;
      default:
        throw new AssertionError("Invalid environment of DOMA2_DIALECT " + envDialect);
    }

    String url = System.getenv("DOMA2_DATASOURCE_URL");
    String username = System.getenv("DOMA2_DATASOURCE_USERNAME");
    String password = System.getenv("DOMA2_DATASOURCE_PASSWORD");

    dataSource = new LocalTransactionDataSource(url, username, password);
    transactionManager =
        new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
  }

  @Override
  public Dialect getDialect() {
    return dialect;
  }

  @Override
  public DataSource getDataSource() {
    return dataSource;
  }

  @Override
  public TransactionManager getTransactionManager() {
    return transactionManager;
  }

  public static DbConfig singleton() {
    return CONFIG;
  }
}
