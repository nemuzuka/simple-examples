package demo.smart.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import demo.config.AppConfig;
import demo.smart.entity.Account;

@Dao(config = AppConfig.class)
public interface AccountDao {

    @Select
    Account getAccountByUsername(String username);

    @Select
    Account getAccountByUsernameAndPassword(String username, String password);

    @Insert(sqlFile = true)
    int insertAccount(Account account);

    @Update(sqlFile = true)
    int updateAccount(Account account);

}