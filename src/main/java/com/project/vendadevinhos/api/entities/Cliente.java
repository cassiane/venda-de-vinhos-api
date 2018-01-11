package com.project.vendadevinhos.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

	private Long id;
	private String nome;
	private String cpf;
//	private HistoricoCompras historicoCompras;

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
	
//	@ManyToOne
//	public HistoricoCompras getHistoricoCompras() {
//		return historicoCompras;
//	}
//
//	public void setHistoricoCompras(HistoricoCompras historicoCompras) {
//		this.historicoCompras = historicoCompras;
//	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

}
