package com.leticia.fullstack.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.leticia.fullstack.model.Lancamento;
import com.leticia.fullstack.model.Liquidacao;
import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.LancamentoRepository;
import com.leticia.fullstack.repositories.LiquidacaoRepository;
import com.leticia.fullstack.repositories.PessoaRepository;

public class FileReader {

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	LiquidacaoRepository liquidacaoRepository;

	@Autowired
	LancamentoRepository lancamentoRepository;

	public void lerArquivo(File file) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try (BufferedReader bf = new BufferedReader(new java.io.FileReader(file))) {
			String line = bf.readLine();
			line = bf.readLine();

			if (line == null) {
				throw new NullPointerException();
			}

			while (line != null) {
				String[] arrayString = new String[5];
				arrayString = line.split(",");
				String liquidacaoCatched = arrayString[0];
				String nomePessoa = arrayString[1];
				String nuCpfCnpjPessoa = arrayString[2];
				String tpPessoa = arrayString[3];
				String valorOperacao = arrayString[4];
				Date dataLancamento = sdf.parse(arrayString[5]);

				char tpPessoaChar = tpPessoa.charAt(0);
				BigDecimal valorConvertido = new BigDecimal(valorOperacao);
				assertEquals(new BigDecimal(valorOperacao), valorConvertido);

				Pessoa pessoa = (Pessoa) pessoaRepository.findAll().stream()
						.filter(p -> p.getNuCpfCnpj().equals(nuCpfCnpjPessoa));

				if (pessoa == null) {
					pessoa = new Pessoa(nuCpfCnpjPessoa, nomePessoa, tpPessoaChar);
					pessoaRepository.save(pessoa);
				}

				Liquidacao liquidacao = (Liquidacao) liquidacaoRepository.findAll().stream()
						.filter(l -> l.getNmLiquidacao().equals(liquidacaoCatched));

				if (liquidacao == null) {
					liquidacao = new Liquidacao(liquidacaoCatched);
					liquidacaoRepository.save(liquidacao);
				}

				Lancamento lancamento = new Lancamento(liquidacao, pessoa, valorConvertido, dataLancamento);
				lancamentoRepository.save(lancamento);
				line = bf.readLine();

			}

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}

	}

}
