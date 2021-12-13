package com.mathisi.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mathisi.reference.data.Gender;
import com.mathisi.reference.data.MaritalStatus;
import lombok.*;

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
public class CustomerDto {

    @JsonProperty(required = false)
    private UUID customerId;

    @JsonProperty(required = true)
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Gender gender;

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
