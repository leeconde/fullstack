package com.leticia.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leticia.fullstack.model.Liquidacao;

@Repository
public interface LiquidacaoRepository extends JpaRepository<Liquidacao, Long> {

	Liquidacao findByNmLiquidacao(String nome);

}
