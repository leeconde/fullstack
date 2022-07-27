package com.leticia.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leticia.fullstack.dto.LiquidacaoDto;
import com.leticia.fullstack.model.Liquidacao;
import com.leticia.fullstack.repositories.LiquidacaoRepository;
import com.leticia.fullstack.services.LiquidacaoService;

@RestController
@RequestMapping(value = "/liquidacao")
public class LiquidacaoController {

	@Autowired
	private LiquidacaoRepository repository;

	@Autowired
	private LiquidacaoService service;

	@GetMapping
	public List<Liquidacao> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/id/{id}")
	public LiquidacaoDto findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
