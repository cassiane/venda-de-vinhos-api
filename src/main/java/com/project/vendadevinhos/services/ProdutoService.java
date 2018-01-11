package com.project.vendadevinhos.services;

import java.util.List;

import com.project.vendadevinhos.api.entities.Item;

public interface ProdutoService {
	
	Item persistir (Item produto);

	Item findByProduto(String produto);

	List<Item> listarTodos();

	Item findByProdutoAndVariedadeAndSafra(String produto, String variedade, String safra);
}
