package com.project.vendadevinhos.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vendadevinhos.api.entities.Produto;
import com.project.vendadevinhos.api.repositories.ProdutoRepository;
import com.project.vendadevinhos.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto persistir(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Produto findByProduto(String produto) {
		return produtoRepository.findByProduto(produto);
	}

	@Override
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

}
