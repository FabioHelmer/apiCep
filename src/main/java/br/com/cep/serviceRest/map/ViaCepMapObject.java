package br.com.cep.serviceRest.map;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.model.dto.CepResponse;
import org.springframework.stereotype.Component;

@Component
public class ViaCepMapObject {

    //Mapear o Objeto JSON
    public Cep viacepMapRespToCep(CepResponse cepResponse) {

    	Cidade cidade = new Cidade();
    	cidade.setIbge(cepResponse.getIbge());
    	cidade.setLocalidade(cepResponse.getLocalidade());
    	cidade.setUf(cepResponse.getUf());
    	
    	Cep response = new Cep();
    	response.setCep(cepResponse.getCep());
    	response.setBairro(cepResponse.getBairro());
    	response.setComplemento(cepResponse.getComplemento());
    	response.setLogradouro(cepResponse.getLogradouro());
    	response.setIbge(cidade);
    	
        return response;
    }
}
