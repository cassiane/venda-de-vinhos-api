package com.project.vendadevinhos.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.vendadevinhos.api.dtos.HistoricoDto;
import com.project.vendadevinhos.api.dtos.ProdutoDto;
import com.project.vendadevinhos.api.entities.Cliente;
import com.project.vendadevinhos.api.entities.HistoricoCompras;
import com.project.vendadevinhos.api.entities.Item;
import com.project.vendadevinhos.api.entities.Itens;
import com.project.vendadevinhos.services.ClienteService;
import com.project.vendadevinhos.services.HistoricoComprasService;
import com.project.vendadevinhos.services.ItensService;
import com.project.vendadevinhos.services.ProdutoService;

@RestController
@RequestMapping("/api/historicoCompras")
public class HistoricoController {

	private static final Logger log = LoggerFactory.getLogger(HistoricoController.class);

	@Autowired
	private HistoricoComprasService historicoComprasService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ItensService itensService;

	@PostMapping(value = "/inicializar")
	public HttpStatus inicializar() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<HistoricoDto[]> response = restTemplate
				.getForEntity("http://www.mocky.io/v2/598b16861100004905515ec7", HistoricoDto[].class);

		List<HistoricoDto> historico = Arrays.asList(response.getBody());
		historico.forEach(hist -> converterParaPersistir(hist));

		return HttpStatus.OK;
	}

	private void converterParaPersistir(HistoricoDto hist) {
		HistoricoCompras historico = new HistoricoCompras();
		historico.setCodigo(hist.getCodigo());
		historico.setData(hist.getData());

		String cpf = hist.getCliente().replace(".", "");
		cpf = cpf.length() == 11 ? cpf : cpf.substring(1);
		Cliente cliente = this.clienteService.findByCpf(cpf);
		log.info("Buscando cliente com cpf: {}", cpf);
		if (cliente != null) {
			log.info("Encontrado cliente: {}", cliente.getCpf());
			historico.setCliente(cliente);
			historico.setValorTotal(hist.getValorTotal());
			this.historicoComprasService.persistir(historico);

			log.info("Persistindo historico: {}", historico.getId());
			List<Item> itens = new ArrayList<>();

			for (ProdutoDto produto : hist.getItens()) {
				Item item = this.produtoService.findByProdutoAndVariedadeAndSafra(produto.getProduto(),
						produto.getVariedade(), produto.getSafra());
				if (item == null) {
					item = new Item();
					item.setPais(produto.getPais());
					item.setCategoria(produto.getCategoria());
					item.setPreco(produto.getPreco());
					item.setVariedade(produto.getVariedade());
					item.setSafra(produto.getSafra());
					item.setProduto(produto.getProduto());
					log.info("Persistindo item: {}", item.toString());
					this.produtoService.persistir(item);
				}
				itens.add(item);
			}

			for (Item item : itens) {
				Itens itensLista = new Itens();
				itensLista.setItem(item);
				itensLista.setHistoricoCompras(historico);
				this.itensService.persistir(itensLista);
			}
		}
		log.info("Persistencia do historico.");
	}
}
