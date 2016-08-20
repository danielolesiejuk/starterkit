package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.PracownikDao;
import com.capgemini.domain.PracownikEntity;

@Repository
public class PracownikDaoImpl extends AbstractDao<PracownikEntity, Long> implements PracownikDao {

	@Override
	public List<PracownikEntity> znajdzPracownikaPoNazwisku(String nazwisko) {
		TypedQuery<PracownikEntity> query = entityManager.createQuery(
				"select pracownik from PracownikEntity pracownik where pracownik.nazwisko = :nazwisko",
				PracownikEntity.class);
		query.setParameter("nazwisko", nazwisko);
		return query.getResultList();
	}

	@Override
	public List<PracownikEntity> znajdzPracownikaPoImieniu(String imie) {
		TypedQuery<PracownikEntity> query = entityManager.createQuery(
				"select pracownik from PracownikEntity pracownik where upper(pracownik.imie) like concat(upper(:imie), '%')",
				PracownikEntity.class);
		query.setParameter("imie", imie);
		return query.getResultList();
	}

	@Override
	public List<PracownikEntity> znajdzPracownikaWgDzialu(Long dzialId) {
		TypedQuery<PracownikEntity> query = entityManager.createNamedQuery("pracownik.znajdzPracownikaWgDzialu",
				PracownikEntity.class);
		query.setParameter("dzialId", dzialId);
		return query.getResultList();
	}

}
