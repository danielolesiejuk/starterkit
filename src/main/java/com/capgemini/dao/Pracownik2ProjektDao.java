package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Pracownik2ProjektEntity;

public interface Pracownik2ProjektDao extends Dao<Pracownik2ProjektEntity, Long>{

	List<Pracownik2ProjektEntity> znajdzPracownikowWProjekcie(Long projekId);
}
