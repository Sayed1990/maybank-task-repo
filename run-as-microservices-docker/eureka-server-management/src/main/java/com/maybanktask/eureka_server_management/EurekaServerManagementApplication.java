package com.maybanktask.eureka_server_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerManagementApplication.class, args);
	}

}
