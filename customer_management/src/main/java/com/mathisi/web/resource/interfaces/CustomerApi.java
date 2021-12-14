package com.mathisi.web.resource.interfaces;

import com.mathisi.web.model.ApiExceptionList;
import com.mathisi.web.model.CustomerDto;
import com.mathisi.web.model.CustomerDtoSet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, December 2021
 * Time: 4:21 PM
 * Project: multi_module
 * Package Name: com.mathisi.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/customer")
@Validated
public interface CustomerApi {

    /**
     *
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get all the customers in the system",
            tags = {"customer"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved all customers",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CustomerDtoSet.class))
                    })
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDtoSet> getAllCustomers();


    /**
     *
     * @param page
     * @param pageSize
     * @param sortBy
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get customers sorted and option use pagination",
            tags = {"customer"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved all customers",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,schema = @Schema(implementation = CustomerDtoSet.class))
                    })
    })
    @GetMapping("/sort")
    ResponseEntity<CustomerDtoSet> getAllSortedCustomers(
            @Parameter(in = ParameterIn.QUERY, description = "Page number requested" ,schema=@Schema( defaultValue="0"), required = false)  @RequestParam Optional<Integer> page,
            @Parameter(in = ParameterIn.QUERY, description = "Page size for the page" ,schema=@Schema( defaultValue="5"), required = false) @RequestParam Optional<Integer> pageSize,
            @Parameter(in = ParameterIn.QUERY, description = "Sorting column" ,schema=@Schema( defaultValue="customerId"), required = false) @RequestParam Optional<String> sortBy);

    /**
     *
     * @param customerDto
     * @return
     * @throws URISyntaxException
     */
    @Operation(
            method = "POST",
            description = "Create a new customer",
            tags = {"customer"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created the customer",
                    content = {
                            @Content(mediaType = "application/json",schema = @Schema(implementation = CustomerDtoSet.class))
                    })
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) throws URISyntaxException;

    /**
     *
     * @param customerId
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get the customer by an id",
            tags = {"customer"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the requested customer",
                    content = {
                            @Content(mediaType = "application/json",schema = @Schema(implementation = CustomerDtoSet.class))
                    }),
            @ApiResponse(responseCode = "400",
                    description = "The requested customer was not found",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    })
    })
    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CustomerDto> getCustomerById(@Parameter(in = ParameterIn.PATH, description = "Id of the customer to be retrieved", example = "c1984335-850b-43e4-9f7d-12034cef659c", required = true, name = "customerId") @PathVariable("customerId") UUID customerId);
}
