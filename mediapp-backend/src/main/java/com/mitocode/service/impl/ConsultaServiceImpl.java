package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.model.Consulta;
import com.mitocode.model.DetalleConsulta;
import com.mitocode.repo.IConsultaExamenRepo;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {

	@Autowired
	private IConsultaRepo repo;

	@Autowired
	private IConsultaExamenRepo ceRepo;

	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(Consulta consulta) {

		/*
		 * for(DetalleConsulta det : consulta.getDetalleConsulta()) {
		 * det.setConsulta(consulta); }
		 */
		// dto.getConsulta().getDetalleConsulta().forEach(det ->
		// det.setConsulta(dto.getConsulta()));

		/*
		 * for (DetalleConsulta det: dto.getConsulta().getDetalleConsulta()) {
		 * det.setConsulta(det.getConsulta());
		 * 
		 * }
		 */

		// repo.save(dto.getConsulta());

		// dto.getLstExamen().forEach(ex ->
		// ceRepo.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));

		// return dto.getConsulta();
		consulta.getDetalleConsulta().forEach(det -> det.setConsulta(consulta));

		for (DetalleConsulta det : consulta.getDetalleConsulta()) {
			det.setConsulta(consulta);
		}

		return repo.save(consulta);

	}

}
