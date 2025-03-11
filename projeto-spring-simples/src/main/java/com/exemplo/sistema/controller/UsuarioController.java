package com.exemplo.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.sistema.model.Pessoa;
import com.exemplo.sistema.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class UsuarioController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaService.listar();
    }

    @PostMapping
    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
        return pessoaService.adicionar(pessoa);
    }
    
//    @PostMapping
//    public ResponseEntity<String> adicionar(@RequestBody Pessoa pessoa) {
//    	
//    	try {
//    		pessoaService.adicionar(pessoa);
//            return ResponseEntity.ok("Pessoa salva com sucesso!");
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO!!!");
//		}
//    	
//    }
    
    
}