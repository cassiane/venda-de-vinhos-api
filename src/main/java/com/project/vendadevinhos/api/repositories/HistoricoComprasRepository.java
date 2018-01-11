package com.project.vendadevinhos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.vendadevinhos.api.entities.HistoricoCompras;

@Transactional(readOnly = true)
//@NamedQueries({
//		@NamedQuery(name = "HistoricoComprasRepository.findByClienteCpf", 
//				query = "SELECT hist FROM historico hist WHERE hist.cliente.cpf = :clienteCpf") })
public interface HistoricoComprasRepository extends JpaRepository<HistoricoCompras, String>{
	
}
