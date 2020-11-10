package br.com.cep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cep.model.Cidade;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface CidadeRepository  extends JpaRepository<Cidade, String>{


    @Query("SELECT cidade FROM Cidade cidade WHERE cidade.ibge = :ibge")
    List<Cidade> findByCidade(@Param(value = "ibge") String ibge);
    
}
