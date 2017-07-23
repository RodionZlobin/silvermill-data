package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.client.UserClient;
import com.rodion.silvermilldata.client.UserClientImpl;
import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;
import com.rodion.silvermilldata.service.UserService;
import com.rodion.silvermilldata.service.UserServiceImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * @author Rodion
 */
public class ConnectionTest {

    //for best test use create / delete DB or TODO: create DB manually and drop after test



    public static ApplicationContext springContextRule = new ClassPathXmlApplicationContext(new ClassPathResource("silvermill-data-dao.xml").getPath());


    @Ignore //prepare clear DB
    @Test
    public void tryCreateConnectionInsertAndRead(){

        UserDao userDao = springContextRule.getBean(UserDao.class);
        UserService userService = new UserServiceImpl(userDao);
        UserClient userClient = new UserClientImpl(userService);

        User user = new User("1", "username1", "password1");

        userClient.createUser(user);
        Assert.assertEquals("1", userClient.findUserByUserId("1").getUserId());
        Assert.assertEquals("username1", userClient.findUserByUsername("username1").getUserName());


        /*
        User user2 = new User("2", "username1", "password2");
        userClient.createUser(user2);
        Assert.assertNull(userClient.findUserByUserId("2"));
        */
        User user3 = new User("3", "username3", "password1");
        userClient.createUser(user3);
        Assert.assertNotNull(userClient.findUserByUserId("3"));
        Assert.assertEquals("password1", userClient.findUserByUsername("username3").getPassword());

        User user4 = new User("1", "username4", "password4");
        userClient.createUser(user4);
        //Assert.assertNull(userClient.findUserByUsername("username4"));

        Assert.assertEquals("password1", userClient.findUserByUserId("1").getPassword());







        /*
        UserEntity user = new UserEntity("1","username", "password");


        userDao.insert(user);
        List<UserEntity> usersFromDB = userDao.findAll();

        Assert.assertEquals(1, usersFromDB.size());

        UserEntity userEntityByUserId = userDao.findByUserId("1");
        UserEntity userEntityByUsername = userDao.findByUsername("username");

        Assert.assertEquals("1", userEntityByUserId.getUserId());
        Assert.assertEquals("username", userEntityByUsername.getUsername());




        //same password, different usernames
        UserEntity user2 = new UserEntity("2","username1", "password");
        userDao.insert(user2);
        usersFromDB = userDao.findAll();

        Assert.assertEquals(2, usersFromDB.size());

        //same username, different passwords
        UserEntity user3 = new UserEntity("3","username", "password1");
        userDao.insert(user3);
        usersFromDB = userDao.findAll();

        Assert.assertEquals(2, usersFromDB.size());
        */

    }

}
