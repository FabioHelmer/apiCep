package br.com.cep.serviceRest;

import br.com.cep.model.dto.CepResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepService {

    //Declarando a Base URL e o tipo de Formato que ira receber
    @Value("${viacep.url}")
    private String viacep_url_base ;
    @Value("${viacep.type-format}")
    private String viacep_type_format ;

    public CepResponse findCep(String cep){
        String uri = viacep_url_base.concat(cep).concat(viacep_type_format);
        return restTemplate().getForObject(uri, CepResponse.class);
    }

    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
