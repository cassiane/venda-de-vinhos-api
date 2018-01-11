package com.project.vendadevinhos.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.vendadevinhos.api.dtos.HistoricoDto;
import com.project.vendadevinhos.api.dtos.ProdutoDto;
import com.project.vendadevinhos.api.entities.HistoricoCompras;
import com.project.vendadevinhos.api.entities.Produto;
import com.project.vendadevinhos.api.response.Response;
import com.project.vendadevinhos.services.HistoricoComprasService;
import com.project.vendadevinhos.services.ProdutoService;

@RestController
@RequestMapping("/api/historicoCompras")
public class HistoricoController {

	private static final Logger log = LoggerFactory.getLogger(HistoricoController.class);

	@Autowired
	private HistoricoComprasService historicoComprasService;
	
	@Autowired
	private ProdutoService produtoService;

	@PostMapping(value = "/inicializar")
	public HttpStatus inicializar() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<HistoricoDto[]> response = restTemplate.getForEntity(
				"http://www.mocky.io/v2/598b16861100004905515ec7", HistoricoDto[].class);
		
		List<HistoricoDto> historico = Arrays.asList(response.getBody());
		historico.forEach(hist -> converterParaPersistir(hist));
		historico.forEach(hist -> System.out.println(hist.toString()));
		
		
		return HttpStatus.OK;
	}

	private void converterParaPersistir(HistoricoDto hist) {
		HistoricoCompras historico = new HistoricoCompras();
		historico.setCodigo(hist.getCodigo());
		historico.setData(hist.getData());
		historico.setCliente(hist.getCliente());
		this.historicoComprasService.persistir(historico);
		List<Produto> itens = new ArrayList<>(); 
		for (ProdutoDto produto : hist.getItens()) {
			Produto prod = this.produtoService.findByProduto(produto.getProduto());
			if (prod == null) {
				prod = new Produto();
				prod.setPais(produto.getPais());
				prod.setCategoria(produto.getCategoria());
				prod.setPreco(produto.getPreco());
				prod.setVariedade(produto.getVariedade());
				prod.setSafra(produto.getSafra());
				prod.setProduto(produto.getProduto());
				this.produtoService.persistir(prod);
			}			
			itens.add(prod);
		}
		historico.setItens(itens);
		this.historicoComprasService.persistir(historico);
	}

	@GetMapping(value = "/listarTodos")
	public ResponseEntity<Response<List<Produto>>> listarTodos() {
		log.info("Listando todos os históricos");

		Response<List<Produto>> response = new Response<>();
		List<HistoricoCompras> historico = this.historicoComprasService.listarTodos();
		List<Produto> prd = this.produtoService.listarTodos();
		response.setData(prd);

		return ResponseEntity.ok(response);
	}
}
