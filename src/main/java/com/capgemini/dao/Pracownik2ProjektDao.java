package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Pracownik2ProjektEntity;
import com.capgemini.domain.PracownikEntity;

public interface Pracownik2ProjektDao extends Dao<Pracownik2ProjektEntity, Long>{

	List<PracownikEntity> znajdzPracownikowWProjekcie(Long projektId);
	List<PracownikEntity> znajdzPracownikowWProjekcieWgOkresu(Long projektId, int iloscMiesiecy);
}
