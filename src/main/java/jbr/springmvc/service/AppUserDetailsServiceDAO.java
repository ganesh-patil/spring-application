package jbr.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jbr.springmvc.dao.UserHiberDaoImpl;
import jbr.springmvc.model.User;

public class AppUserDetailsServiceDAO implements UserDetailsService{
	@Autowired
	UserHiberDaoImpl userHiberDaoImpl;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);
		//userHiberDaoImpl = new UserHiberDaoImpl();
		User user = userHiberDaoImpl.getUserByUserName(username);
		//User user = new User();
		//System.out.println(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                true, true, true, true, getGrantedAuthorities(user));
		//return new org.springframework.security.core.userdetails.User("Ganesh", "Ganesh", 
             //   true, true, true, true, getGrantedAuthorities(user));
		//return user;
	}
	
	 private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	 
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	
	        return authorities;
	    }

}
