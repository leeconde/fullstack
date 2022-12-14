package com.leticia.fullstack;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leticia.fullstack.services.FileReader;

@SpringBootApplication
public class FullstackApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(FullstackApplication.class, args);

	}

}
