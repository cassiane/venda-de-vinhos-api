package com.project.vendadevinhos.api.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class HistoricoCompras {

	private String codigo;
	private String data;
	private String cliente;
	private List<Produto> itens;

	@Id
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@OneToMany(mappedBy = "historicoCompras", fetch = FetchType.LAZY)
	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "HistoricoCompras [codigo=" + codigo + ", data=" + data + ", cliente=" + cliente + ", itens=" + itens
				+ "]";
	}

}
