package com.livioara.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livioara.santander.bankline.api.dto.NovoCorrentista;
import com.livioara.santander.bankline.api.model.Correntista;
import com.livioara.santander.bankline.api.repository.CorrentistaRepository;
import com.livioara.santander.bankline.api.services.CorrentisaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentisaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}
}
