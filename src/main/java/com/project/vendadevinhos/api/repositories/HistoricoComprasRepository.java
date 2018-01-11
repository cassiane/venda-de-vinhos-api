package com.project.vendadevinhos.api.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.vendadevinhos.api.entities.HistoricoCompras;

@Transactional(readOnly = true)
public interface HistoricoComprasRepository extends JpaRepository<HistoricoCompras, Long> {
	
	@Query("select h from HistoricoCompras h where h.data like %?1")
	List<HistoricoCompras> findByAndSort(String data, Sort sort);
}
