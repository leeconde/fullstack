package com.leticia.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Liquidacao extends RepresentationModel<Liquidacao> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdLiquidacao;

	private String nmLiquidacao;

	public Liquidacao(Long cdLiquidacao, String nmLiquidacao) {
		this.cdLiquidacao = cdLiquidacao;
		this.nmLiquidacao = nmLiquidacao;
	}

	public Liquidacao(String nmLiquidacao) {
		super();
		this.nmLiquidacao = nmLiquidacao;
	}

	public Liquidacao() {
	}

	public Long getCdLiquidacao() {
		return cdLiquidacao;
	}

	public void setCdLiquidacao(Long cdLiquidacao) {
		this.cdLiquidacao = cdLiquidacao;
	}

	public String getNmLiquidacao() {
		return nmLiquidacao;
	}

	public void setNmLiquidacao(String nmLiquidacao) {
		this.nmLiquidacao = nmLiquidacao;
	}

}
