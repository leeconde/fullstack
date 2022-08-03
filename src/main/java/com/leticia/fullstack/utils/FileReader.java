package com.leticia.fullstack.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.leticia.fullstack.model.Lancamento;
import com.leticia.fullstack.model.Liquidacao;
import com.leticia.fullstack.model.Pessoa;
import com.leticia.fullstack.repositories.LancamentoRepository;
import com.leticia.fullstack.repositories.LiquidacaoRepository;
import com.leticia.fullstack.repositories.PessoaRepository;

public class FileReader {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private LiquidacaoRepository liquidacaoRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	String path = "C:\\Users\\Leticia\\Documents\\tmp\\Importar.txt";

	List<Lancamento> lancamentoList = new ArrayList<Lancamento>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public void lerArquivo() throws ParseException {
		try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				String liquidacaoCatched = vect[0];
				String nomePessoa = vect[1];
				String nuCpfCnpjPessoa = vect[2];
				String tpPessoa = vect[3];
				Double valorOperacao = Double.parseDouble(vect[4]);
				Date dataLancamento = sdf.parse(vect[5]);

				char tpPessoaChar = tpPessoa.charAt(0);

				Pessoa pessoa = pessoaRepository.findAll().stream()
						.filter(p -> p.getNuCpfCnpj().equals(nuCpfCnpjPessoa)).findFirst()
						.orElse(new Pessoa(nuCpfCnpjPessoa, nomePessoa, tpPessoaChar));

				Liquidacao liquidacao = liquidacaoRepository.findByNmLiquidacao(liquidacaoCatched);
				Lancamento lancamento = new Lancamento(liquidacao, pessoa, valorOperacao, dataLancamento);
				lancamentoRepository.save(lancamento);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
