package com.project.vendadevinhos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.vendadevinhos.api.entities.Cliente;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByCpf(String cpf);

}
