 package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		this.lib = new Libretto();
		
		// 1. Inserire alcuni voti 
		Voto v1 = new Voto("Tecniche di Programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi 2", 28, LocalDate.of(2020, 06, 27));
		Voto v3 = new Voto("Economia", 24, LocalDate.of(2019, 07, 03));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(v3);
		lib.add(new Voto("Fisica 2", 18, LocalDate.of(2019, 06, 18)));
		
		System.out.println("Libretto completo: ");
		System.out.println(this.lib);
		
		// 2. Stampa tutti i voti uguali a 'X':
		System.out.println("Sotto-Libretto solo esami con voto uguale a x: ");
//		System.out.println(this.lib.stampaVotiUguali(28));		PREFERIAMO METODO SOTTOSTANTE
		System.out.println(this.lib.estraiVotiUguali(28));
		
		// 3. Cerca un esame superato conoscendo il nome del corso
		String nomeCorso = "Analisi 2";
		Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso);
		System.out.println("Il voto di " + nomeCorso + " è : " + votoAnalisi.getVoto());
		Voto votoMancante = lib.cercaNomeCorso("Fisica 1");
		System.out.println("Il voto di Fisica 1 è : " + votoMancante + "\n");
		
		
		// 4 & 5. Verifica voti duplicati o voti in conflitto
		Voto economia2 = new Voto("Economia", 24, LocalDate.now());
		Voto economia3 = new Voto("Economia", 21, LocalDate.now());
		
		System.out.println("Economia con 24 è duplicato: " + lib.isDuplicato(economia2)
											+ " | è in conflitto: " + lib.isConflitto(economia2));
		System.out.println("Economia con 21 è duplicato: " + lib.isDuplicato(economia3)
											+ " | è in conflitto: " + lib.isConflitto(economia3) + "\n");
		
		// 6. Modificare metodo add per evitare duplicati e conflitti 
		
			// Fatto in classe libretto!
		
		// 7. Creare libretto migliorato
		Libretto migliorato = lib.creaLibrettoMigliorato();
		System.out.println("Libretto voti non-migliorato: ");
		System.out.println(lib);
		System.out.println("Libretto voti migliorato: ");
		System.out.println(migliorato);
		
		// 8.1 Stampa in ordine alfabetico
		Libretto alfabetico = new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println("Libretto ordinato alfabeticamente: ");
		System.out.println(alfabetico);
		
		// 8.2 Stampa in ordine decrescente di voto
		Libretto votiDecrescenti = new Libretto(lib);
		votiDecrescenti.ordinaPerVoto();
		System.out.println("Libretto ordinato per voti decrescenti: ");
		System.out.println(votiDecrescenti);
		
		// 9. Elimina dal libretto tutti i voti minori di 24
		System.out.println("Libretto privato di voti inferiori a 24: ");
		lib.cancellaVotiScarsi();
		System.out.println(lib);
	}

	// Non si lavora dentro il metodo Static Main
	public static void main(String[] args) {
		
		TestLibretto test = new TestLibretto();
		test.run();
		
	}

}
