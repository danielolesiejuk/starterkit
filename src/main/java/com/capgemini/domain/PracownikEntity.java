package com.capgemini.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PRACOWNIK")
@NamedQuery(name="pracownik.znajdzPracownikaWgDzialu", query="select pracownik from PracownikEntity pracownik join pracownik.dzial dzial where dzial.id = :dzialId")
public class PracownikEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "imie", length = 45, nullable = false)
	private String imie;
	@Column(name = "nazwisko", length = 45, nullable = false)
	private String nazwisko;
	@Column(name = "pesel", length = 11, nullable = false)
	private Long pesel;
	@Column(name = "data_urodzenia", nullable = false)
	private Date dataUrodzenia;
	
	@ManyToOne
	private DzialEntity dzial;
	
	@OneToMany(mappedBy = "pracownik",cascade = CascadeType.REMOVE)
    private Collection<Pracownik2ProjektEntity> assignments; 
	
	@Column(name = "aktywny", nullable = false)
	private boolean aktywny;
	
	@Embedded
	private DodatkoweInfo dodatkoweInformacje;
	
	@Embedded
	private DaneKontaktowe daneKontaktowe;
	
	public PracownikEntity(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Long getPesel() {
		return pesel;
	}

	public void setPesel(Long pesel) {
		this.pesel = pesel;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public DzialEntity getDzial() {
		return dzial;
	}

	public void setDzial(DzialEntity dzial) {
		this.dzial = dzial;
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

	public DaneKontaktowe getDaneKontaktowe() {
		return daneKontaktowe;
	}

	public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
		this.daneKontaktowe = daneKontaktowe;
	}
	
	
	
}
