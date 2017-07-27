package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;
import com.rodion.silvermilldata.service.UserService;
import com.rodion.silvermilldata.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Rodion
 */
public class UpsertTest {

    public static ApplicationContext springContextRule = new ClassPathXmlApplicationContext(new ClassPathResource("silvermill-data-dao.xml").getPath());

    @Ignore
    @Test
    public void tryToUpsertProperty(){

        UserDao userDao = springContextRule.getBean(UserDao.class);
        UserService userService = new UserServiceImpl(userDao);

        User user1 = new User("1", "username1", "password1");
        User user2 = new User("2", "username2", "password2");


        userService.createOrUpdateUser(user1);
        userService.createOrUpdateUser(user2);

        User updatedUser1 = new User(user1.getUserId(), user1.getUserName(), "new-password");
        userService.createOrUpdateUser(updatedUser1);


        User updatedUser2 = new User(user2.getUserId(), "new username", user2.getPassword());
        userService.createOrUpdateUser(updatedUser2);



    }
}
