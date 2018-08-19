package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserHiberService;

@Controller
public class UsersController {
	
	@Autowired
	  public UserHiberService userService;
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.getAllUsers();
		System.out.println(userService.getAllUsers());
		return new ModelAndView("users", "users", users);
		
	}

}
