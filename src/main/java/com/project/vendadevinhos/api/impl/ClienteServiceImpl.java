package com.project.vendadevinhos.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vendadevinhos.api.entities.Cliente;
import com.project.vendadevinhos.api.repositories.ClienteRepository;
import com.project.vendadevinhos.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente persistir(Cliente cliente) {
		log.info("Persistindo cliente: {}", cliente.toString());
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listarTodos() {
		log.info("Listando todos os clientes");
		return clienteRepository.findAll();
	}

}
