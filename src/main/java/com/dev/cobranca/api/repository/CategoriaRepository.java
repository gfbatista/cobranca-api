package com.dev.cobranca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.cobranca.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>	 {

}
