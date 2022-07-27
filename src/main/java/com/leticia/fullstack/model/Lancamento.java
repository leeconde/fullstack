package com.leticia.fullstack.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codProtocolo;

	@OneToOne
	private Liquidacao liquidacao;

	@OneToOne
	private Pessoa pessoa;

	private BigDecimal valorOperacao;

	private Date dataLancamento;

	public Lancamento(int codProtocolo, Liquidacao liquidacao, Pessoa pessoa, BigDecimal valorOperacao,
			Date dataLancamento) {
		super();
		this.codProtocolo = codProtocolo;
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

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
