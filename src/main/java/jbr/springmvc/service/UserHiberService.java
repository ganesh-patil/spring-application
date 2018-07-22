package jbr.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.dao.UserHiberDaoImpl;
import jbr.springmvc.model.User;

@Transactional
public class UserHiberService {
	@Autowired
	UserHiberDaoImpl userHiberDaoImpl;
	
	public void register(User user) {
		userHiberDaoImpl.register(user);
	}

}
