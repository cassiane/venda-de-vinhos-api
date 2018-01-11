package com.project.vendadevinhos.services;

import java.util.List;

import com.project.vendadevinhos.api.entities.HistoricoCompras;

public interface HistoricoComprasService {
	
	HistoricoCompras persistir (HistoricoCompras historicoCompras);
	
	List<HistoricoCompras> listarTodos();
}
