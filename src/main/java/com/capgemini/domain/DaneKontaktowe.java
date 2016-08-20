package com.capgemini.domain;

import javax.persistence.Embeddable;

@Embeddable
public class DaneKontaktowe {

	private String email;
	private String telefonDomowy;
	private String telefonKomorkowy;

	public DaneKontaktowe() {
	}

	public DaneKontaktowe(String email, String telefonDomowy, String telefonKomorkowy) {
		this.email = email;
		this.telefonDomowy = telefonDomowy;
		this.telefonKomorkowy = telefonKomorkowy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonDomowy() {
		return telefonDomowy;
	}

	public void setTelefonDomowy(String telefonDomowy) {
		this.telefonDomowy = telefonDomowy;
	}

	public String getTelefonKomorkowy() {
		return telefonKomorkowy;
	}

	public void setTelefonKomorkowy(String telefonKomorkowy) {
		this.telefonKomorkowy = telefonKomorkowy;
	}

}
