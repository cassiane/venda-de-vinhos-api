package com.project.vendadevinhos.services;

import java.util.List;

import com.project.vendadevinhos.api.entities.Produto;

public interface ProdutoService {
	
	Produto persistir (Produto produto);

	Produto findByProduto(String produto);

	List<Produto> listarTodos();
}
