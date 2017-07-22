package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.entity.UserEntity;
import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class ConnectionTest {

    //for best test use create / delete DB

    public static ApplicationContext springContextRule = new ClassPathXmlApplicationContext(new ClassPathResource("silvermill-data-dao.xml").getPath());

    @Ignore //prepare clear DB
    @Test
    public void tryCreateConnectionInsertAndRead(){

        UserDao userDao = springContextRule.getBean(UserDao.class);

        UserEntity user = new UserEntity("username", "password");


        userDao.save(user);
        List<UserEntity> usersFromDB = userDao.findAll();

        Assert.assertEquals(1, usersFromDB.size());

        //same password, different usernames
        UserEntity user2 = new UserEntity("username1", "password");
        userDao.save(user2);
        usersFromDB = userDao.findAll();

        Assert.assertEquals(2, usersFromDB.size());

        //same username, different passwords
        UserEntity user3 = new UserEntity("username", "password1");
        userDao.save(user3);
        usersFromDB = userDao.findAll();

        Assert.assertEquals(2, usersFromDB.size());
    }
}
