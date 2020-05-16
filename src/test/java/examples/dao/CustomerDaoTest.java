package examples.dao;

import static org.assertj.core.api.Assertions.assertThat;

import examples.DbConfig;
import examples.TestEnvironment;
import examples.domain.Attribute;
import examples.entity.Customer;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestEnvironment.class)
public class CustomerDaoTest {

  private final DbConfig config;
  private final CustomerDao sut;

  CustomerDaoTest(DbConfig config) {
    this.config = config;
    sut = new CustomerDaoImpl(config);
  }

  @Test
  @DisplayName("JSON カラムの INSERT と SELECT のテスト")
  public void testInsertAndSelectByCustomerId() {
    var tm = config.getTransactionManager();

    tm.required(
        () -> {
          var customer = new Customer();
          customer.setCustomerId(UUID.randomUUID().toString());
          customer.setCustomerCode("CUSTOMER_001");
          customer.setCustomerName("NAME_001");
          var attribute = new Attribute();
          attribute.setAge(30);
          attribute.setMemo("memo_001");
          attribute.setPoint(343L);
          customer.setAttribute(attribute);
          sut.insert(customer);

          var actual = sut.selectByCustomerId(customer.getCustomerId());
          assertThat(actual).hasValue(customer);
        });
  }
}
