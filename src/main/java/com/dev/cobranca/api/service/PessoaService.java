package com.dev.cobranca.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dev.cobranca.api.model.Pessoa;
import com.dev.cobranca.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa buscarCodigo(Long codigo) {
		return pessoaRepository.findOne(codigo);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);

		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public void deletar(Long codigo) {
		pessoaRepository.delete(codigo);
	}

	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

}
