package br.com.cep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import br.com.cep.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, String>{

	@Query("SELECT cep FROM Cep cep" +
            " WHERE cep.cidade.ibge = :ibge AND cep.cidade.uf = :uf")
	List<Cep> findByUfAndIbge(@Param(value = "ibge")  String ibge, @Param(value = "uf")  String uf);

	 @Query("SELECT cep FROM Cep cep" +
	            " WHERE cep.cidade.ibge = :ibge")
	List<Cep> findByIbge(@Param(value = "ibge") String ibge);
}
