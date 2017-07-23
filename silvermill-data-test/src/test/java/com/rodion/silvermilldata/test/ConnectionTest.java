package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.entity.UserEntity;
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

        UserEntity user = new UserEntity("1","username", "password");


        userDao.insert(user);
        List<UserEntity> usersFromDB = userDao.findAll();

        Assert.assertEquals(1, usersFromDB.size());

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
    }

}
