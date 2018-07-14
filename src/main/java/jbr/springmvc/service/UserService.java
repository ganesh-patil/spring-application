package jbr.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.model.User;

public class UserService {
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public void register(User user) {
		userDaoImpl.register(user);
	}

}
