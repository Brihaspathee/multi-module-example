package com.mathisi.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mathisi.reference.data.Gender;
import com.mathisi.reference.data.MaritalStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 10, December 2021
 * Time: 5:17 AM
 * Project: multi_module
 * Package Name: com.mathisi.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Customer Object")
@Validated
public class CustomerDto {

    @JsonProperty(required = false)
    @Schema(description = "Customer Id - This is a UUID value", example = "657cfd75-634e-49f1-9556-4d79f79848ec", required = false)
    private UUID customerId;

    @JsonProperty(required = true)
    @Schema(description = "First Name of the customer", example = "John")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @JsonProperty(required = true)
    @Schema(description = "Last Name of the customer", example = "Doe")
    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @JsonProperty(required = true)
    @Schema(description = "Date of birth of the customer", example = "1983-05-21")
    private LocalDate dateOfBirth;

    @JsonProperty(required = true)
    @Schema(description = "Gender of the customer", example = "MALE")
    private Gender gender;

    @JsonProperty(required = true)
    @Schema(description = "Marital Status of the customer", example = "MARRIED")
    private MaritalStatus maritalStatus;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
