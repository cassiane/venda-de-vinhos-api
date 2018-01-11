package com.project.vendadevinhos.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vendadevinhos.api.entities.HistoricoCompras;
import com.project.vendadevinhos.api.repositories.HistoricoComprasRepository;
import com.project.vendadevinhos.services.HistoricoComprasService;

@Service
public class HistoricoComprasServiceImpl implements HistoricoComprasService {
	
	private static final Logger log = LoggerFactory.getLogger(HistoricoComprasServiceImpl.class);

	@Autowired
	private HistoricoComprasRepository historicoComprasRepository;

	@Override
	public HistoricoCompras persistir(HistoricoCompras historicoCompras) {
		log.info("Persistindo histórico: {}", historicoCompras.toString());
		return this.historicoComprasRepository.save(historicoCompras);
	}

	@Override
	public List<HistoricoCompras> listarTodos() {
		return this.historicoComprasRepository.findAll();
	}

}
