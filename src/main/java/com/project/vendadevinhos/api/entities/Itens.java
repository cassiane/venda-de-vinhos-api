package com.project.vendadevinhos.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Itens {

	private int id;
	private Item item;
	private HistoricoCompras historicoCompras;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	@OneToOne
	public HistoricoCompras getHistoricoCompras() {
		return historicoCompras;
	}

	public void setHistoricoCompras(HistoricoCompras historicoCompras) {
		this.historicoCompras = historicoCompras;
	}

	@Override
	public String toString() {
		return "Itens [id=" + id + ", item=" + item + ", historicoCompras=" + historicoCompras + "]";
	}

}
