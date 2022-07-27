package com.leticia.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leticia.fullstack.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByNmPessoa(String nome);

	Pessoa findByNuCpfCnpj(String nuCpfCnpj);

}
