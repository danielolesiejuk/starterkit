package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.PracownikEntity;

public interface PracownikDao extends Dao<PracownikEntity, Long>{

	List<PracownikEntity> znajdzPracownikaPoNazwisku(String nazwisko);
	List<PracownikEntity> znajdzPracownikaPoImieniu(String imie);
	List<PracownikEntity> znajdzPracownikaWgDzialu(Long dzialId);
}
