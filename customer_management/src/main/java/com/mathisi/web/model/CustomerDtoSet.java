package com.mathisi.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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
@Schema(description = "List of customers in the system")
@Validated
public class CustomerDtoSet {

    @JsonProperty(required = true)
    @Schema(description = "List of customers", minimum = "0")
    @Valid
    private Set<CustomerDto> customerDtoSet;
}
