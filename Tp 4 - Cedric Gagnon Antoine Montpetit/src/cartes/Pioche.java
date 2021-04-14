package cartes;

import java.io.Serializable;

import exceptions.PiocheException;
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
	 * 
	 */
	private static final long serialVersionUID = -5454905195453222565L;
	
	/**
	 * la pile qui va représenter notre pioche
	 */
	private Pile pioche;
	
	/**
	 * Constructeur.
	 * @param paquet, - le paquet de cartes à mettre dans la pioche. Peut être un pointeur "null", qui donne une pioche vide.
	 */
	public Pioche(PaquetDeCartes paquet) {
		pioche = new Pile();
		while(paquet.size()>0) {
			pioche.empiler(paquet.prendreCarte(paquet.size()));
		}
	}
	
	/**
	 * Permet de piger une carte sur le dessus du paquet.
	 * @return la carte pigée ou null si le paquet est vide.
	 */
	public Carte piger() {
		return(pioche.size()>0?(Carte)pioche.depiler():null);
	}
	
	/**
	 * Permet de voir la carte du dessus sans la piger.
	 * @return une chaîne qui représente la carte du dessus si la pioche n'est pas vide.
	 * @throws exceptions.PiocheException
	 */
	public String consulterDessus() throws exceptions.PiocheException {
		if(pioche.isEmpty())
			throw new PiocheException("Pioche vide");
		return(((Carte)pioche.getPremier()).toStringCarte());
	}
	
	/**
	 * Permet de savoir si la pioche est vide
	 * @return vrai si la pioche est vide.
	 */
	public boolean isEmpty() {
		return(pioche.isEmpty());
	}
	
	/**
	 * Retourne la taille de la pioche
	 * @return la taille.
	 */
	public int size() {
		return(pioche.size());
	}
	
	@Override
	public String toString() {
		return(pioche.getPremier().toString());
	}
}
