package com.project.vendadevinhos.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vendadevinhos.api.entities.Itens;
import com.project.vendadevinhos.api.repositories.ItensRepository;
import com.project.vendadevinhos.services.ItensService;

@Service
public class ItensServiceImpl implements ItensService {
	
	@Autowired
	private ItensRepository itensRepository;

	@Override
	public Itens persistir(Itens itens) {
		return itensRepository.save(itens);
	}
}
