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

import org.hibernate.Session;
public class UserHiberDaoImpl implements UserDao {
   @Autowired
   private SessionFactory sessionFactory;
 
   protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
  public void register(User user) {
	 getSession().persist(user);
  }
  public User validateUser(Login login) {
	return null;
  }
	    
}

