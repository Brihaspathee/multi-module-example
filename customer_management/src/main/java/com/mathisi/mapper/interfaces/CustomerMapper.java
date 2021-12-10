package com.mathisi.mapper.interfaces;

import com.mathisi.domain.entity.Customer;
import com.mathisi.web.model.CustomerDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:25 AM
 * Project: multi_module
 * Package Name: com.mathisi.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
    Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers);
    Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos);
}
