package cartes;

import java.io.Serializable;

import exception.PiocheException;
import structures.pile.Pile;


public class Pioche implements Serializable
{
	
	private static final long serialVersionUID = -5454905195453222565L;
	
	private Pile pioche;
	
	public Pioche(PaquetDeCartes paquet) {
		pioche = new Pile();
		while(paquet.size()>0) {
			pioche.empiler(paquet.prendreCarte(paquet.size()));
		}
	}
	
	public Carte piger() {
		return(pioche.size()>0?(Carte)pioche.depiler():null);
	}
	
	public String consulterDessus() {
		if(pioche.isEmpty())
			throw new PiocheException("Pioche vide");
		return(((Carte)pioche.getPremier()).toStringCarte());
	}
	
	public boolean isEmpty() {
		return(pioche.isEmpty());
	}
	
	public int size() {
		return(pioche.size());
	}
}
