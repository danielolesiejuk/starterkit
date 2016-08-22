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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.capgemini.enums.Funkcja;

@Entity
@Table(name = "PRACOWNIK2PROJEKT")
@NamedQueries({
@NamedQuery(name="pracownik2projekt.znajdzPracownikowWProjekcie", query="select prac from Pracownik2ProjektEntity p2p join p2p.pracownik prac where p2p.pracownik.id = prac.id and p2p.projekt.id = :projektId"),
@NamedQuery(name="pracownik2projekt.znajdzPracownikowWProjekcieWgOkresu", query="select pracownik from Pracownik2ProjektEntity p2p join p2p.pracownik pracownik where p2p.pracownik.id = pracownik.id and p2p.projekt.id = :projektId and ( (( TIMESTAMPDIFF(SQL_TSI_MONTH , p2p.dataRozpoczeciaPracy, CURRENT_DATE()) > :iloscMiesiecy) and p2p.dataZakonczeniaPracy = null)   or  ( TIMESTAMPDIFF(SQL_TSI_MONTH , p2p.dataRozpoczeciaPracy, p2p.dataZakonczeniaPracy) > :iloscMiesiecy))")
})
public class Pracownik2ProjektEntity extends BaseEntity implements Serializable{

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
	
	@Column(name = "wynagrodzenie", nullable = true)
	private Long wynagrodzenie;
	
	@Column(name = "data_rozpoczecia_pracy", nullable = true)
	private Date dataRozpoczeciaPracy;
	
	@Column(name = "data_zakonczenia_pracy", nullable = true)
	private Date dataZakonczeniaPracy;
	
	@Embedded
	private DodatkoweInfo dodatkoweInformacje;
	

	public Pracownik2ProjektEntity(){
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
