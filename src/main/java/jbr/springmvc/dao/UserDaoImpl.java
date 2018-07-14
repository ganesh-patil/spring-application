package jbr.springmvc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
public class UserDaoImpl implements UserDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(User user) {
	    String sql = "insert into users values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	    }
	    public User validateUser(Login login) {
	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";
	   // List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    List<User> users = null;
	    return users.size() > 0 ? users.get(0) : null;
	    }
	    
}

