package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Pracownik2ProjektEntity;

public interface Pracownik2ProjektService {

	Pracownik2ProjektEntity dodajPracownikaDoProjektu();
	Pracownik2ProjektEntity usunPracownikaZProjektu();
	List<Pracownik2ProjektEntity> znajdzPracownikowWProjekcie();
	List<Pracownik2ProjektEntity> znajdzPracownikowWProjekcieWgOkresu();
}
