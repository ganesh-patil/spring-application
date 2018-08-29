package jbr.springmvc.dao;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;


public class UserHiberDaoImpl implements UserDao {
   @Autowired
   private SessionFactory sessionFactory;
   @Autowired
   private PasswordEncoder passwordEncoder;
 
   protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
  public void register(User user) {
	  user.setPassword(passwordEncoder.encode(user.getPassword()));
	 getSession().persist(user);
  }
  public User validateUser(Login login) {
	return null;
  }
  
  public User getUserByUserName(String userName) {
	  Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
	  User userdetails = (User) criteria.add(Restrictions.eq("username", userName))
	                             .uniqueResult();
	  return userdetails;
  }
public List<User> getAllUsers() {
	Session session = getSession();
	List<User> users = session.createQuery("from User").list();
	Collections.sort(users);
	return users;
}

    public void deleteUser(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(userId));
        if(null != user){
            session.delete(user);
        }
    }
	    
}

