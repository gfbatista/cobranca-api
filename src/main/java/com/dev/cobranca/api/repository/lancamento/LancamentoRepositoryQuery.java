package com.dev.cobranca.api.repository.lancamento;

import java.util.List;

import com.dev.cobranca.api.model.Lancamento;
import com.dev.cobranca.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
