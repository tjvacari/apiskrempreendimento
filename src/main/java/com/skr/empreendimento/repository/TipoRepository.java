package com.skr.empreendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skr.empreendimento.dto.FiltroDTO;
import com.skr.empreendimento.orm.Tipo;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, Integer> {
	
	@Query(value = "select id, descricao, :tipo as tipo from tipo order by descricao", nativeQuery = true)
	List<FiltroDTO> findAllTipoTO(String tipo);

}
