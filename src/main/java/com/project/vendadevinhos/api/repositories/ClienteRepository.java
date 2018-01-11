package com.project.vendadevinhos.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.vendadevinhos.api.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// Anotação para melhorar a performance de consulta no banco pois não cria
	// uma transação por se tratar de apenas um select
	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
}
