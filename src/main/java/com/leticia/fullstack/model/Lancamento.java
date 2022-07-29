package com.leticia.fullstack.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Lancamento extends RepresentationModel<Lancamento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProtocolo;

	@OneToOne
	private Liquidacao liquidacao;

	@OneToOne
	private Pessoa pessoa;

	private BigDecimal valorOperacao;

	private Date dataLancamento;

	public Lancamento(Long codProtocolo, Liquidacao liquidacao, Pessoa pessoa, BigDecimal valorOperacao,
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

	public Long getCodProtocolo() {
		return codProtocolo;
	}

	public void setCodProtocolo(Long codProtocolo) {
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
