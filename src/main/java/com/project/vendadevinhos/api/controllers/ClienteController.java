package com.project.vendadevinhos.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.vendadevinhos.api.entities.Cliente;
import com.project.vendadevinhos.api.response.Response;
import com.project.vendadevinhos.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteService clienteService;

	@PostMapping(value = "/inicializar")
	public HttpStatus inicializar() {
		RestTemplate restTemplate = new RestTemplate();
		List<Cliente> clientes = Arrays
				.asList(restTemplate.getForObject("http://www.mocky.io/v2/598b16291100004705515ec5", Cliente[].class));
		clientes.forEach(cliente -> cliente.setCpf(cliente.getCpf().replace(".", "")));
		clientes.forEach(cliente -> cliente.setCpf(cliente.getCpf().replace("-", "")));
		clientes.forEach(cliente -> clienteService.persistir(cliente));

		return HttpStatus.OK;
	}

	@GetMapping(value = "/listarTodos")
	public ResponseEntity<Response<List<Cliente>>> listarTodos() {
		log.info("Listando todos os clientes");
		Response<List<Cliente>> response = new Response<>();
		List<Cliente> clientes = this.clienteService.listarTodos();
		response.setData(clientes);
		return ResponseEntity.ok(response);
	}
	//
	// @GetMapping(value = "/listarPeloMaiorValorEmCompras")
	// public ResponseEntity<Response<Page<ClienteDto>>>
	// listarPeloMaiorValorEmCompras() {
	// log.info("Listando os cliente pelo maior valor em compras.");
	//
	// Response<Page<ClienteDto>> response = new Response<Page<ClienteDto>>();
	// Page<ClienteDto> clientesPage =
	// this.clienteService.listarClientesOrdenadosMaiorValorCompras();
	// response.setData(clientesPage);
	// return ResponseEntity.ok(response);
	// }

}
