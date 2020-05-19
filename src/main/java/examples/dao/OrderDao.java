package examples.dao;

import examples.entity.Order;
import java.util.Optional;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Sql;

@Dao
public interface OrderDao {

  @Select
  @Sql("SELECT * FROM orders WHERE order_id = /*orderId*/'order_001'")
  Optional<Order> selectByCustomerId(String orderId);

  @Insert(sqlFile = true)
  int insert(Order order);
}
