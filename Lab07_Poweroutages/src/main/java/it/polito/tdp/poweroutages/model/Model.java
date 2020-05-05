package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;
import it.polito.tdp.poweroutages.DAO.PowerOutages;

public class Model {
	
	PowerOutageDAO podao;
	int maxYears;
	int maxHours;
	List<PowerOutages> guasti;
	WorstCase ottimo;
	
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public WorstCase WorstCase (int maxYears,int maxHours, Nerc nerc) {
		
		this.maxHours=60*maxHours;
		this.maxYears=maxYears;
		guasti= podao.getPowerOutagesList(nerc);
		
		
		calcola(new WorstCase(0,0,new ArrayList<PowerOutages>()),guasti,0);
		
		return ottimo;

	}
	
	private void calcola(WorstCase parziale,List<PowerOutages> guasti, int passo) {
		
		if(ottimo==null||ottimo.getUtenti()<parziale.getUtenti()) {
			
			ottimo= new WorstCase(parziale.utenti,parziale.durata,parziale.listaBlackout);
			
		}
		
		for(PowerOutages po: guasti) {
			//System.out.println("-----5");
			
			if(controllo(parziale,po)==true) {
			parziale.addBlackout(po);
			List<PowerOutages> guastitemp=new ArrayList<PowerOutages>(guasti);
			guastitemp.remove(po);
			calcola(parziale,guastitemp,passo);
			parziale.removeLast();
			}
			//parziale.removeLast();
			
		}
		//parziale.removeLast();
	}
	
	private boolean controllo (WorstCase parziale,PowerOutages guasto) {
		int anno0=parziale.anno0;
		int anno1=parziale.anno1;
		if(guasto.getInizio().getYear()<anno0)anno0=guasto.getInizio().getYear();
		if(guasto.getInizio().getYear()>anno1)anno1=guasto.getInizio().getYear();
		int anni=anno1-anno0+1;
		//if(anno0==Integer.MAX_VALUE & anno1==Integer.MIN_VALUE)anni= 0;
		if(anni>maxYears)return false;
		if(parziale.getDurata()+guasto.getDurata()>maxHours)return false;
		
		
		
		return true;
		
		
		
		
		
	}
}
