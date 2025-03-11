package com.exemplo.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exemplo.sistema.model.Pessoa;
import com.exemplo.sistema.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  @GetMapping
  public List<Pessoa> listar() {
      return pessoaRepository.findAll();
  }

  @PostMapping
  public Pessoa adicionar(@RequestBody Pessoa pessoa) {
	  corrigirCpfPessoa(pessoa);
	  
      return pessoaRepository.save(pessoa);
  }
  
  
  private void corrigirCpfPessoa(Pessoa pessoa) {
	  if(pessoa.getCpf() != null) {
		  pessoa.setCpf(pessoa.getCpf().replaceAll("\\D", ""));
	  }
  }
}
