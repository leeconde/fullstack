package com.leticia.fullstack.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Pessoa extends RepresentationModel<Pessoa> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cdPessoa;

	private String nuCpfCnpj;

	private String nmPessoa;

	private char tpPessoa;

	public Pessoa() {
	}

	public Pessoa(int cdPessoa, String nuCpfCnpj, String nmPessoa, char tpPessoa) {
		this.cdPessoa = cdPessoa;
		this.nuCpfCnpj = nuCpfCnpj;
		this.nmPessoa = nmPessoa;
		this.tpPessoa = tpPessoa;
	}

	public Pessoa(String nuCpfCnpj, String nmPessoa, char tpPessoa) {
		this.nuCpfCnpj = nuCpfCnpj;
		this.nmPessoa = nmPessoa;
		this.tpPessoa = tpPessoa;
	}

	public int getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(int cdPessoa) {
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
