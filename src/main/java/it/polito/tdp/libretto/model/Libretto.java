package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un inisieme di voti 
 * 
 * @author gabrielecarru
 *
 */

public class Libretto {

	private List<Voto> voti = new ArrayList<>();

	/**
	 * Aggiunge un nuovo voto al libretto 
	 * @param v : {@link Voto} da aggiungere
	 * @return {@code true} se ha inserito il voto, {@code false} se non 
	 * l'ha inserito perchè era in conflitto oppure era duplicato.
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) == true || this.isDuplicato(v) == true) {
			return false;
		} else {
			this.voti.add(v);
			return true;
		}	
	}
	
	/**
	 * Dato un libretto, restituisce una stringa nella quale
	 * vi sono solamente i voti pari al valore specificato 
	 * IMPORTANTE: questo metodo restituisce una stringa e non l'insieme dei voti 
	 * intesi come oggetto, dunque non potrei poi lavorarci.
	 * @param voto : valore specificato
	 * @return : stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		
		String s = "";
		for(Voto v : this.voti) {
			if(v.getVoto() == voto)
				s += v.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Genera un nuovo libretto, a partire da quello esistente, 
	 * che conterrà esclusivamente i voti con votazione pari a quella specificata
	 * @param voto : valutazione specificata
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto() == voto)
				nuovo.add(v);
		}
		return nuovo;
	}
	
	// 
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		
		return s;
	}

	/** 
	 * Dato il nome di un corso, ricerca se l'esame esiste nel libretto
	 * e, in caso affermativo, restituisce l'oggetto
	 * {@link Voto} corrispondente.
	 * Se l'esame non esiste, restituisce {@code null}.
	 * @param nomeCorso : nome esame da cercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esiste
	 */
	
	public Voto cercaNomeCorso(String nomeCorso) {
//		Metodo poco elegante
//		for(Voto v : this.voti) {
//			if(nomeCorso.equals(v.getCorso()))
//				return v;
//		}
//		return null;
		
		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
//		pos mi restituisce la posizione in cui si trova l'esame 'nomeCorso'
		if(pos != -1) 
			return this.voti.get(pos);
		else 
			return null;
	}
	
	/**
	 * Ritorna {@code true} se il corso specificato da {@code v}
	 * esiste nel libretto, con la stessa valutazione.
	 * Se non esiste, o se la valutazione è diversa, ritorna {@code false}.
	 * @param v : il {@link Voto} da ricercare. 
	 * @return l'esistenza di un duplicato. 
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste == null)
			return false;
		/*
		if(esiste.getVoto() == v.getVoto())
				return true;
			else
				return false; */
		return ( esiste.getVoto() == v.getVoto() ); // Stesso significato delle righe precedenti
	} 
	
	/**
	 * Determina se esiste un {@link Voto} con lo stesso nome corso ma con
	 * valutazione diversa.
	 * @param v : il {@link Voto} da ricercare.
	 * @return l'esistenza di un conflitto.
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste == null)
			return false;
		return ( esiste.getVoto() != v.getVoto() );
	}
	
}
