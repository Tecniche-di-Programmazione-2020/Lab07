package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());
		
		WorstCase worst= model.WorstCase(4, 500, new Nerc(4, "MAAC"));
		System.out.println(worst.getUtenti());
		System.out.println(worst.getDurata()/60);
	}

}
