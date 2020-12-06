package com.beadando.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Getter-setter metódusok
@Entity
@Table(name = "aruk")
public class Prod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "term_nev")
	public String termnev;

	@Column(name = "azonosito")
	public String azonosito;

	@Column(name = "db")
	public String db;

	@Column(name = "brutto")
	public int brutto;

	@Column(name = "netto")
	public int netto;

	@Column(name = "arressel")
	public double arressel;

	@Column(name = "arres")
	public double arres;

	public double getArres() {
		return arres;
	}

	public void setArres(double arres) {
		this.arres = arres;

	}

	public double getArressel() {
		return arressel;
	}

	public void setArressel(double arressel) {
		this.arressel = arressel;
	}

	public int getBrutto() {
		return brutto;
	}

	public void setBrutto(int brutto) {
		this.brutto = brutto;
	}

	public int getNetto() {
		return netto;
	}

	public void setNetto(int netto) {
		this.netto = netto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String gettermnev() {
		return termnev;
	}

	public void settermnev(String termnev) {
		this.termnev = termnev;
	}

	public String getazonosito() {
		return azonosito;
	}

	public void setazonosito(String azonosito) {
		this.azonosito = azonosito;
	}

	public String getdb() {
		return db;
	}

	public void setdb(String db) {
		this.db = db;
	}

}
