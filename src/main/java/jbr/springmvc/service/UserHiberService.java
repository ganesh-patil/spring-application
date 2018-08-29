package jbr.springmvc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.dao.UserHiberDaoImpl;
import jbr.springmvc.model.User;

@Transactional
public class UserHiberService {


	public List getTestList() {
		return testList;
	}

	public void setTestList(List testList) {
		this.testList = testList;
	}

	public List testList;
	@Autowired
	UserHiberDaoImpl userHiberDaoImpl;
	
	@Transactional
	public void register(User user) {
		userHiberDaoImpl.register(user);
	}
	
	public List<User> getAllUsers(){
		return userHiberDaoImpl.getAllUsers();
	}

	public User getUserByUserName(String userName){
		return userHiberDaoImpl.getUserByUserName(userName);
	}

	public void deleteUser(int userId){
		userHiberDaoImpl.deleteUser(userId);
	}

	
	

}
