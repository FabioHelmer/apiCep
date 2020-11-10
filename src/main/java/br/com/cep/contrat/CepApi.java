package br.com.cep.contrat;


import br.com.cep.contrat.dto.CepFilter;
import br.com.cep.model.Cep;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value= "/")
@CrossOrigin(origins = "*")
public interface CepApi {

    
    @GetMapping(value= "/cep/{cep}")
    public ResponseEntity<Cep> findUniqueCep(@PathVariable("cep") final String cep );

    
    @GetMapping(value= "/ceps")
    public ResponseEntity<List<Cep>> findAllCeps(@SpringQueryMap @Valid final CepFilter filters);

}
