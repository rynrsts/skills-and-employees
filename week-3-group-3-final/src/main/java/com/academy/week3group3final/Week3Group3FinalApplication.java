package com.academy.week3group3final;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week3Group3FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week3Group3FinalApplication.class, args);
		System.out.println("\nUp and running...");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
