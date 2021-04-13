package cartes;

import java.io.Serializable;

import exception.PiocheException;
import structures.pile.Pile;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class Pioche implements Serializable
{
	
	/**
	 * Compare to serialVersionUID value
	 */
	private static final long serialVersionUID = -5454905195453222565L;
	
	/**
	 * La pioche
	 */
	private Pile pioche;
	
	/**
	 * Crée une pioche avec un paquet défénit
	 * @param paquet - le paquet
	 */
	public Pioche(PaquetDeCartes paquet) {
		pioche = new Pile();
		while(paquet.size()>0) {
			pioche.empiler(paquet.prendreCarte(paquet.size()));
		}
	}
	
	/**
	 * Pige une carte de la pioche
	 * @return - une carte
	 */
	public Carte piger() {
		return(pioche.size()>0?(Carte)pioche.depiler():null);
	}
	
	/**
	 * retourne la carte sur le dessus de la pioche
	 * @return - la carte du dessu de la pioche
	 */
	public String consulterDessus() {
		if(pioche.isEmpty())
			throw new PiocheException("Pioche vide");
		return(((Carte)pioche.getPremier()).toStringCarte());
	}
	
	/**
	 * Retourne vrai si la pioche est vide
	 * @return - true si la pioche est vide
	 */
	public boolean isEmpty() {
		return(pioche.isEmpty());
	}
	
	/**
	 * Retourne la grosseur de la pioche
	 * @return - la grosseur de la pioche
	 */
	public int size() {
		return(pioche.size());
	}
	
	@Override
	public String toString() {
		return(pioche.getPremier().toString());
	}
}
