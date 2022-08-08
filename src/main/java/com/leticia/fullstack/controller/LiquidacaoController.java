package com.leticia.fullstack.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leticia.fullstack.model.Liquidacao;
import com.leticia.fullstack.repositories.LiquidacaoRepository;

@RestController
public class LiquidacaoController {

	@Autowired
	private LiquidacaoRepository liquidacaoRepository;

	@GetMapping("/liquidacao")
	public ResponseEntity<List<Liquidacao>> findAll() {
		List<Liquidacao> liquidacaoList = liquidacaoRepository.findAll();

		if (liquidacaoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for (Liquidacao liquidacao : liquidacaoList) {
				long cdLiquidacao = liquidacao.getCdLiquidacao();
				liquidacao.add(WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(LiquidacaoController.class).findById(cdLiquidacao))
						.withSelfRel());
			}
			return new ResponseEntity<List<Liquidacao>>(liquidacaoList, HttpStatus.OK);
		}
	}

	@GetMapping("/liquidacao/{id}")
	public ResponseEntity<Liquidacao> findById(@PathVariable(value = "id") long id) {
		Optional<Liquidacao> optional = liquidacaoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			optional.get()
					.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LiquidacaoController.class).findAll())
							.withRel("Lista de Liquidacoes"));
			return new ResponseEntity<Liquidacao>(optional.get(), HttpStatus.OK);
		}
	}

	@GetMapping("/liquidacao/nome/{name}")
	public ResponseEntity<Liquidacao> findByName(@PathVariable("name") String nmLiquidacao) {
		Optional<Liquidacao> optional = liquidacaoRepository.findByNmLiquidacao(nmLiquidacao);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			optional.get()
					.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LiquidacaoController.class).findAll())
							.withRel("Lista de Liquidacoes"));
			return new ResponseEntity<Liquidacao>(optional.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/liquidacao")
	public ResponseEntity<Liquidacao> incluirLiquidacao(@RequestBody @Valid Liquidacao liquidacao) {
		return new ResponseEntity<Liquidacao>(liquidacaoRepository.save(liquidacao), HttpStatus.CREATED);
	}

	@DeleteMapping("/liquidacao/{id}")
	public ResponseEntity<?> deletarLiquidacao(@PathVariable(value = "id") long id) {
		Optional<Liquidacao> optional = liquidacaoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			liquidacaoRepository.delete(optional.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/liquidacao/{id}")
	public ResponseEntity<Liquidacao> atualizarLiquidacao(@PathVariable(value = "id") long id,
			@RequestBody @Valid Liquidacao liquidacao) {

		Optional<Liquidacao> optional = liquidacaoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			liquidacao.setCdLiquidacao(optional.get().getCdLiquidacao());
			return new ResponseEntity<Liquidacao>(liquidacaoRepository.save(liquidacao), HttpStatus.OK);
		}

	}
}
