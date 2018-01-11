package com.project.vendadevinhos.api.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

	@Override
	public List<HistoricoCompras> findAllClientesOrderByValorTotalDesc() {
		return this.historicoComprasRepository.findAll(new Sort(Direction.DESC, "valorTotal"));
	}

	@Override
	public List<HistoricoCompras> findByAndSort() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String ultimoAno = formatter.format(calendar.getTime()).substring(0,4);
	    
	    log.info(ultimoAno);
	    
		return this.historicoComprasRepository.findByAndSort(ultimoAno, new Sort(Direction.DESC, "valorTotal"));
	}

}
