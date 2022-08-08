package com.leticia.fullstack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leticia.fullstack.model.Liquidacao;

@Repository
public interface LiquidacaoRepository extends JpaRepository<Liquidacao, Long> {

	Optional<Liquidacao> findByNmLiquidacao(String nome);

}
