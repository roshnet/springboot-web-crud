package net.guides.springboot.todomanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@ComponentScan({"net.guides.springboot.todomanagement"})
public class TodoManagementSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementSpringBootApplication.class, args);
	}

}
