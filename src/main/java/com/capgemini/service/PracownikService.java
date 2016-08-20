package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.PracownikEntity;

public interface PracownikService {
	
	PracownikEntity dodajPracownika(PracownikEntity pracownik);
	void usunPracownika(Long pracownikId);
	PracownikEntity edytujPracownika(PracownikEntity pracownik);
	PracownikEntity przypiszPracownikaDoDzialu(Long pracownikId, Long dzialId);
	List<PracownikEntity> znajdzPracownikaPoNazwisku(String nazwisko);
	List<PracownikEntity> znajdzPracownikaPoImieniu(String imie);
	List<PracownikEntity> znajdzPracownikaWgDzialu(Long dzialId);
	List<PracownikEntity> znajdzWszystkichPracownikow();
	PracownikEntity znajdzPracownikaPoId(Long pracownikId);

}
