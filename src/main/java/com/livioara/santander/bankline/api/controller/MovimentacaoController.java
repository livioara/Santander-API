package com.livioara.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livioara.santander.bankline.api.dto.NovaMovimentacao;
import com.livioara.santander.bankline.api.dto.NovoCorrentista;
import com.livioara.santander.bankline.api.model.Correntista;
import com.livioara.santander.bankline.api.model.Movimentacao;
import com.livioara.santander.bankline.api.repository.CorrentistaRepository;
import com.livioara.santander.bankline.api.repository.MovimentacaoRepository;
import com.livioara.santander.bankline.api.services.CorrentisaService;
import com.livioara.santander.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}
}
