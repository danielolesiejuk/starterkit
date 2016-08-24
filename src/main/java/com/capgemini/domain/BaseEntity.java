package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "zmodyfikowany_dnia", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date zmodyfikowanyDnia;

	@Column(name = "stworzony_dnia", columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Date stworzonyDnia;

	@Version
	@Column(name = "wersja", columnDefinition = "integer DEFAULT 1",  nullable = false)
	private Long wersja = 1L;

	public Date getZmodyfikowanyDnia() {
		return zmodyfikowanyDnia;
	}
	
	@PostUpdate
	public void setZmodyfikowanyDnia() {
		this.zmodyfikowanyDnia = new Date(System.currentTimeMillis());
	}

	public Date getStworzonyDnia() {
		return stworzonyDnia;
	}

	public void setStworzonyDnia(Date stworzonyDnia) {
		this.stworzonyDnia = stworzonyDnia;
	}

	public Long getWersja() {
		return wersja;
	}

	public void setWersja(Long wersja) {
		this.wersja = wersja;
	}
}
