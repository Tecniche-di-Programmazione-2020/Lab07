package it.polito.tdp.poweroutages.model;


import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutages;

public class WorstCase {
	
	int utenti;
	long durata;
	int anno0=Integer.MAX_VALUE;
	int anno1=Integer.MIN_VALUE;
	int anni;
	List<PowerOutages> listaBlackout ;
	
	public WorstCase(int utenti, long durata, List<PowerOutages> listaBlackout) {
		super();
		this.utenti = utenti;
		this.durata = durata;
		this.listaBlackout = listaBlackout;
	}
	
	public int getAnni() {
		if(anno0==Integer.MAX_VALUE & anno1==Integer.MIN_VALUE)return 0;
		return anni;
	}

	public List<PowerOutages> getListaBlackout() {
		return listaBlackout;
	}
	/*
	public void setListaBlackout(List<PowerOutages> listaBlackout) {
		this.listaBlackout = listaBlackout;
		for(PowerOutages po: this.listaBlackout) {
			durata=durata+po.getDurata();
			utenti=utenti+po.getCustomers();}
	}*/
	
	public void addBlackout(PowerOutages blackout) {
		
		this.listaBlackout.add(blackout);
		utenti=utenti+blackout.getCustomers();
		this.durata=blackout.getDurata();
		if(blackout.getInizio().getYear()<anno0)anno0=blackout.getInizio().getYear();
		if(blackout.getInizio().getYear()>anno1)anno1=blackout.getInizio().getYear();
		anni=anno1-anno0+1;
		
		
	}
	public void removeLast() {
		utenti=utenti-this.listaBlackout.get(this.listaBlackout.size()-1).getCustomers();
		durata=durata-this.listaBlackout.get(this.listaBlackout.size()-1).getDurata();
		this.listaBlackout.remove(this.listaBlackout.size()-1);
		calcoli();
	}
	
	
	public int getUtenti() {
		return utenti;
	}
	public long getDurata() {
		return durata;
	}
	
	private void calcoli() {
		for(PowerOutages po: this.listaBlackout) {
			//durata=durata+po.getDurata();
			//utenti=utenti+po.getCustomers();
		if(po.getInizio().getYear()<anno0)anno0=po.getInizio().getYear();
		if(po.getInizio().getYear()>anno1)anno1=po.getInizio().getYear();
		}
		anni=anno1-anno0+1;
	}
	

}
