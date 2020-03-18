package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		this.lib = new Libretto();
		
		Voto v1 = new Voto("Tecniche di Programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi 2", 28, LocalDate.of(2020, 06, 27));
		
		lib.add(v1);
		lib.add(v2);
		
		System.out.println("Libretto completo: ");
		System.out.println(this.lib);
		
		System.out.println("Sotto-Libretto solo esami con voto uguale a x: ");
//		System.out.println(this.lib.stampaVotiUguali(28));		PREFERIAMO METODO SOTTOSTANTE
		System.out.println(this.lib.estraiVotiUguali(28));
		
	}

	// Non si lavora dentro il metodo Static Main
	public static void main(String[] args) {
		
		TestLibretto test = new TestLibretto();
		test.run();
		
	}

}
