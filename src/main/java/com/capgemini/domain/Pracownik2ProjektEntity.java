package com.capgemini.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.capgemini.enums.Funkcja;

@Entity
@Table(name = "PRACOWNIK2PROJEKT")
public class Pracownik2ProjektEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private PracownikEntity pracownik;
	
	@ManyToOne
	private ProjektEntity projekt;
	
	@Enumerated(EnumType.STRING)
	private Funkcja funkcja;
	
	@Column(name = "wynagrodzenie", nullable = false)
	private Long wynagrodzenie;
	
	@Column(name = "data_rozpoczecia_pracy", nullable = false)
	private Date dataRozpoczeciaPracy;
	
	@Column(name = "data_zakonczenia_pracy", nullable = false)
	private Date dataZakonczeniaPracy;
	
	@Embedded
	private DodatkoweInfo dodatkoweInformacje;
	
	@Version
	@Column(name = "wersja", columnDefinition = "integer DEFAULT 1",  nullable = false)
	private Long wersja = 1L;

	public Pracownik2ProjektEntity(){
	}
	
	public Pracownik2ProjektEntity(PracownikEntity pracownik, ProjektEntity projekt, Funkcja funkcja, Long wynagrodzenie,
			Date dataRozpoczeciaPracy, Date dataZakonczeniaPracy, DodatkoweInfo dodatkoweInformacje) {
		this.pracownik = pracownik;
		this.projekt = projekt;
		this.funkcja = funkcja;
		this.wynagrodzenie = wynagrodzenie;
		this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
		this.dataZakonczeniaPracy = dataZakonczeniaPracy;
		this.dodatkoweInformacje = dodatkoweInformacje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PracownikEntity getPracownik() {
		return pracownik;
	}

	public void setPracownik(PracownikEntity pracownik) {
		this.pracownik = pracownik;
	}

	public ProjektEntity getProjekt() {
		return projekt;
	}

	public void setProjekt(ProjektEntity projekt) {
		this.projekt = projekt;
	}

	public Funkcja getFunkcja() {
		return funkcja;
	}

	public void setFunkcja(Funkcja funkcja) {
		this.funkcja = funkcja;
	}

	public Long getWynagrodzenie() {
		return wynagrodzenie;
	}

	public void setWynagrodzenie(Long wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
	}

	public Date getDataRozpoczeciaPracy() {
		return dataRozpoczeciaPracy;
	}

	public void setDataRozpoczeciaPracy(Date dataRozpoczeciaPracy) {
		this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
	}

	public Date getDataZakonczeniaPracy() {
		return dataZakonczeniaPracy;
	}

	public void setDataZakonczeniaPracy(Date dataZakonczeniaPracy) {
		this.dataZakonczeniaPracy = dataZakonczeniaPracy;
	}

	public DodatkoweInfo getDodatkoweInformacje() {
		return dodatkoweInformacje;
	}

	public void setDodatkoweInformacje(DodatkoweInfo dodatkoweInformacje) {
		this.dodatkoweInformacje = dodatkoweInformacje;
	}
	
}
