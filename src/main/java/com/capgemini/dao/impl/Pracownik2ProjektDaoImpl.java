package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.Pracownik2ProjektDao;
import com.capgemini.domain.Pracownik2ProjektEntity;
import com.capgemini.domain.PracownikEntity;

@Repository
public class Pracownik2ProjektDaoImpl extends AbstractDao<Pracownik2ProjektEntity, Long>implements Pracownik2ProjektDao {

	@Override
	public List<PracownikEntity> znajdzPracownikowWProjekcie(Long projektId) {
		TypedQuery<PracownikEntity> query = entityManager.createNamedQuery("pracownik2projekt.znajdzPracownikowWProjekcie",
				PracownikEntity.class);
		query.setParameter("projektId", projektId);
		return query.getResultList();
	}
	
	@Override
	public List<PracownikEntity> znajdzPracownikowWProjekcieWgOkresu(Long projektId, int iloscMiesiecy) {
		TypedQuery<PracownikEntity> query = entityManager.createNamedQuery("pracownik2projekt.znajdzPracownikowWProjekcieWgOkresu",
				PracownikEntity.class);
		query.setParameter("projektId", projektId);
		query.setParameter("iloscMiesiecy", iloscMiesiecy);
		return query.getResultList();
	}

}
