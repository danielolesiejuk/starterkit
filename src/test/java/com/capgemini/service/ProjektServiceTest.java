package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.PracownikEntity;
import com.capgemini.domain.ProjektEntity;
import com.capgemini.enums.Rodzaj;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjektServiceTest {

	@Autowired
	private ProjektService projektService;
	
	@Test
	@Transactional
	public void testZnajdzProjektPoId() {
		// given
		final Long projektId = 1L;
		// when
		ProjektEntity projektEntity = projektService.znajdzProjektPoId(projektId);
		// then
		assertNotNull(projektEntity);
		assertEquals("Rybnik", projektEntity.getNazwa());
	}
	@Test
	@Transactional
	public void testZnajdzWszystkieProjekty() {
		// given
		int cnt_b4 = projektService.znajdzWszystkieProjekty().size();
		// when
		List<ProjektEntity> projektEntity = projektService.znajdzWszystkieProjekty();
		// then
		assertNotNull(projektEntity);
		assertEquals(cnt_b4, projektEntity.size());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDodajProjekt() {
		// given

		final PracownikEntity kierownik = new PracownikEntity();
		kierownik.setId(205L);
		final ProjektEntity projekt = new ProjektEntity();
		projekt.setNazwa("NowyProjekt");
		projekt.setRodzaj(Rodzaj.WEWNETRZNY);
		projekt.setKierownik(kierownik);
		projekt.setAktywny(false);
				
		int cnt_b4 = projektService.znajdzWszystkieProjekty().size();
		
		// when
		ProjektEntity projektEntity = projektService.dodajProjekt(projekt);
		List<ProjektEntity> projektyEntity = projektService.znajdzWszystkieProjekty();
		// then
		assertNotNull(projektEntity);
		assertEquals(cnt_b4+1, projektyEntity.size());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testEdytujProjekt() {
		// given
		ProjektEntity projekt = new ProjektEntity();
		projekt = projektService.znajdzProjektPoId(1L);
		projekt.setAktywny(false);
				
		
		// when
		ProjektEntity projektEntity = projektService.edytujProjekt(projekt);
		// then
		assertNotNull(projektEntity);
		assertEquals(false, projektEntity.isAktywny());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testUsunProjekt() {
		// given
		ProjektEntity projekt = new ProjektEntity();
		projekt = projektService.znajdzProjektPoId(3L);
		Long projektId = projekt.getId();
		int cnt_b4 = projektService.znajdzWszystkieProjekty().size();
		
		// when
		projektService.usunProjekt(projektId);
		List<ProjektEntity> projektyEntity = projektService.znajdzWszystkieProjekty();
		// then
		assertEquals(cnt_b4-1, projektyEntity.size());
	}
}
