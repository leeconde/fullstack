package com.leticia.fullstack.dto;

import com.leticia.fullstack.model.Pessoa;

public class PessoaDto {

	private Long cdPessoa;

	private String nuCpfCnpj;

	private String nmPessoa;

	private char tpPessoa;

	public PessoaDto() {
	}

	public PessoaDto(Long cdPessoa, String nuCpfCnpj, String nmPessoa, char tpPessoa) {
		this.cdPessoa = cdPessoa;
		this.nuCpfCnpj = nuCpfCnpj;
		this.nmPessoa = nmPessoa;
		this.tpPessoa = tpPessoa;
	}

	public PessoaDto(String nuCpfCnpj, String nmPessoa, char tpPessoa) {
		this.nuCpfCnpj = nuCpfCnpj;
		this.nmPessoa = nmPessoa;
		this.tpPessoa = tpPessoa;
	}

	public PessoaDto(Pessoa pessoa) {
		nuCpfCnpj = pessoa.getNuCpfCnpj();
		nmPessoa = pessoa.getNmPessoa();
		tpPessoa = pessoa.getTpPessoa();
	}

	public Long getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Long cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

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

}
