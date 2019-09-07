package com.dev.cobranca.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dev.cobranca.api.model.Lancamento;
import com.dev.cobranca.api.model.Pessoa;
import com.dev.cobranca.api.repository.LancamentoRepository;
import com.dev.cobranca.api.repository.PessoaRepository;
import com.dev.cobranca.api.repository.filter.LancamentoFilter;
import com.dev.cobranca.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Lancamento> listar(LancamentoFilter lancamentoFilter) {
		return lancamentoRepository.filtrar(lancamentoFilter);
	}

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if ((pessoa == null) || (pessoa.isInativo())) {
			throw new PessoaInexistenteOuInativaException();
		}

		return lancamentoRepository.save(lancamento);
	}

	public Lancamento buscarCodigo(Long codigo) {
		return lancamentoRepository.findOne(codigo);
	}

	public void deletar(Long codigo) {
		lancamentoRepository.delete(codigo);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoPeloCodigo(codigo);

		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
	}

	private Lancamento buscarLancamentoPeloCodigo(Long codigo) {
		Lancamento lancamentoSalvo = lancamentoRepository.findOne(codigo);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoSalvo;
	}

}
