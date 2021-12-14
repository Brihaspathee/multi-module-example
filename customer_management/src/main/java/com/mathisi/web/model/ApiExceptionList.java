package com.mathisi.web.model;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, December 2021
 * Time: 10:58 PM
 * Project: multi_module
 * Package Name: com.mathisi.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionList {

    private List<ApiException> exceptions;

    @Override
    public String toString() {
        return "ApiExceptionList{" +
                "exceptions=" + exceptions +
                '}';
    }
}
