package com.skr.empreendimento.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.skr.empreendimento.dto.EmpreendimentoDTO;
import com.skr.empreendimento.dto.FiltroDTO;
import com.skr.empreendimento.repository.CategoriaRepository;
import com.skr.empreendimento.repository.EmpreendimentoRepository;
import com.skr.empreendimento.repository.TipoRepository;

@Path("/empreendimento")
public class EmpreendimentoRest {

	@Autowired
	private CategoriaRepository categoriRespository;

	@Autowired
	private EmpreendimentoRepository empreendimentoRespository;

	@Autowired
	private TipoRepository tipoRespository;

	@GET
	@Path("/empreendimento")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpreendimentoDTO> empreendimento(@QueryParam(value = "idsCategoria") List<Integer> idsCategoria,
			@QueryParam(value = "idsTipo") List<Integer> idsTipo, @QueryParam(value = "page") Integer page, @QueryParam(value = "max") Integer max) {
		Pageable pageable = PageRequest.of(page, max, Sort.by(Sort.Direction.ASC, "nome"));
		
		// retorna todos pois não aplicou filtro
		if ((idsTipo == null && idsCategoria == null) || (idsCategoria.isEmpty() && idsTipo.isEmpty())) {
			return empreendimentoRespository.findAllEmpreendimentoTO(pageable);
		}
		return empreendimentoRespository.findEmpreendimentoTO(idsTipo, idsCategoria, pageable);
	}

	@GET
	@Path("/filtro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FiltroDTO> filtro() {
		List<FiltroDTO> filtroList = categoriRespository.findAllCategoriaTO("categoria");
		filtroList.addAll(tipoRespository.findAllTipoTO("tipo"));
		return filtroList;
	}
	
}
