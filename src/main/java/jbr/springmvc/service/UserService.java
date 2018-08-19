package jbr.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.model.User;

public class UserService implements UserDetailsService{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public void register(User user) {
		userDaoImpl.register(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
