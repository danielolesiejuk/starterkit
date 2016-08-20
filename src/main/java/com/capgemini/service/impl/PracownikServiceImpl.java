package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.DzialDao;
import com.capgemini.dao.PracownikDao;
import com.capgemini.domain.DzialEntity;
import com.capgemini.domain.PracownikEntity;
import com.capgemini.service.PracownikService;

@Service
//@Transactional(readOnly = true)
public class PracownikServiceImpl implements PracownikService {

	@Autowired
	private PracownikDao pracownikRepository;
	@Autowired
	private DzialDao dzialRepository;

	@Override
	public PracownikEntity dodajPracownika(PracownikEntity pracownik) {
		return pracownikRepository.save(pracownik);
	}

	@Override
	public void usunPracownika(Long pracownikId) {
		pracownikRepository.delete(pracownikId);
	}

	@Override
	public PracownikEntity edytujPracownika(PracownikEntity pracownik) {
		return pracownikRepository.update(pracownik);
	}

	@Override
	public PracownikEntity przypiszPracownikaDoDzialu(Long pracownikId, Long dzialId) {
		if (pracownikRepository.exists(pracownikId)){
			PracownikEntity pracownik =  pracownikRepository.getOne(pracownikId);
			DzialEntity dzial =  dzialRepository.getOne(dzialId);
			pracownik.setDzial(dzial);
			return pracownikRepository.update(pracownik);
		}
		else 
		return null;
	}
	
	@Transactional (readOnly = true)
	@Override
	public List<PracownikEntity> znajdzPracownikaPoNazwisku(String nazwisko) {
		return pracownikRepository.znajdzPracownikaPoNazwisku(nazwisko);
	}

	@Transactional (readOnly = true)
	@Override
	public List<PracownikEntity> znajdzPracownikaPoImieniu(String imie) {
		return pracownikRepository.znajdzPracownikaPoImieniu(imie);
	}

	@Transactional (readOnly = true)
	@Override
	public List<PracownikEntity> znajdzPracownikaWgDzialu(Long dzialId) {
		return pracownikRepository.znajdzPracownikaWgDzialu(dzialId);
	}

	@Transactional (readOnly = true)
	@Override
	public PracownikEntity znajdzPracownikaPoId(Long pracownikId) {
		return pracownikRepository.findOne(pracownikId);
	}
	
	@Transactional (readOnly = true)
	@Override
	public List<PracownikEntity> znajdzWszystkichPracownikow() {
		return pracownikRepository.findAll();
	}
}
	