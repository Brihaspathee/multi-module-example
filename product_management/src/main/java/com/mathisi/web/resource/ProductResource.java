package com.mathisi.web.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 08, December 2021
 * Time: 7:18 AM
 * Project: multi_module
 * Package Name: com.mathisi.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("api/v1/product")
public class ProductResource {

    @GetMapping
    public ResponseEntity getAllProducts(){
        log.info("Inside the product controller");
        return ResponseEntity.ok().body("Hello Products!!!");
    }
}
