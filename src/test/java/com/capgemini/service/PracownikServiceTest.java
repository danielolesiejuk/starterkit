package com.capgemini.service;

import static org.junit.Assert.assertEquals;
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

import com.capgemini.domain.DaneKontaktowe;
import com.capgemini.domain.DodatkoweInfo;
import com.capgemini.domain.DzialEntity;
import com.capgemini.domain.PracownikEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracownikServiceTest {

	@Autowired
	private PracownikService pracownikService;

	@Test
	@Transactional
	public void testZnajdzPracownikaPoNazwisku() {
		// given
		final String nazwisko = "Bilecka";
		// when
		List<PracownikEntity> pracownikEntity = pracownikService.znajdzPracownikaPoNazwisku(nazwisko);
		// then
		assertNotNull(pracownikEntity);
		assertEquals(nazwisko, pracownikEntity.get(0).getNazwisko());
	}

	@Test
	@Transactional
	public void testZnajdzPracownikaPoImieniu() {
		// given
		final String imie = "jan";
		// when
		List<PracownikEntity> pracownikEntity = pracownikService.znajdzPracownikaPoImieniu(imie);
		// then
		assertNotNull(pracownikEntity);
		assertEquals(imie, pracownikEntity.get(0).getImie());
	}

	@Test
	@Transactional
	public void testZnajdzPracownikaWgDzialu() {
		// given
		final String dzial = "CSC";
		final Long dzialId = 1L;
		// when
		List<PracownikEntity> pracownikEntity = pracownikService.znajdzPracownikaWgDzialu(dzialId);
		// then
		assertNotNull(pracownikEntity);
		assertEquals(dzial, pracownikEntity.get(2).getDzial().getNazwa());
		assertEquals("kanapka", pracownikEntity.get(2).getNazwisko());
	}

	@Test
	@Transactional
	public void testZnajdzWszystkichPracownikow() {
		// given
		int cnt_b4 = pracownikService.znajdzWszystkichPracownikow().size();
		// when
		List<PracownikEntity> pracownikEntity = pracownikService.znajdzWszystkichPracownikow();
		// then
		assertNotNull(pracownikEntity);
		assertEquals(cnt_b4, pracownikEntity.size());
	}

	@Test
	@Transactional
	//@Rollback(false)
	public void testDodajPracownika() {
		// given
		final Date data = new Date(System.currentTimeMillis());

		final DzialEntity dzial = new DzialEntity();
		dzial.setId(1L);

		final DodatkoweInfo dodatkoweInfo = new DodatkoweInfo();
		dodatkoweInfo.setStworzonyPrzez("Daniel");
		dodatkoweInfo.setStworzonyDnia(data);
		dodatkoweInfo.setZmodyfikowanyPrzez("Daniel");
		dodatkoweInfo.setZmodyfikowanyDnia(data);

		final DaneKontaktowe daneKontaktowe = new DaneKontaktowe();
		daneKontaktowe.setEmail("email@domena.pl");
		daneKontaktowe.setTelefonDomowy("123456789");
		daneKontaktowe.setTelefonKomorkowy("987654321");

		final PracownikEntity pracownik = new PracownikEntity();
		pracownik.setImie("Daniel");
		pracownik.setNazwisko("Olesiejuk");
		pracownik.setPesel(79011912345L);
		pracownik.setDataUrodzenia(data);
		pracownik.setDzial(dzial);
		pracownik.setAktywny(true);
		pracownik.setDodatkoweInformacje(dodatkoweInfo);
		pracownik.setDaneKontaktowe(daneKontaktowe);
		
		int cnt_b4 = pracownikService.znajdzWszystkichPracownikow().size();
		
		// when
		PracownikEntity pracownikEntity = pracownikService.dodajPracownika(pracownik);
		List<PracownikEntity> pracownicyEntity = pracownikService.znajdzWszystkichPracownikow();
		// then
		assertNotNull(pracownikEntity);
		assertEquals(cnt_b4+1, pracownicyEntity.size());
	}

	@Test
	@Transactional
	//@Rollback(false)
	public void testEdytujPracownika() {
		// given
		final Date data = new Date(System.currentTimeMillis());

		final DzialEntity dzial = new DzialEntity();
		dzial.setId(1L);

		final DodatkoweInfo dodatkoweInfo = new DodatkoweInfo();
		dodatkoweInfo.setStworzonyPrzez("Daniel");
		dodatkoweInfo.setStworzonyDnia(data);
		dodatkoweInfo.setZmodyfikowanyPrzez("Daniel");
		dodatkoweInfo.setZmodyfikowanyDnia(data);

		final DaneKontaktowe daneKontaktowe = new DaneKontaktowe();
		daneKontaktowe.setEmail("email@domena.pl");
		daneKontaktowe.setTelefonDomowy("123456789");
		daneKontaktowe.setTelefonKomorkowy("987654321");

		PracownikEntity pracownik = new PracownikEntity();
		pracownik = pracownikService.znajdzPracownikaPoId(1L);
		pracownik.setImie("Daniel");
		pracownik.setNazwisko("Olesiejuk");
		pracownik.setPesel(79011912345L);
		pracownik.setDataUrodzenia(data);
		pracownik.setDzial(dzial);
		pracownik.setAktywny(true);
		pracownik.setDodatkoweInformacje(dodatkoweInfo);
		pracownik.setDaneKontaktowe(daneKontaktowe);

		// when
		PracownikEntity pracownikEntity = pracownikService.edytujPracownika(pracownik);
		List<PracownikEntity> pracownicyEntity = pracownikService.znajdzWszystkichPracownikow();
		// then
		assertNotNull(pracownikEntity);
		assertEquals("Olesiejuk", pracownicyEntity.get(0).getNazwisko());
	}

	@Test
	@Transactional
	//@Rollback(false)
	public void testPrzypiszPracownikaDoDzialu() {
		// given
		Long dzialId = 2L;
		Long pracownikId = 2L;
		// when
		PracownikEntity pracownikEntity = pracownikService.przypiszPracownikaDoDzialu(pracownikId, dzialId);
		List<PracownikEntity> pracownicyEntity = pracownikService.znajdzWszystkichPracownikow();
		// then
		assertNotNull(pracownikEntity);
		assertEquals("SSC", pracownicyEntity.get(1).getDzial().getNazwa());
	}

	@Test
	@Transactional
	//@Rollback(false)
	public void testUsunPracownika() {
		// given
		PracownikEntity pracownik = new PracownikEntity();
		pracownik = pracownikService.znajdzPracownikaPoId(3L);
		Long pracownikId = pracownik.getId();
		int cnt_b4 = pracownikService.znajdzWszystkichPracownikow().size();
		
		// when
		pracownikService.usunPracownika(pracownikId);
		List<PracownikEntity> pracownicyEntity = pracownikService.znajdzWszystkichPracownikow();
		// then
		assertEquals(cnt_b4-1, pracownicyEntity.size());
	}
}
