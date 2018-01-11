package com.project.vendadevinhos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vendadevinhos.api.entities.Itens;

public interface ItensRepository extends JpaRepository<Itens, Long>{
	
}
