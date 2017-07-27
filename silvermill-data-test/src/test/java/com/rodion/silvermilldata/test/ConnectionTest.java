package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.client.CustomerClient;
import com.rodion.silvermilldata.client.CustomerClientImpl;
import com.rodion.silvermilldata.client.UserClient;
import com.rodion.silvermilldata.client.UserClientImpl;
import com.rodion.silvermilldata.dao.AddressDao;
import com.rodion.silvermilldata.dao.CustomerDao;
import com.rodion.silvermilldata.dao.DeliveryAddressDao;
import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.AddressEntity;
import com.rodion.silvermilldata.entity.CustomerEntity;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;
import com.rodion.silvermilldata.entity.UserEntity;
import com.rodion.silvermilldata.mapper.AddressDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import com.rodion.silvermilldata.service.CustomerService;
import com.rodion.silvermilldata.service.CustomerServiceImpl;
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

    @Ignore
    @Test
    public void tryCreateCustomer(){
        CustomerDao customerDao = springContextRule.getBean(CustomerDao.class);
        AddressDao addressDao = springContextRule.getBean(AddressDao.class);
        DeliveryAddressDao deliveryAddressDao = springContextRule.getBean(DeliveryAddressDao.class);
        CustomerService customerService = new CustomerServiceImpl(customerDao, addressDao, deliveryAddressDao);
        CustomerClient customerClient = new CustomerClientImpl(customerService);


        Address address = new Address("1", "address", "street", "build", "city", "zip", "country", "PO");
        DeliveryAddress deliveryAddress = new DeliveryAddress("10", "delivery", "dstreet", "delbuild", "delcity", "delzip", "delcountry", "delPO");

        Customer customer = new Customer("C1", "c-name", "vat", "reg", address, deliveryAddress);

        customerClient.createOrUpdateCustomer(customer);
        /*

        addressDao.insert(AddressDomainMapper.map(address));
        deliveryAddressDao.insert(DeliveryAddressDomainMapper.map(deliveryAddress));

        AddressEntity addressEntity = addressDao.findByAddressID("1");
        DeliveryAddressEntity deliveryAddressEntity = deliveryAddressDao.findByDeliveryAddressId("10");

        CustomerEntity customer = new CustomerEntity("C1", "cname", "vat", "reg", addressEntity, deliveryAddressEntity);

        //customerClient.createOrUpdateCustomer(customer);
        customerDao.insert(customer);
         */
    }


    @Ignore //prepare clear DB
    @Test
    public void tryCreateConnectionInsertAndRead(){

        UserDao userDao = springContextRule.getBean(UserDao.class);
        UserService userService = new UserServiceImpl(userDao);
        UserClient userClient = new UserClientImpl(userService);

        User user = new User("1", "username1", "password1");

        userClient.createOrUpdateUser(user);
        Assert.assertEquals("1", userClient.findUserByUserId("1").getUserId());
        Assert.assertEquals("username1", userClient.findUserByUsername("username1").getUserName());


        /*
        User user2 = new User("2", "username1", "password2");
        userClient.createOrUpdateUser(user2);
        Assert.assertNull(userClient.findUserByUserId("2"));
        */
        User user3 = new User("3", "username3", "password1");
        userClient.createOrUpdateUser(user3);
        Assert.assertNotNull(userClient.findUserByUserId("3"));
        Assert.assertEquals("password1", userClient.findUserByUsername("username3").getPassword());

        User user4 = new User("1", "username4", "password4");
        userClient.createOrUpdateUser(user4);
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
