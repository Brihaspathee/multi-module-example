package com.mathisi.command.service.impl;

import com.mathisi.command.action.interfaces.CustomerAction;
import com.mathisi.command.service.interfaces.CustomerService;
import com.mathisi.domain.entity.Customer;
import com.mathisi.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:22 AM
 * Project: multi_module
 * Package Name: com.mathisi.command.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerAction customerAction;

    @Override
    public Set<CustomerDto> getAllCustomers() {
        Set<Customer> customers = customerAction.getAllCustomers();
        return customerAction.customersToCustomerDtos(customers);
    }

    @Override
    public Set<CustomerDto> getAllSortedCustomers(PageRequest pageRequest) {
        Set<Customer> customers = customerAction.getAllSortedCustomers(pageRequest);
        return customerAction.customersToCustomerDtos(customers);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        Customer customer = customerAction.getCustomerById(customerId);
        return customerAction.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerAction.customerDtoToCustomer(customerDto);
        customer = customerAction.saveCustomer(customer);
        return customerAction.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }
}
