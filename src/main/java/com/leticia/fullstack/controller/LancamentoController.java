package com.leticia.fullstack.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leticia.fullstack.model.Lancamento;
import com.leticia.fullstack.repositories.LancamentoRepository;

@RestController
public class LancamentoController {

	@Autowired
	LancamentoRepository lancamentoRepository;

	@GetMapping("/lancamento")
	public ResponseEntity<List<Lancamento>> findAll() {
		List<Lancamento> lancamentoList = lancamentoRepository.findAll();

		if (lancamentoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Lancamento>>(lancamentoList, HttpStatus.OK);
		}
	}

	@GetMapping("/lancamento/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable(value = "id") long id) {
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Lancamento>(optional.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/lancamento")
	public ResponseEntity<Lancamento> incluirLancamento(@RequestBody @Valid Lancamento lancamento) {
		return new ResponseEntity<Lancamento>(lancamentoRepository.save(lancamento), HttpStatus.CREATED);
	}

	@DeleteMapping("/lancamento/{id}")
	public ResponseEntity<?> deletarLancamento(@PathVariable(value = "id") long id) {
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			lancamentoRepository.delete(optional.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/lancamento/{id}")
	public ResponseEntity<Lancamento> atualizarLancamento(@PathVariable(value = "id") long id,
			@RequestBody @Valid Lancamento lancamento) {

		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			lancamento.setCodProtocolo(optional.get().getCodProtocolo());
			return new ResponseEntity<Lancamento>(lancamentoRepository.save(lancamento), HttpStatus.OK);
		}

	}

}
