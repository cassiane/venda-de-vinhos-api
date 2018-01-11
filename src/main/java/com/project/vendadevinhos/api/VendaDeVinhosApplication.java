package com.project.vendadevinhos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.vendadevinhos.services.ClienteService;

@SpringBootApplication
public class VendaDeVinhosApplication {

	@Autowired
	static ClienteService cliente;

	public static void main(String[] args) {
		SpringApplication.run(VendaDeVinhosApplication.class, args);
	}
}
