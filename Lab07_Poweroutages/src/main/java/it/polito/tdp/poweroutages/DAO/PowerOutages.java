package it.polito.tdp.poweroutages.DAO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import it.polito.tdp.poweroutages.model.Nerc;

public class PowerOutages {
	
	int id;
	Nerc nerc;
	int customers;
	LocalDateTime inizio;
	LocalDateTime fine;
	long durata;
	
	public PowerOutages(int id, Nerc nerc, int customers, LocalDateTime inizio, LocalDateTime fine) {
		super();
		this.id = id;
		this.nerc = nerc;
		this.customers = customers;
		this.inizio = inizio;
		this.fine = fine;
		this.durata=inizio.until(fine, ChronoUnit.MINUTES);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nerc getNerc() {
		return nerc;
	}

	public void setNerc(Nerc nerc) {
		this.nerc = nerc;
	}

	public int getCustomers() {
		return customers;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}

	public LocalDateTime getInizio() {
		return inizio;
	}

	public void setInizio(LocalDateTime inizio) {
		this.inizio = inizio;
	}

	public LocalDateTime getFine() {
		return fine;
	}

	public void setFine(LocalDateTime fine) {
		this.fine = fine;
	}

	public long getDurata() {
		return durata;
	}

	public void setDurata(long durata) {
		this.durata = durata;
	}
	
	

}
