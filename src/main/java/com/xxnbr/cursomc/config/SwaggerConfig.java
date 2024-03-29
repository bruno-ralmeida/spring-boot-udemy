package com.xxnbr.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
        return new ApiInfoBuilder()
                .title("Curso Udemy Spring-boot")
                .description("Curso Spring Boot, Hibernate, REST, Ionic, JWT, S3, MySQL, MongoDB")
                .version("1.0")
                .termsOfServiceUrl("Terms of Service")
                .contact(new Contact("Bruno Almeida", "xxnbr.com.br", "bruno-ralmeida@outlook.com"))
                .build();
    }
}
