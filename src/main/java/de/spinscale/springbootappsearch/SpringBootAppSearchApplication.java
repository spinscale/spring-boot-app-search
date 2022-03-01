package de.spinscale.springbootappsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = AppSearchClient.class)
public class SpringBootAppSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppSearchApplication.class, args);
	}

}
