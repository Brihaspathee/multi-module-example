package com.mathisi.command.action.impl;

import com.mathisi.command.action.interfaces.CustomerAction;
import com.mathisi.domain.entity.Customer;
import com.mathisi.domain.repository.CustomerRepository;
import com.mathisi.exception.CustomerNotFoundException;
import com.mathisi.mapper.interfaces.CustomerMapper;
import com.mathisi.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:48 AM
 * Project: multi_module
 * Package Name: com.mathisi.command.action.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerActionImpl implements CustomerAction {

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        return customerMapper.customerDtoToCustomer(customerDto);
    }

    @Override
    public Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers) {
        return customerMapper.customersToCustomerDtos(customers);
    }

    @Override
    public Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos) {
        return customerMapper.customerDtosToCustomers(customerDtos);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return customerRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Customer> getAllSortedCustomers(PageRequest pageRequest) {
        return customerRepository.findAll(pageRequest).stream().collect(Collectors.toSet());
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
    }
}
