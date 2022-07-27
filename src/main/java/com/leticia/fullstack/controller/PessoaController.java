package com.leticia.fullstack.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leticia.fullstack.dto.PessoaDto;
import com.leticia.fullstack.form.PessoaForm;
import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.PessoaRepository;
import com.leticia.fullstack.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@Autowired
	private PessoaRepository repository;

	@GetMapping(value = "/id/{id}")
	public PessoaDto findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.converter(repository);
		repository.save(pessoa);

		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getCdPessoa()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id, @RequestBody @Valid PessoaForm form) {
		Optional<Pessoa> optional = repository.findById(id);
		if (optional.isPresent()) {
			Pessoa pessoa = form.atualizar(id, repository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pessoa> optional = repository.findById(id);

		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
