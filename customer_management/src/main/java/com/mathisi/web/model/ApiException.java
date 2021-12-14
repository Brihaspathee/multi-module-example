package com.mathisi.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, December 2021
 * Time: 7:44 AM
 * Project: multi_module
 * Package Name: com.mathisi.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {

    private String exceptionCode;

    private String exceptionMessage;
}
