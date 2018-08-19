package jbr.springmvc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
//import jbr.springmvc.service.UserService;
@Controller
public class LoginController {
//  @Autowired
//  UserService userService;
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	  
	  if(SecurityContextHolder.getContext().getAuthentication() != null &&
			  SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
			  //when Anonymous Authentication is enabled
			  !(SecurityContextHolder.getContext().getAuthentication() 
			           instanceof AnonymousAuthenticationToken) ) {
		  return new ModelAndView("redirect:/welcome1");
	  }
     ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav; 
	 // return "login";
  }
  
  @RequestMapping(value = "/welcome1", method = RequestMethod.GET)
  public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("Ganesh");
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	ModelAndView mav = new ModelAndView("welcome");
	
    return mav; 
	 // return "login";
  }
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
//    User user = userService.validateUser(login);
    User user = null;
    if (null != user) {
    mav = new ModelAndView("welcome");
    mav.addObject("firstname", user.getFirstname());
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
  
  @RequestMapping(value="/logout", method = RequestMethod.GET)
  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
      }
      return "redirect:/login?logout";
  }
}