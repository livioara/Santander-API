package com.livioara.santander.bankline.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livioara.santander.bankline.api.dto.NovaMovimentacao;
import com.livioara.santander.bankline.api.model.Correntista;
import com.livioara.santander.bankline.api.model.Movimentacao;
import com.livioara.santander.bankline.api.model.MovimentacaoTipo;
import com.livioara.santander.bankline.api.repository.CorrentistaRepository;
import com.livioara.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	
	
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() :novaMovimentacao.getValor() *-1;
		
		movimentacao.setDatahora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setId(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if (correntista != null ) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
 		
		repository.save(movimentacao);
		
	}
}
