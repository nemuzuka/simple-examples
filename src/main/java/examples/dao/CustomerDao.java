package examples.dao;

import examples.entity.Customer;
import java.util.Optional;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Sql;

@Dao
public interface CustomerDao {

  @Select
  @Sql("SELECT * FROM customers WHERE customer_id = /*customerId*/'customer_001'")
  Optional<Customer> selectByCustomerId(String customerId);

  @Insert(sqlFile = true)
  int insert(Customer customer);
}
