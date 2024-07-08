package com.sdg4.microservicio_Cartilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sdg4.microservicio_Cartilla")
public class MicroservicioCartillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCartillaApplication.class, args);
	}
}
