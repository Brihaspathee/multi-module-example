package com.mathisi.command.action.interfaces;

import com.mathisi.domain.entity.Customer;
import com.mathisi.web.model.CustomerDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:24 AM
 * Project: multi_module
 * Package Name: com.mathisi.command.action.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerAction {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
    Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers);
    Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos);
    Customer saveCustomer(Customer customer);
    Set<Customer> getAllCustomers();
}
