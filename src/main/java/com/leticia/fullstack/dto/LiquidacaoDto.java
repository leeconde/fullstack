package com.leticia.fullstack.dto;

import com.leticia.fullstack.model.Liquidacao;

public class LiquidacaoDto {

	private Long cdLiquidacao;

	private String nmLiquidacao;

	public LiquidacaoDto(Long cdLiquidacao, String nmLiquidacao) {
		this.cdLiquidacao = cdLiquidacao;
		this.nmLiquidacao = nmLiquidacao;
	}

	public LiquidacaoDto() {
		super();
	}

	public LiquidacaoDto(Liquidacao liquidacao) {
		nmLiquidacao = liquidacao.getNmLiquidacao();
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
