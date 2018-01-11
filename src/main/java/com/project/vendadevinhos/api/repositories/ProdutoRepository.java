package com.project.vendadevinhos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.vendadevinhos.api.entities.Item;

@Transactional(readOnly = true)
public interface ProdutoRepository extends JpaRepository<Item, Long>{

	Item findByProduto(String produto);

}
