package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.Pracownik2ProjektDao;
import com.capgemini.domain.Pracownik2ProjektEntity;
import com.capgemini.domain.PracownikEntity;
import com.capgemini.service.Pracownik2ProjektService;

@Service
//@Transactional(readOnly = true)
public class Pracownik2ProjektServiceImpl implements Pracownik2ProjektService {

	
	@Autowired
	private Pracownik2ProjektDao pracownik2ProjektRepository;
	
	@Override
	public Pracownik2ProjektEntity dodajPracownikaDoProjektu(Pracownik2ProjektEntity pracownik2projekt) {
		return pracownik2ProjektRepository.save(pracownik2projekt);
	}

	@Override
	public void usunPracownikaZProjektu(Pracownik2ProjektEntity pracownik2projekt) {
		final Date data = new Date(System.currentTimeMillis());
		pracownik2projekt.setDataZakonczeniaPracy(data);
		pracownik2ProjektRepository.update(pracownik2projekt);
	}

	@Override
	public List<PracownikEntity> znajdzPracownikowWProjekcie(Long projektId) {
		return pracownik2ProjektRepository.znajdzPracownikowWProjekcie(projektId);
	}

	@Override
	public List<PracownikEntity> znajdzPracownikowWProjekcieWgOkresu(Long projektId, int iloscMiesiecy) {
		return pracownik2ProjektRepository.znajdzPracownikowWProjekcieWgOkresu(projektId, iloscMiesiecy);
	}
	
	@Override
	public Pracownik2ProjektEntity znajdzPracownik2ProjektId(Long pracownik2projektId){
		return pracownik2ProjektRepository.findOne(pracownik2projektId);
	}
	
	@Override
	public List<Pracownik2ProjektEntity> policzWszystkichPracownik2Projekt(){
		return pracownik2ProjektRepository.findAll();
	}
}
