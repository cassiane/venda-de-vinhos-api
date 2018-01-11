package com.project.vendadevinhos.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vendadevinhos.api.dtos.ClienteDto;
import com.project.vendadevinhos.api.response.Response;
import com.project.vendadevinhos.services.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/listarPeloMaiorValorEmCompras")
	public ResponseEntity<Response<ClienteDto>> listarPeloMaiorValorEmCompras () {
		log.info("Listando os cliente pelo maior valor em compras.");
		
		Response<ClienteDto> response = new Response<ClienteDto>();		
		//Page<ClienteDto> clientesPage = this.clienteService.listarClientesOrdenadosMaiorValorCompras(); 
		//response.setData(clientesPage);
		return ResponseEntity.ok(response);
	}
}
