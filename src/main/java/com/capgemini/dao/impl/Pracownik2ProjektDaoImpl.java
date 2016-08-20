package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.Pracownik2ProjektDao;
import com.capgemini.domain.Pracownik2ProjektEntity;

@Repository
public class Pracownik2ProjektDaoImpl extends AbstractDao<Pracownik2ProjektEntity, Long>implements Pracownik2ProjektDao {

	@Override
	public List<Pracownik2ProjektEntity> znajdzPracownikowWProjekcie(Long projekId) {
		TypedQuery<Pracownik2ProjektEntity> query = entityManager.createNamedQuery("pracownik2projekt.znajdzPracownikowWProjekcie",
				Pracownik2ProjektEntity.class);
		query.setParameter("projekt_id", projekId);
		return null;
	}

}
