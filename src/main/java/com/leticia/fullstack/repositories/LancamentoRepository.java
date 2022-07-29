package com.leticia.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leticia.fullstack.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
