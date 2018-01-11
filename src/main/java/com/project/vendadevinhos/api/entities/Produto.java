package com.project.vendadevinhos.api.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Produto {
	
	private Long id;
	private String produto;
	private String variedade;
	private String pais;
	// Criar ENUM
	private String categoria;
	private String safra;
	private float preco;
	private HistoricoCompras historicoCompras;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSafra() {
		return safra;
	}

	public void setSafra(String safra) {
		this.safra = safra;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public HistoricoCompras getHistoricoCompras() {
		return historicoCompras;
	}

	public void setHistoricoCompras(HistoricoCompras historicoCompras) {
		this.historicoCompras = historicoCompras;
	}

	@Override
	public String toString() {
		return "Produto [produto=" + produto + ", variedade=" + variedade + ", pais=" + pais + ", categoria="
				+ categoria + ", safra=" + safra + ", preco=" + preco + "]";
	}

}
