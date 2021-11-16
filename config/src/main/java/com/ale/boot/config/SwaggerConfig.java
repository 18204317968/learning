package com.ale.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${spring.swagger2.enabled}")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).enable(swaggerEnabled).select().apis(RequestHandlerSelectors.basePackage("com.ale.boot")).paths(PathSelectors.any()).build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("学习工程接口文档").description("记录学习spring boot过程中编写的接口的功能").version("v1.0").build();
    }
}
