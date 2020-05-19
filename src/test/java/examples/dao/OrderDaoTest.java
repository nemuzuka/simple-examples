package examples.dao;

import static org.assertj.core.api.Assertions.assertThat;

import examples.DbConfig;
import examples.TestEnvironment;
import examples.domain.User;
import examples.entity.Order;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestEnvironment.class)
public class OrderDaoTest {

  private final DbConfig config;
  private final OrderDao sut;

  OrderDaoTest(DbConfig config) {
    this.config = config;
    sut = new OrderDaoImpl(config);
  }

  @Test
  @DisplayName("JSON カラムの INSERT と SELECT のテスト")
  public void testInsertAndSelectByOrderId() {
    var tm = config.getTransactionManager();

    tm.required(
        () -> {
          var order = new Order();
          order.setOrderId(UUID.randomUUID().toString());
          order.setOrderCode("ORDER_001");
          var user = new User();
          user.setUserCode("USER_0001");
          user.setUserName("NAME_001");
          order.setInnerUser(user);
          sut.insert(order);

          var actual = sut.selectByCustomerId(order.getOrderId());
          assertThat(actual).hasValue(order);
        });
  }
}
