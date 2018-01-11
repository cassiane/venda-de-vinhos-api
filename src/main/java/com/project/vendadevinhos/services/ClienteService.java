package com.project.vendadevinhos.services;

import java.util.List;

import com.project.vendadevinhos.api.entities.Cliente;

public interface ClienteService {

//	// listar os clientes ordenados pelo maior valor total em compras
//	Page<ClienteDto> listarClientesOrdenadosMaiorValorCompras();
//
//	// listar o cliente com maior compra única no último ano(2016)
//	ClienteDto mostrarClienteMaiorCompraUnicaUltimoAno();
//
//	// listar os clientes mais fiéis
//	List<ClienteDto> listarClienteFieis();
//
//	// listar os vinhos para um determinado cliente a partir do histórico de
//	// compras
//	List<VinhoDto> listarVinhosRecomendadosAoCliente(Long clienteId);
	
	Cliente persistir(Cliente cliente);
	
	List<Cliente> listarTodos();
}
