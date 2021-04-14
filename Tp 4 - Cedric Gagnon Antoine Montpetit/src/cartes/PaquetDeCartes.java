package cartes;

import java.util.List;

import exceptions.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class PaquetDeCartes implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3341401817217136754L;

	/**
	 * Nombre d'échanges pour brasser un paquet de carte
	 */
	public static final int NBR_ECHANGES = 1000;
	
	/**
	 * Le paquet de cartes, une structure qui hérite de l'interface java "List"
	 */
	private List<Carte> paquet;
	
	/**
	 * Constructeur permettant de créer un paquet complet de cartes de 4 sortes X 13 cartes.
	 */
	public PaquetDeCartes() {
		paquet = new ArrayList<Carte>();
		for(int i=0;i<ValeurCartes.values().length*SorteCartes.values().length;i++) {
			paquet.add(new Carte(ValeurCartes.values()[i%ValeurCartes.values().length],SorteCartes.values()[i/ValeurCartes.values().length%SorteCartes.values().length]));
		}
	}
	
	/**
	 * Constructeur avec paramètre permettant de faire des tests.
	 * @param pPaquet - , un paquet de cartes. Ne peut-être "null"
	 */
	public PaquetDeCartes(List<Carte> pPaquet) throws exceptions.ConstructeurException {
		paquet = pPaquet;
	}
	
	/**
	 * Brasse le paquet de cartes en provoquant un certain nombre d'échanges entre les cartes du paquet.
	 */
	public void brasser() {
		int a;
		int b;
		for(int i=0;i<NBR_ECHANGES;i++) {
			a = (int) (Math.random()*paquet.size());
			do {
				b = (int) (Math.random()*paquet.size());
			} while(b==a);
			permuterCarte(a,b);
		}
	}
	
	/**
	 * Permet de permuter 2 cartes dans le paquet selon leur position
	 * @param a, - index d'une carte
	 * @param b, - index d'une autre carte
	 */
	private void permuterCarte(int a, int b) {
		Carte temp;
		temp=paquet.get(a);
		paquet.set(a,paquet.get(b));
		paquet.set(b, temp);
	}
	
	/**
	 * Consulte, sans la retirer, une carte du paquet selon la position voulue.
	 * @param index - , la position voulue entre 1 et le nombre de cartes dans le paquet.
	 * @return la carte choisie ou "null" si le paquet est vide ou si la position est invalide.
	 */
	public Carte consulterCarte(int index) {
		return(validerPosition(index)?paquet.get(index-1):null);
	}
	
	/**
	 * Retire une carte du paquet selon la position voulue.
	 * @param index - index de la carte
	 * @return - retourne la carte
	 */
	public Carte prendreCarte(int index) {
		return(validerPosition(index)?paquet.remove(index-1):null);
	}
	
	/**
	 * Rend toutes les cartes du paquet visibles ou invisibles (face cachée).
	 * @param visible, - vrai pour visible et faux pour face cachée
	 */
	public void retournerToutesLesCartes(boolean visible) {
		for(int i=0;i<paquet.size();i++) {
			paquet.get(i).setVisible(visible);
		}
	}
	
	/**
	 * Permet de savoir le nombre de cartes dans le paquet.
	 * @return le nombre de cartes.
	 */
	public int size() {
		return(paquet.size());
	}
	
	/**
	 * Permet de savoir si le paquet de cartes est vide
	 * @return vrai si le paquet est vide
	 */
	public boolean isEmpty() {
		return(paquet.isEmpty());
	}
	
	/**
	 * Valide si l'entier reçu en entrée est valide selon le nombre de cartes dans le paquet.
	 * @param - , une position dans le paquet entre 1 et la taille du paquet
	 * @return vrai si l'entier est valide selon le nombre de cartes dans le paquet
	 */
	private boolean validerPosition(int position) {
		return(position>0 && position<=paquet.size());
	}
	
	/**
	 * Le main pour nos test
	 * @param args - des argument?
	 */
	public static void main(String[] args)
	{
		PaquetDeCartes test = new PaquetDeCartes();
		System.out.println(test.paquet);
	}
}
