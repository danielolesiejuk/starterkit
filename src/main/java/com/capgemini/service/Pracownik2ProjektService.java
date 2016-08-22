package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Pracownik2ProjektEntity;
import com.capgemini.domain.PracownikEntity;

public interface Pracownik2ProjektService {

	Pracownik2ProjektEntity dodajPracownikaDoProjektu(Pracownik2ProjektEntity pracownik2projekt);
	void usunPracownikaZProjektu(Pracownik2ProjektEntity pracownik2projekt);
	List<PracownikEntity> znajdzPracownikowWProjekcie(Long projektId);
	List<PracownikEntity> znajdzPracownikowWProjekcieWgOkresu(Long projektId, int iloscMiesiecy);
	Pracownik2ProjektEntity znajdzPracownik2ProjektId(Long pracownik2projektId);
	List<Pracownik2ProjektEntity> policzWszystkichPracownik2Projekt();
}
