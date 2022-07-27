package com.leticia.fullstack.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.PessoaRepository;

public class PessoaForm {

	@NotNull
	@NotEmpty
	@Length(min = 11, max = 14)
	private String nuCpfCnpj;

	@NotNull
	@NotEmpty
	private String nmPessoa;

	private char tpPessoa;

	public String getNuCpfCnpj() {
		return nuCpfCnpj;
	}

	public void setNuCpfCnpj(String nuCpfCnpj) {
		this.nuCpfCnpj = nuCpfCnpj;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public char getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(char tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public Pessoa converter(PessoaRepository repository) {
		Pessoa pessoa = repository.findByNuCpfCnpj(getNuCpfCnpj());
		return new Pessoa(nuCpfCnpj, nmPessoa, tpPessoa);
	}

	public Pessoa atualizar(Long id, PessoaRepository repository) {
		Pessoa pessoa = repository.getById(id);
		pessoa.setNmPessoa(nmPessoa);
		pessoa.setNuCpfCnpj(nuCpfCnpj);
		pessoa.setTpPessoa(tpPessoa);
		return pessoa;
	}

}
