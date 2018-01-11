package com.project.vendadevinhos.services;

import java.util.List;

import com.project.vendadevinhos.api.entities.Cliente;

public interface ClienteService {

	Cliente persistir(Cliente cliente);

	List<Cliente> listarTodos();

	Cliente findByCpf(String cpf);

}
