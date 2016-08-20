package com.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "DZIAL")
public class DzialEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nazwa", length = 45, nullable = false)
	private String nazwa;
	
	@Column(name = "aktywny", nullable = false)
	private boolean aktywny;
	
	@Embedded
	private DodatkoweInfo dodatkoweInformacje;
	
	@Embedded
	private DaneKontaktowe daneKontaktowe;
	
	@Version
	@Column(name = "wersja", columnDefinition = "integer DEFAULT 1",  nullable = false)
	private Long wersja = 1L;
	
	public DzialEntity(){
	}
	
	public DzialEntity(String nazwa, boolean aktywny) {
		this.nazwa = nazwa;
		this.aktywny = aktywny;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
		this.daneKontaktowe = daneKontaktowe;
	}

	public boolean isAktywny() {
		return aktywny;
	}

	public void setAktywny(boolean aktywny) {
		this.aktywny = aktywny;
	}

	public DodatkoweInfo getDodatkoweInformacje() {
		return dodatkoweInformacje;
	}

	public void setDodatkoweInformacje(DodatkoweInfo dodatkoweInformacje) {
		this.dodatkoweInformacje = dodatkoweInformacje;
	}
	
}
