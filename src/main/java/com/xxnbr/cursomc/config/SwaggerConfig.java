package com.xxnbr.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Curso Udemy Spring-boot",
                "Curso Spring Boot, Hibernate, REST, Ionic, JWT, S3, MySQL, MongoDB",
                "1.0",
                "Terms of Service",
                new Contact("Bruno Almeida", "xxnbr.com.br", "bruno-ralmeida@outlook.com"),
                "-",
                "-",
                new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
