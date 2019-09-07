package com.dev.cobranca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.cobranca.api.model.Lancamento;
import com.dev.cobranca.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery	 {

}
