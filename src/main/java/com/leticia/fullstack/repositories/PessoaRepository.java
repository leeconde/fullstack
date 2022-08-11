package com.leticia.fullstack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leticia.fullstack.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Pessoa findByNmPessoa(String nome);

	Optional<Pessoa> findByNuCpfCnpj(String nuCpfCnpj);

}
