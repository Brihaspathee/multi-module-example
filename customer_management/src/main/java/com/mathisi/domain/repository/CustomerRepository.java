package com.mathisi.domain.repository;

import com.mathisi.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:14 AM
 * Project: multi_module
 * Package Name: com.mathisi.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
