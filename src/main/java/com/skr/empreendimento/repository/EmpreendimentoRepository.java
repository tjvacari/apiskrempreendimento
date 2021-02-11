package com.skr.empreendimento.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skr.empreendimento.dto.EmpreendimentoDTO;
import com.skr.empreendimento.orm.Empreendimento;

@Repository
public interface EmpreendimentoRepository extends CrudRepository<Empreendimento, Integer> {
	
	@Query(value = "select id, nome, descricao, url_imagem as urlImagem from empreendimento", nativeQuery = true)
	List<EmpreendimentoDTO> findAllEmpreendimentoTO(Pageable pageable);
	
	@Query(value = "select id, nome, descricao, url_imagem as urlImagem from empreendimento where id_categoria in (:idsCategoria) or id_tipo in (:idsTipo)", nativeQuery = true)
	List<EmpreendimentoDTO> findEmpreendimentoTO(List<Integer> idsTipo, List<Integer> idsCategoria, Pageable pageable);
	
	@Query(value = "select imagem from empreendimento where id = :idEmpreendimento", nativeQuery = true)
	byte[] findImagem(Integer idEmpreendimento);

}
