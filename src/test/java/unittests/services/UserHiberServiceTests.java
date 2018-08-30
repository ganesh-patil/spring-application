package unittests.services;

import jbr.springmvc.dao.UserHiberDaoImpl;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserHiberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class UserHiberServiceTests {

    @Mock
    UserHiberDaoImpl userHiberDaoImpl;

    @Spy
    List<User> users = new ArrayList<User>();

    @Before
    public  void initTests(){
        MockitoAnnotations.initMocks(this);
        setUsers();
    }

    @InjectMocks
    public UserHiberService userService;

    @Test
    public void getAllUsersTest(){
        when(userHiberDaoImpl.getAllUsers()).thenReturn(users);
        Assert.assertEquals(userService.getAllUsers(),users);
        verify(userHiberDaoImpl, atLeastOnce()).getAllUsers();
    }

    @Test
    public void registerTest(){
        doNothing().when(userHiberDaoImpl).register(any(User.class));
        userService.register(any(User.class));
        verify(userHiberDaoImpl, atLeastOnce()).register(any(User.class));

    }

    @Test
    public void getUserByUserNameTest(){
        User user = users.get(0);
        when(userHiberDaoImpl.getUserByUserName(anyString())).thenReturn(user);
        Assert.assertEquals(users.get(0), userService.getUserByUserName(anyString()));
        verify(userHiberDaoImpl, atLeastOnce()).getUserByUserName(anyString());
    }

    @Test
    public void deleteUserTest(){

        try{
            doNothing().when(userHiberDaoImpl).deleteUser(anyInt());
            userService.deleteUser(anyInt());
            verify(userHiberDaoImpl, atLeastOnce()).deleteUser(anyInt());
        }
        catch (Exception e){

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
