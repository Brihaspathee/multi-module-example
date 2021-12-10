package com.mathisi.web.resource;

import com.mathisi.command.service.interfaces.CustomerService;
import com.mathisi.web.model.CustomerDto;
import com.mathisi.web.model.CustomerDtoSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDtoSet> getAllCustomers(){
        log.info("Inside the customer controller");
        Set<CustomerDto> customerDtoSet = customerService.getAllCustomers();
        return ResponseEntity.ok().body(CustomerDtoSet.builder().customerDtoSet(customerDtoSet).build());
    }
}
