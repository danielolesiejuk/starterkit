package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.ProjektEntity;

public interface ProjektService {
	
	ProjektEntity dodajProjekt(ProjektEntity projekt);
	void usunProjekt(Long projektId);
	ProjektEntity edytujProjekt(ProjektEntity projekt);
	ProjektEntity znajdzProjektPoId(Long projektId);
	List<ProjektEntity> znajdzWszystkieProjekty();
}
