package com.project.vendadevinhos.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {

	private Long id;
	private String nome;
	private String cpf;
	private List<HistoricoCompras> historicoCompras;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<HistoricoCompras> getHistoricoCompras() {
		return historicoCompras;
	}

	public void setHistoricoCompras(List<HistoricoCompras> historicoCompras) {
		this.historicoCompras = historicoCompras;
	}

}
