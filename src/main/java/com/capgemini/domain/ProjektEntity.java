package com.capgemini.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.enums.Rodzaj;

@Entity
@Table(name = "PROJEKT")
@Access(AccessType.FIELD)
public class ProjektEntity extends BaseEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nazwa", length = 45, nullable = false)
	private String nazwa;
	
	@Enumerated(EnumType.STRING)
	private Rodzaj rodzaj;
	
	@ManyToOne
	private PracownikEntity kierownik;
	
	@Column(name = "aktywny", nullable = false)
	private boolean aktywny;
	
	@OneToMany(mappedBy = "projekt",cascade = CascadeType.REMOVE)
    private Collection<Pracownik2ProjektEntity> assignments; 
	
	@Embedded
	private DodatkoweInfo dodatkoweInformacje;
	
	public ProjektEntity(){
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

	public Rodzaj getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(Rodzaj rodzaj) {
		this.rodzaj = rodzaj;
	}

	public PracownikEntity getKierownik() {
		return kierownik;
	}

	public void setKierownik(PracownikEntity kierownik) {
		this.kierownik = kierownik;
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
