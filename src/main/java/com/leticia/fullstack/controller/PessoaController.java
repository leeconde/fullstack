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

import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> pessoaList = pessoaRepository.findAll();

		if (pessoaList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for (Pessoa pessoa : pessoaList) {
				int cdPessoa = pessoa.getCdPessoa();
				pessoa.add(WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).findById(cdPessoa)).withSelfRel());
			}
			return new ResponseEntity<List<Pessoa>>(pessoaList, HttpStatus.OK);
		}
	}

	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable(value = "id") int id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			optional.get().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).findAll())
					.withRel("Lista de Pessoas"));
			return new ResponseEntity<Pessoa>(optional.get(), HttpStatus.OK);
		}
	}

	@GetMapping("/pessoa/documento/{nuCpfCnpj}")
	public ResponseEntity<Pessoa> findBy(@PathVariable("nuCpfCnpj") String nuCpfCnpj) {
		Optional<Pessoa> optional = pessoaRepository.findByNuCpfCnpj(nuCpfCnpj);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			optional.get().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).findAll())
					.withRel("Lista de Pessoas"));
			return new ResponseEntity<Pessoa>(optional.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> incluirPessoa(@RequestBody @Valid Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaRepository.save(pessoa), HttpStatus.CREATED);
	}

	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<?> deletarPessoa(@PathVariable(value = "id") int id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pessoaRepository.delete(optional.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable(value = "id") int id,
			@RequestBody @Valid Pessoa pessoa) {

		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pessoa.setCdPessoa(optional.get().getCdPessoa());
			return new ResponseEntity<Pessoa>(pessoaRepository.save(pessoa), HttpStatus.OK);
		}

	}

}
