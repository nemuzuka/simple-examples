package examples.entity;

import examples.domain.User;
import lombok.Data;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "orders")
@Data
public class Order {

  @Id
  @Column(name = "order_id")
  private String orderId;

  @Column(name = "order_code")
  private String orderCode;

  @Column(name = "inner_user")
  private User innerUser;
}
