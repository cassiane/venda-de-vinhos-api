package com.project.vendadevinhos.api.dtos;

import java.util.List;

public class HistoricoDto {
	private String codigo;
	private String data;
	private String cliente;
	private List<ProdutoDto> itens;

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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoDto> getItens() {
		return itens;
	}

	public void setItens(List<ProdutoDto> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "HistoricoDto [codigo=" + codigo + ", data=" + data + ", cliente=" + cliente + ", itens=" + itens + "]";
	}

}
