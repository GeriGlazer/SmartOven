package com.fp.smartOven;

import com.fp.smartOven.repositories.ProbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SmartOvenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartOvenApplication.class, args);
	}

}
