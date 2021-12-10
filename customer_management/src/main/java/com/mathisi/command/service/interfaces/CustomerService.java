package com.mathisi.command.service.interfaces;

import com.mathisi.web.model.CustomerDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:15 AM
 * Project: multi_module
 * Package Name: com.mathisi.command.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerService {

    Set<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
