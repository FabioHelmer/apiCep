package br.com.cep.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.cep.contrat.dto.CepFilter;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;

@RestController
public class CepController {

	@Autowired
	private CepService cepService;
	
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<Cep> findUniqueCep(@PathVariable("cep") String cep ){
		return ResponseEntity.ok(cepService.findCep(cep));
	}

	@GetMapping("/ceps?ibge={ibge}&uf={uf}")
	public ResponseEntity<List<Cep>> findAllCeps(@Valid CepFilter cepFilter) {
		return ResponseEntity.ok(cepService.findCeps(cepFilter));
	}

}
