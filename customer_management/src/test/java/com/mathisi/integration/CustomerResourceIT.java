package com.mathisi.integration;

import com.mathisi.web.model.CustomerDto;
import com.mathisi.web.model.CustomerDtoSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 10:22 AM
 * Project: multi_module
 * Package Name: com.mathisi.integration
 * To change this template use File | Settings | File and Code Template
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerResourceIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads(){

    }

    @Test
    public void testGetAllCustomers(){
        CustomerDtoSet customerDtoSet = testRestTemplate.getForObject("/api/v1/customer/", CustomerDtoSet.class);
        assertEquals(2, customerDtoSet.getCustomerDtoSet().size());
    }
}
