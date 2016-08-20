package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DodatkoweInfo {

	private String stworzonyPrzez;
	private Date stworzonyDnia;
	private String zmodyfikowanyPrzez;
	private Date zmodyfikowanyDnia;
	
	public DodatkoweInfo() {
	}

	public DodatkoweInfo(String stworzonyPrzez, Date stworzonyDnia, String zmodyfikowanyPrzez,
			Date zmodyfikowanyDnia) {
		this.stworzonyPrzez = stworzonyPrzez;
		this.stworzonyDnia = stworzonyDnia;
		this.zmodyfikowanyPrzez = zmodyfikowanyPrzez;
		this.zmodyfikowanyDnia = zmodyfikowanyDnia;
	}

	public String getStworzonyPrzez() {
		return stworzonyPrzez;
	}

	public void setStworzonyPrzez(String stworzonyPrzez) {
		this.stworzonyPrzez = stworzonyPrzez;
	}

	public Date getStworzonyDnia() {
		return stworzonyDnia;
	}

	public void setStworzonyDnia(Date stworzonyDnia) {
		this.stworzonyDnia = stworzonyDnia;
	}

	public String getZmodyfikowanyPrzez() {
		return zmodyfikowanyPrzez;
	}

	public void setZmodyfikowanyPrzez(String zmodyfikowanyPrzez) {
		this.zmodyfikowanyPrzez = zmodyfikowanyPrzez;
	}

	public Date getZmodyfikowanyDnia() {
		return zmodyfikowanyDnia;
	}

	public void setZmodyfikowanyDnia(Date zmodyfikowanyDnia) {
		this.zmodyfikowanyDnia = zmodyfikowanyDnia;
	}

}
