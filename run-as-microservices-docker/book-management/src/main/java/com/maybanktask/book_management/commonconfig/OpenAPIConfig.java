package com.maybanktask.book_management.commonconfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${usermanagementsystem.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("syedalfazim140@gmail.com");
        contact.setName("SyedAlfazim");
        contact.setUrl("");

        License mitLicense = new License().name("AEON License").url("");

        Info info = new Info()
                .title("Book Management System API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Book stufss.").termsOfService("")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
