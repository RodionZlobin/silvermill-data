package com.rodion.silverdata.test;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class ConnectionTest {

    public static void main(String[] args){


        UserEntity user = new UserEntity("username", "password");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("silvermill-data-dao.xml").getPath());
        UserDao userDao = context.getBean(UserDao.class);

        userDao.save(user);

        context.close();


    }

}