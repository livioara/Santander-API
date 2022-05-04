package com.livioara.santander.bankline.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livioara.santander.bankline.api.dto.NovoCorrentista;
import com.livioara.santander.bankline.api.model.Conta;
import com.livioara.santander.bankline.api.model.Correntista;
import com.livioara.santander.bankline.api.repository.CorrentistaRepository;

@Service
public class CorrentisaService {

	@Autowired
	private CorrentistaRepository repository;
	public void save(NovoCorrentista novocorrentista) {
		
		Correntista correntista = new Correntista();
		correntista.setCpf(novocorrentista.getCpf());
		correntista.setNome(novocorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
	}
}
