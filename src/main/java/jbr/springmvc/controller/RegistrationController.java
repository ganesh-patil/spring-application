package jbr.springmvc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserHiberService;
import jbr.springmvc.service.UserService;
@Controller
public class RegistrationController {
   @Autowired
  public UserHiberService userService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,   @ModelAttribute("user") @Valid User user,
			BindingResult bindingResult) {
      try{
          if (bindingResult.hasErrors()) {

              // ModelAndView mav = new ModelAndView("register");
              //mav.addObject("user", user);
              //mav.addObject("error","Found errors");
              return new ModelAndView("register", "user", user);
              //return mav;
          }
          userService.register(user);
          return new ModelAndView("welcome", "firstname", user.getFirstname());

      }
      catch (Exception e){
          System.out.println("Caught Exception");

      }

      return  null;

  } 
}