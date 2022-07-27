package com.leticia.fullstack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leticia.fullstack.model.Liquidacao;

public interface LiquidacaoRepository extends JpaRepository<Liquidacao, Long> {

	List<Liquidacao> findByNmLiquidacao(String nome);

}
