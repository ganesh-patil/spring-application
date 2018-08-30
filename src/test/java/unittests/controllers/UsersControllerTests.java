package unittests.controllers;

import jbr.springmvc.controller.UsersController;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserHiberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UsersControllerTests {

    @Mock
    public UserHiberService userService;

    @Mock
    public HttpServletRequest request;

    @Mock
    public HttpServletResponse response;

    @Spy
    List<User> users = new ArrayList<User>();

    @InjectMocks
    public UsersController usersController;

    public ModelAndView modelAndView;

    @Before
    public  void initTests(){
        MockitoAnnotations.initMocks(this);
        setUsers();
    }

    @Test
    public void usersTest(){
        when(userService.getAllUsers()).thenReturn(users);
        modelAndView = usersController.users(request, response);
        Assert.assertEquals("users", modelAndView.getViewName());
        Assert.assertEquals(users, modelAndView.getModel().get("users"));
        verify(userService, atLeastOnce()).getAllUsers();
    }

    @Test
    public void deleteUserTest(){
        try{
            doNothing().when(userService).deleteUser(anyInt());
            modelAndView = usersController.deleteUser(anyInt());
            Assert.assertEquals("redirect:/users", modelAndView.getViewName());
            verify(userService, atLeastOnce()).deleteUser(anyInt());
        }
        catch (Exception e){

        }
    }

    @Test
    public void deleteUserInvalidTest(){
        try{
            doThrow(new Exception("Invalid user Ud ")).when(userService).deleteUser(anyInt());
            modelAndView = usersController.deleteUser(anyInt());
            Assert.assertEquals("redirect:/users1", modelAndView.getViewName());
            verify(userService, atLeastOnce()).deleteUser(anyInt());
        }
        catch (Exception e){
            Assert.assertEquals(e.getMessage(), "Invalid user id ");
        }

    }

    public void setUsers(){
        User user  = new User();
        user.setPassword("test");
        user.setId(1);
        users.add(user);
        user  = new User();
        user.setPassword("test");
        user.setId(2);
        users.add(user);
    }
}
