package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.ProjektDao;
import com.capgemini.domain.ProjektEntity;
import com.capgemini.service.ProjektService;

@Service
// @Transactional(readOnly = true)
public class ProjektServiceImpl implements ProjektService {

	@Autowired
	private ProjektDao projektRepository;

	@Override
	public ProjektEntity dodajProjekt(ProjektEntity projekt) {
		return projektRepository.save(projekt);
	}

	@Override
	public void usunProjekt(Long projektId) {
		projektRepository.delete(projektId);
	}

	@Override
	public ProjektEntity edytujProjekt(ProjektEntity projekt) {
		return projektRepository.update(projekt);
	}

	@Transactional(readOnly = true)
	@Override
	public ProjektEntity znajdzProjektPoId(Long projektId) {
		return projektRepository.findOne(projektId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProjektEntity> znajdzWszystkieProjekty() {
		return projektRepository.findAll();
	}
}
