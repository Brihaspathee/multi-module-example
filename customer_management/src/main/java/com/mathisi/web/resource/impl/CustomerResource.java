package com.mathisi.web.resource.impl;

import com.mathisi.command.service.interfaces.CustomerService;
import com.mathisi.web.model.CustomerDto;
import com.mathisi.web.model.CustomerDtoSet;
import com.mathisi.web.resource.interfaces.CustomerApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, December 2021
 * Time: 7:13 AM
 * Project: multi_module
 * Package Name: com.mathisi.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerResource implements CustomerApi {

    @Value("${url.order.host}")
    private String orderHost;

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerDtoSet> getAllCustomers(){
        log.info("Inside the customer controller");
        log.info("The order host is: {}", orderHost);
        Set<CustomerDto> customerDtoSet = customerService.getAllCustomers();
        return ResponseEntity.ok().body(CustomerDtoSet.builder().customerDtoSet(customerDtoSet).build());
    }

    @Override
    public ResponseEntity<CustomerDtoSet> getAllSortedCustomers(Optional<Integer> page,
                                                                Optional<Integer> pageSize,
                                                                Optional<String> sortBy) {
        log.info("page:{}, pageSize:{}, sortBy:{}", page, pageSize, sortBy);
        Set<CustomerDto> customerDtoSet = customerService.getAllSortedCustomers(PageRequest.of(page.orElse(0),
                pageSize.orElse(5),
                Sort.Direction.ASC, sortBy.orElse("customerId"))
        );
        return ResponseEntity.ok().body(CustomerDtoSet.builder().customerDtoSet(customerDtoSet).build());
    }


    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) throws URISyntaxException {
        CustomerDto customer = customerService.createCustomer(customerDto);
        return ResponseEntity.created(new URI("/api/v1/customer/"+customer.getCustomerId())).body(customer);
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomerById(UUID customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return ResponseEntity.ok().body(customerDto);
    }
}
