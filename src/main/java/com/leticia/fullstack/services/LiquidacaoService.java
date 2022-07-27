package com.leticia.fullstack.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leticia.fullstack.dto.LiquidacaoDto;
import com.leticia.fullstack.model.Liquidacao;
import com.leticia.fullstack.repositories.LiquidacaoRepository;

@Service
public class LiquidacaoService {

	@Autowired
	private LiquidacaoRepository repository;

	@Transactional
	public LiquidacaoDto findById(Long id) {
		Liquidacao entity = repository.findById(id).get();
		LiquidacaoDto dto = new LiquidacaoDto(entity);
		return dto;
	}
}
