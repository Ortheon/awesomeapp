package com.eflechowicz.moviemanager.moviemicroservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class MoviemicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviemicroserviceApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eflechowicz.moviemanager.moviemicroservice.controller"))
                .paths(any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Mówi11e API v1.0").build());
    }

}
