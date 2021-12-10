package com.mathisi.web.model;

import lombok.*;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 10:26 AM
 * Project: multi_module
 * Package Name: com.mathisi.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDtoSet {

    private Set<CustomerDto> customerDtoSet;
}
