package com.leticia.fullstack.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Lancamento extends RepresentationModel<Lancamento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codProtocolo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Liquidacao liquidacao;

	@ManyToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	private double valorOperacao;

	private String dataLancamento;

	public Lancamento(int codProtocolo, Liquidacao liquidacao, Pessoa pessoa, double valorOperacao,
			String dataLancamento) {
		super();
		this.codProtocolo = codProtocolo;
		this.liquidacao = liquidacao;
		this.pessoa = pessoa;
		this.valorOperacao = valorOperacao;
		this.dataLancamento = dataLancamento;
	}

	public Lancamento(Liquidacao liquidacao, Pessoa pessoa, double valorOperacao, String dataLancamento) {
		super();
		this.liquidacao = liquidacao;
		this.pessoa = pessoa;
		this.valorOperacao = valorOperacao;
		this.dataLancamento = dataLancamento;
	}

	public Lancamento() {
	}

	public int getCodProtocolo() {
		return codProtocolo;
	}

	public void setCodProtocolo(int codProtocolo) {
		this.codProtocolo = codProtocolo;
	}

	public Liquidacao getLiquidacao() {
		return liquidacao;
	}

	public void setLiquidacao(Liquidacao liquidacao) {
		this.liquidacao = liquidacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
