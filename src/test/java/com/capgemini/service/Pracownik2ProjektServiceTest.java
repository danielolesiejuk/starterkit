package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Pracownik2ProjektEntity;
import com.capgemini.domain.PracownikEntity;
import com.capgemini.domain.ProjektEntity;
import com.capgemini.enums.Funkcja;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pracownik2ProjektServiceTest {
	
	@Autowired
	private Pracownik2ProjektService pracownik2ProjektService;
	@Autowired
	private ProjektService projektService;
	@Autowired
	private PracownikService pracownikService;
	
	
	@Test
	@Transactional
	//@Rollback(false)
	public void testDodajPracownikaDoProjektu() {
		// given
		final Date data = new Date(System.currentTimeMillis());
		
		PracownikEntity pracownik = new PracownikEntity();
		pracownik = pracownikService.znajdzPracownikaPoId(1L);
		
		ProjektEntity projekt = new ProjektEntity();
		projekt = projektService.znajdzProjektPoId(4L);
		final Long projektId = projekt.getId();
		
		Pracownik2ProjektEntity pracownik2Projekt = new Pracownik2ProjektEntity();
		pracownik2Projekt.setPracownik(pracownik);
		pracownik2Projekt.setProjekt(projekt);
		pracownik2Projekt.setFunkcja(Funkcja.DEV);
		pracownik2Projekt.setWynagrodzenie(100L);
		pracownik2Projekt.setDataRozpoczeciaPracy(data);
		pracownik2Projekt.setDataZakonczeniaPracy(null);
		
		int cnt_b4 = pracownik2ProjektService.znajdzPracownikowWProjekcie(projektId).size();
		
		// when
		Pracownik2ProjektEntity pracownik2ProjektEntity = pracownik2ProjektService.dodajPracownikaDoProjektu(pracownik2Projekt);
		List <PracownikEntity> pracownicy2ProjektEntity = pracownik2ProjektService.znajdzPracownikowWProjekcie(projektId);
		// then
		assertNotNull(pracownik2ProjektEntity);
		assertEquals(cnt_b4+1, pracownicy2ProjektEntity.size());
	}
	@Test
	@Transactional
	@Rollback(false)
	public void testUsunPracownikaZProjektu() {
		// given
		
		final Date data = new Date(System.currentTimeMillis());
		
		Pracownik2ProjektEntity pracownik2ProjektEntity = pracownik2ProjektService.znajdzPracownik2ProjektId(48L);
		
		// when
		pracownik2ProjektService.usunPracownikaZProjektu(pracownik2ProjektEntity);

		// then
		assertNotNull(pracownik2ProjektEntity);
		assertEquals(data.getYear(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getYear());
		assertEquals(data.getMonth(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getMonth());
		assertEquals(data.getDay(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getDay());
		assertEquals(data.getHours(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getHours());
		assertEquals(data.getMinutes(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getMinutes());
		assertEquals(data.getSeconds(), pracownik2ProjektEntity.getDataZakonczeniaPracy().getSeconds());
		//assertEquals(data, pracownik2ProjektEntity.getDataZakonczeniaPracy());
		
	}
	
	@Test
	@Transactional
	//@Rollback(false)
	public void testZnajdzPracownikowWProjekcie() {
		// given
		ProjektEntity projekt = new ProjektEntity();
		projekt = projektService.znajdzProjektPoId(4L);
		final Long projektId = projekt.getId();
		
		int cnt_b4 = pracownik2ProjektService.znajdzPracownikowWProjekcie(projektId).size();
		
		// when
		List <PracownikEntity> pracownicy2ProjektEntity = pracownik2ProjektService.znajdzPracownikowWProjekcie(projektId);
		// then
		assertNotNull(pracownicy2ProjektEntity);
		assertEquals((Long) 111L, pracownicy2ProjektEntity.get(0).getId());
		assertEquals(50, cnt_b4);
	}
	@Test
	@Transactional
	//@Rollback(false)
	public void testZnajdzPracownikowWProjekcieWgOkresu() {
		// given
		ProjektEntity projekt = new ProjektEntity();
		projekt = projektService.znajdzProjektPoId(4L);
		final Long projektId = projekt.getId();
		final int iloscMiesiecy = 4;
		
		int cnt_b4 = pracownik2ProjektService.znajdzPracownikowWProjekcieWgOkresu(projektId, iloscMiesiecy).size();
		
		// when
		List <PracownikEntity> pracownicy2ProjektEntity = pracownik2ProjektService.znajdzPracownikowWProjekcie(projektId);
		// then
		assertNotNull(pracownicy2ProjektEntity);
		assertEquals(38, cnt_b4);
	}
	
	
	@Test
	@Transactional
	//@Rollback(false)
	public void testUsunieciePracownikaUsuwajegoUdzialWProjektach() {
	// given
			PracownikEntity pracownik = new PracownikEntity();
			pracownik = pracownikService.znajdzPracownikaPoId(5L);
			Long pracownikId = pracownik.getId();
			int cnt_b4_prac = pracownikService.znajdzWszystkichPracownikow().size();
			int cnt_b4_p2p = pracownik2ProjektService.policzWszystkichPracownik2Projekt().size();
			
			// when
			pracownikService.usunPracownika(pracownikId);
			List <PracownikEntity> pracownicyEntity = pracownikService.znajdzWszystkichPracownikow();
			int cnt_ar_p2p = pracownik2ProjektService.policzWszystkichPracownik2Projekt().size();
			
			// then
			assertEquals(cnt_b4_prac-1, pracownicyEntity.size());
			assertNotEquals(cnt_b4_p2p, cnt_ar_p2p);
			
			
	}
			
}
