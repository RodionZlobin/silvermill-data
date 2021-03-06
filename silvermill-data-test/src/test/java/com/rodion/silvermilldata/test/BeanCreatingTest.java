package com.rodion.silvermilldata.test;

import com.rodion.silvermilldata.client.*;
import com.rodion.silvermilldata.dao.*;
import com.rodion.silvermilldata.domain.*;
import com.rodion.silvermilldata.service.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;

/**
 * @author Rodion
 */
public class BeanCreatingTest {

    public static ApplicationContext springContext = new ClassPathXmlApplicationContext("silvermill-data-config.xml");

    @Ignore
    @Test
    public void tryToCreateAllBeans(){

        InvoiceAddressDao invoiceAddressDao = springContext.getBean(InvoiceAddressDao.class);
        CustomerDao customerDao = springContext.getBean(CustomerDao.class);
        DeliveryAddressDao deliveryAddressDao = springContext.getBean(DeliveryAddressDao.class);
        InvoiceDao invoiceDao = springContext.getBean(InvoiceDao.class);
        OrderDao orderDao = springContext.getBean(OrderDao.class);
        OrderRowDao orderRowDao = springContext.getBean(OrderRowDao.class);
        ProductDao productDao = springContext.getBean(ProductDao.class);
        UserDao userDao = springContext.getBean(UserDao.class);

        CustomerService customerService = springContext.getBean(CustomerService.class);
        InvoiceService invoiceService = springContext.getBean(InvoiceService.class);
        OrderService orderService = springContext.getBean(OrderService.class);
        ProductService productService = springContext.getBean(ProductService.class);
        UserService userService = springContext.getBean(UserService.class);

        CustomerClient customerClient = springContext.getBean(CustomerClient.class);
        InvoiceClient invoiceClient = springContext.getBean(InvoiceClient.class);
        OrderClient orderClient = springContext.getBean(OrderClient.class);
        ProductClient productClient = springContext.getBean(ProductClient.class);
        UserClient userClient = springContext.getBean(UserClient.class);

        Assert.assertNotNull(invoiceAddressDao);
        Assert.assertNotNull(customerDao);
        Assert.assertNotNull(deliveryAddressDao);
        Assert.assertNotNull(invoiceDao);
        Assert.assertNotNull(orderDao);
        Assert.assertNotNull(orderRowDao);
        Assert.assertNotNull(productDao);
        Assert.assertNotNull(userDao);
        Assert.assertNotNull(customerService);
        Assert.assertNotNull(invoiceService);
        Assert.assertNotNull(orderService);
        Assert.assertNotNull(productService);
        Assert.assertNotNull(userService);
        Assert.assertNotNull(customerClient);
        Assert.assertNotNull(invoiceClient);
        Assert.assertNotNull(orderClient);
        Assert.assertNotNull(productClient);
        Assert.assertNotNull(userClient);

    }


    @Ignore
    @Test
    public void tryUserServices() {
        UserDao userDao = springContext.getBean(UserDao.class);
        UserService userService = springContext.getBean(UserService.class);
        UserClient userClient = springContext.getBean(UserClient.class);

        User user = new User("U-1", "username1", "password1");

        userClient.createOrUpdateUser(user);

    }

    @Ignore
    @Test
    public void tryCustomerServices(){
        CustomerDao customerDao = springContext.getBean(CustomerDao.class);
        CustomerService customerService = springContext.getBean(CustomerService.class);
        CustomerClient customerClient = springContext.getBean(CustomerClient.class);

        InvoiceAddress address = new InvoiceAddress("A-1", "addressname", "street", "building", "city", "zip", "country", "PO");
        DeliveryAddress deliveryAddress= new DeliveryAddress("DA-1", "DA-name", "street", "building", "city", "zip", "country", "PO");

        Customer customer = new Customer("C-1", "customername", "VAT", "rEG", address, deliveryAddress);

        customerClient.createOrUpdateCustomer(customer);

        Assert.assertEquals(1, customerClient.findAllCustomers().size());
        Assert.assertEquals("C-1", customerClient.findByCustomerName("customername").getCustomerId());

    }



    @Ignore
    @Test
    public void tryToUpsertUser(){

        UserDao userDao = springContext.getBean(UserDao.class);
        UserService userService = springContext.getBean(UserService.class);
        UserClient userClient = springContext.getBean(UserClient.class);

        //UserService userService = new UserServiceImpl(userDao);

        /*

        UserClient userClient = new UserClientImpl(userService);

        User user1 = new User("1", "username1", "password1");
        User user2 = new User("2", "username2", "password2");

        userClient.createOrUpdateUser(user1);
        userClient.createOrUpdateUser(user2);

        Assert.assertEquals(2, userClient.getAllUsers().size());
        Assert.assertEquals("username1", userClient.findUserByUserId("1").getUserName());
        Assert.assertEquals("password1", userClient.findUserByUsername("username1").getPassword());

        User updatedUser1 = new User(user1.getUserId(), user1.getUserName(), "new-password");
        userService.createOrUpdateUser(updatedUser1);


        User updatedUser2 = new User(user2.getUserId(), "new username", user2.getPassword());
        userService.createOrUpdateUser(updatedUser2);


        Assert.assertEquals(2, userClient.getAllUsers().size());
        Assert.assertEquals("new-password", userClient.findUserByUsername("username1").getPassword());

        //username can´t update
        Assert.assertEquals("username2", userClient.findUserByUserId("2").getUserName());

        User user3 = new User("3", "username1", "password3");
        userClient.createOrUpdateUser(user3);

        //usernaeme is unique, can´ create new whenever can update exist
        Assert.assertEquals(2, userClient.getAllUsers().size());
        Assert.assertEquals(user3.getPassword(), userClient.findUserByUsername("username1").getPassword());

        User user4 = new User("3", "username3", "password3");
        userClient.createOrUpdateUser(user4);

        Assert.assertEquals(3, userClient.getAllUsers().size());
         */

    }

    @Ignore
    @Test
    public void tryToUpsertProduct(){

        ProductDao productDao = springContext.getBean(ProductDao.class);
        ProductService productService = new ProductServiceImpl(productDao);
        ProductClient productClient = new ProductClientImpl(productService);

        Product product1 = new Product("1", "FP-374-R", "Sparta", "red", 0.10,1000);
        Product product2 = new Product("2", "FP-293-B", "Symphony", "blue", 0.40,5000);

        productClient.createOrUpdateProduct(product1);
        productClient.createOrUpdateProduct(product2);

        Assert.assertEquals(2, productClient.findAllProducts().size());
        Assert.assertEquals("Sparta", productClient.findByProductArticle("FP-374-R").getProductName());
        Assert.assertEquals(1, productClient.findByProductName("Symphony").size());
        Double price = 0.40;
        Assert.assertEquals(price, productClient.findByProductName("Symphony").get(0).getProductSalesPrice());

        Product updateProduct2 = new Product("2", "FP-293-B", "Symphony", "red", 0.40,15000);
        productClient.createOrUpdateProduct(updateProduct2);

        //updating, can´ create new by unique fields
        //updating quantity
        Integer quantity = 15000;
        Assert.assertEquals(quantity, productClient.findByProductArticle("FP-293-B").getProductQuantity());
        //can´t update color
        Assert.assertEquals(product2.getProductColor(), productClient.findByProductName("Symphony").get(0).getProductColor());

    }
}
