package com.mathisi.mapper.impl;

import com.mathisi.domain.entity.Customer;
import com.mathisi.mapper.interfaces.CustomerMapper;
import com.mathisi.reference.data.Gender;
import com.mathisi.reference.data.MaritalStatus;
import com.mathisi.web.model.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:37 AM
 * Project: multi_module
 * Package Name: com.mathisi.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if(customer == null){
            return null;
        }
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .gender(Gender.valueOf(customer.getGender()))
                .maritalStatus(MaritalStatus.valueOf(customer.getMaritalStatus()))
                .build();
        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if(customerDto == null){
            return null;
        }
        Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .dateOfBirth(customerDto.getDateOfBirth())
                .gender(customerDto.getGender().name())
                .maritalStatus(customerDto.getMaritalStatus().name())
                .build();
        return customer;
    }

    @Override
    public Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers) {
        return customers.stream().map(this::customerToCustomerDto).collect(Collectors.toSet());
    }

    @Override
    public Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos) {
        return customerDtos.stream().map(this::customerDtoToCustomer).collect(Collectors.toSet());
    }
}
