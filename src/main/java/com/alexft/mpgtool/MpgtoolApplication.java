package com.alexft.mpgtool;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MpgtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpgtoolApplication.class, args);
    }


    @Bean
    public OpenAPI mallTinyOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("MPG代码生成工具")
                        .description("SpringDoc API")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("")))
                .externalDocs(new ExternalDocumentation()
                        .description("MPG代码生成工具")
                        .url(""));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("MPG")
                .pathsToMatch("/**/**")
                .build();
    }


}
