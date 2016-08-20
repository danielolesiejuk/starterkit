package com.capgemini.service;

import com.capgemini.domain.ProjektEntity;

public interface ProjektService {
	
	ProjektEntity dodajProjekt();
	ProjektEntity usunProjekt();
	ProjektEntity edytujProjekt();
	
}
