package br.com.cep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cep.contrat.dto.CepFilter;
import br.com.cep.model.Cep;
import br.com.cep.repository.CepRepository;
import br.com.cep.repository.CidadeRepository;

@Service
public class CepService {

	@Autowired
	private CepRepository cepRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	public Cep findCep(String cep) {
		return cepRepository.findById(cep).get();
	}

	public List<Cep> findCeps(CepFilter cepFilter) {
		if (cepFilter.getUf() == null) {
			return cepRepository.findByIbge(cepFilter.getIbge());
		}

		return cepRepository.findByUfAndIbge(cepFilter.getIbge(), cepFilter.getUf());

	}

}
