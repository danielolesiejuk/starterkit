package com.capgemini.domain;

import javax.persistence.Embeddable;

@Embeddable
public class DodatkoweInfo {

	private String stworzonyPrzez;
	private String zmodyfikowanyPrzez;
	
	public DodatkoweInfo() {
	}

	public String getStworzonyPrzez() {
		return stworzonyPrzez;
	}

	public void setStworzonyPrzez(String stworzonyPrzez) {
		this.stworzonyPrzez = stworzonyPrzez;
	}
	public String getZmodyfikowanyPrzez() {
		return zmodyfikowanyPrzez;
	}

	public void setZmodyfikowanyPrzez(String zmodyfikowanyPrzez) {
		this.zmodyfikowanyPrzez = zmodyfikowanyPrzez;
	}
}
