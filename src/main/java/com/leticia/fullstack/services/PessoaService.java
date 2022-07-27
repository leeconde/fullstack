package com.leticia.fullstack.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leticia.fullstack.dto.PessoaDto;
import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional
	public PessoaDto findById(Long id) {
		Pessoa entity = repository.findById(id).get();
		PessoaDto dto = new PessoaDto(entity);
		return dto;
	}

}
