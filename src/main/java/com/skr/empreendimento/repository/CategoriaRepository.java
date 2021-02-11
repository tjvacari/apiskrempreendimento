package com.skr.empreendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skr.empreendimento.dto.EmpreendimentoDTO;
import com.skr.empreendimento.dto.FiltroDTO;
import com.skr.empreendimento.orm.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

	@Query(value = "select id, descricao, :tipo as tipo from categoria order by descricao", nativeQuery = true)
	List<FiltroDTO> findAllCategoriaTO(String tipo);
	
}
