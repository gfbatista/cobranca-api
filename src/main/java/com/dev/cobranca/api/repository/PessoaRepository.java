package com.dev.cobranca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.cobranca.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>	 {

}
