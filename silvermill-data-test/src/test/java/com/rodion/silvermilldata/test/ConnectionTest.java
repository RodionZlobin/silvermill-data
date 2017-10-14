package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.client.CustomerClient;
import com.rodion.silvermilldata.client.CustomerClientImpl;
import com.rodion.silvermilldata.client.UserClient;
import com.rodion.silvermilldata.dao.*;
import com.rodion.silvermilldata.domain.*;
import com.rodion.silvermilldata.mapper.CustomerDomainMapper;
import com.rodion.silvermilldata.mapper.DeliveryAddressDomainMapper;
import com.rodion.silvermilldata.mapper.ProductDomainMapper;
import com.rodion.silvermilldata.service.*;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class ConnectionTest {

    //for best test use create / delete DB or TODO: create DB manually and drop after test


    public static ApplicationContext springContext = new ClassPathXmlApplicationContext("silvermill-data-config.xml");


    @Ignore
    @Test
    public void tryAllUserServices() {
        UserDao userDao = springContext.getBean(UserDao.class);
        UserService userService = springContext.getBean(UserService.class);
        UserClient userClient = springContext.getBean(UserClient.class);

        User user = new User("1", "username1", "password1");

        userClient.createOrUpdateUser(user);



        /*
        Assert.assertEquals("1", userClient.findUserByUserId("1").getUserId());
        Assert.assertEquals("username1", userClient.findUserByUsername("username1").getUserName());




        User user2 = new User("2", "username1", "password2");
        userClient.createOrUpdateUser(user2);

        //Assert.assertEquals(1, userClient.getAllUsers().size());


        //Assert.assertNull(userClient.findUserByUserId("2"));

        User user3 = new User("3", "username3", "password1");
        userClient.createOrUpdateUser(user3);

        //Assert.assertNotNull(userClient.findUserByUserId("3"));
        Assert.assertEquals("password1", userClient.findUserByUsername("username3").getPassword());
        //Assert.assertEquals(2, userClient.getAllUsers().size());



        User user4 = new User("1", "username1", "password4");
        userClient.createOrUpdateUser(user4);
        //Assert.assertNull(userClient.findUserByUsername("username4"));

        Assert.assertEquals("password4", userClient.findUserByUserId("1").getPassword());
        //Assert.assertEquals(2, userClient.getAllUsers().size());

        User user5 = new User("5", "username1", "password5");
        userClient.createOrUpdateUser(user5);
         */


    }


    @Ignore
    @Test
    public void experimentsWithOrder(){
        OrderDao orderDao = springContext.getBean(OrderDao.class);
        InvoiceAddressDao invoiceAddressDao = springContext.getBean(InvoiceAddressDao.class);
        DeliveryAddressDao deliveryAddressDao = springContext.getBean(DeliveryAddressDao.class);
        OrderRowDao orderRowDao = springContext.getBean(OrderRowDao.class);
        CustomerDao customerDao = springContext.getBean(CustomerDao.class);
        ProductDao productDao = springContext.getBean(ProductDao.class);


        OrderService orderService = new OrderServiceImpl(orderDao, customerDao, deliveryAddressDao, orderRowDao, productDao);

        InvoiceAddress address = new InvoiceAddress("1", "address", "street", "build", "city", "zip", "country", "PO");
        DeliveryAddress deliveryAddress = new DeliveryAddress("10", "delivery", "dstreet", "delbuild", "delcity", "delzip", "delcountry", "delPO");
        Customer customer = new Customer("C1", "c-name", "vat", "reg", address, deliveryAddress);
        Product product1 = new Product("1", "FP-374-R", "Sparta", "red", 0.10,1000);
        Product product2 = new Product("2", "FP-293-B", "Symphony", "blue", 0.40,5000);

        customerDao.insert(CustomerDomainMapper.map(customer));
        deliveryAddressDao.insert(DeliveryAddressDomainMapper.map(deliveryAddress));
        productDao.insert(ProductDomainMapper.map(product1));
        productDao.insert(ProductDomainMapper.map(product2));


        OrderRow orderRow1 = new OrderRow("R1", "O-1", "I-1", product1, "pcs", 50.00, 10.00, 500.00);
        OrderRow orderRow2 = new OrderRow("R2", "O-1", "I-1", product2, "pcs", 100.00, 7.00, 700.00);


        List<OrderRow> orderRows = new ArrayList<>();
        orderRows.add(orderRow1);
        orderRows.add(orderRow2);

        Date date = new Date();

        Order order = new Order("O-1", date, "14 days", customer, customer.getDeliveryAddress(), "DDU", orderRows, "EUR", 20, 1000.00, 1200.00, "created" );

        //orderDao.insert(OrderDomainMapper.map(order));
        orderService.createOrUpdateOrder(order);

    }


    @Ignore
    @Test
    public void tryCreateCustomer(){
        CustomerDao customerDao = springContext.getBean(CustomerDao.class);
        InvoiceAddressDao invoiceAddressDao = springContext.getBean(InvoiceAddressDao.class);
        DeliveryAddressDao deliveryAddressDao = springContext.getBean(DeliveryAddressDao.class);
        CustomerService customerService = new CustomerServiceImpl(customerDao, invoiceAddressDao, deliveryAddressDao);
        CustomerClient customerClient = new CustomerClientImpl(customerService);


        InvoiceAddress address = new InvoiceAddress("1", "address", "street", "build", "city", "zip", "country", "PO");
        DeliveryAddress deliveryAddress = new DeliveryAddress("10", "delivery", "dstreet", "delbuild", "delcity", "delzip", "delcountry", "delPO");

        Customer customer = new Customer("C1", "c-name", "vat", "reg", address, deliveryAddress);

        customerClient.createOrUpdateCustomer(customer);

        /*

        invoiceAddressDao.insert(InvoiceAddressDomainMapper.map(address));
        deliveryAddressDao.insert(DeliveryAddressDomainMapper.map(deliveryAddress));

        InvoiceAddressEntity addressEntity = invoiceAddressDao.findByAddressID("1");
        DeliveryAddressEntity deliveryAddressEntity = deliveryAddressDao.findByDeliveryAddressId("10");

        CustomerEntity customer = new CustomerEntity("C1", "cname", "vat", "reg", addressEntity, deliveryAddressEntity);

        //customerClient.createOrUpdateCustomer(customer);
        customerDao.insert(customer);
         */
    }


        /*
    @Ignore //prepare clear DB
    @Test
    public void tryCreateConnectionInsertAndRead(){

        UserDao userDao = springContext.getBean(UserDao.class);
        UserService userService = new UserServiceImpl(userDao);
        UserClient userClient = new UserClientImpl(userService);

        User user = new User("1", "username1", "password1");

        userClient.createOrUpdateUser(user);
        Assert.assertEquals("1", userClient.findUserByUserId("1").getUserId());
        Assert.assertEquals("username1", userClient.findUserByUsername("username1").getUserName());

        */
        /*
        User user2 = new User("2", "username1", "password2");
        userClient.createOrUpdateUser(user2);
        Assert.assertNull(userClient.findUserByUserId("2"));
        */
        /*
        User user3 = new User("3", "username3", "password1");
        userClient.createOrUpdateUser(user3);
        Assert.assertNotNull(userClient.findUserByUserId("3"));
        Assert.assertEquals("password1", userClient.findUserByUsername("username3").getPassword());

        User user4 = new User("1", "username4", "password4");
        userClient.createOrUpdateUser(user4);
        //Assert.assertNull(userClient.findUserByUsername("username4"));

        Assert.assertEquals("password1", userClient.findUserByUserId("1").getPassword());







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

    }
        */

}
