package com.mathisi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 12, December 2021
 * Time: 8:20 AM
 * Project: multi_module
 * Package Name: com.mathisi.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${customer-mgmt.api.version}") String apiVersion){
        List<Server> servers = new ArrayList<>();
        servers.add(new Server()
                .url("http://localhost:8080")
                .description("Development Server"));
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Customer Management API")
                        .version(apiVersion)
                        .contact(new Contact()
                                .name("Balaji Varadharajan")
                                .url("http://www.mathisi.org")
                                .email("vbalaji215@outlook.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/License-2.0.html"))
                                )
                .servers(servers);
    }
}
