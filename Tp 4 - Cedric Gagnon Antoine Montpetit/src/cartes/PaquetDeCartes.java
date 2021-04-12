package cartes;

import java.util.List;
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
	 * Comparable serialVersionUID values
	 */
	private static final long serialVersionUID = 3341401817217136754L;

	/**
	 * Le nombre de mélange
	 */
	public static final int NBR_ECHANGES = 1000;
	
	/**
	 * Le paquet de carte
	 */
	private List<Carte> paquet;
	
	/**
	 * Créé un paquet de carte
	 */
	public PaquetDeCartes() {
		paquet = new ArrayList<Carte>();
		for(int i=0;i<ValeurCartes.values().length*SorteCartes.values().length;i++) {
			paquet.add(new Carte(ValeurCartes.values()[i%ValeurCartes.values().length],SorteCartes.values()[i/ValeurCartes.values().length%SorteCartes.values().length]));
		}
	}
	
	/**
	 * Créé un paquet de carte avec une liste de carte
	 * @param pPaquet - liste de carte
	 */
	public PaquetDeCartes(List<Carte> pPaquet) {
		paquet = pPaquet;
	}
	
	/**
	 * Mélanger les cartes 
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
	 * Échange deux carte de place
	 * @param a - la première carte
	 * @param b - la deuxieme carte
	 */
	private void permuterCarte(int a, int b) {
		Carte temp;
		temp=paquet.get(a);
		paquet.set(a,paquet.get(b));
		paquet.set(b, temp);
	}
	
	/**
	 * Valide si une carte est dans le paquet et retourne la carte
	 * @param index - index de la carte
	 * @return - retourne la carte
	 */
	public Carte consulterCarte(int index) {
		return(validerPosition(index)?paquet.get(index-1):null);
	}
	
	/**
	 * Valide si une carte est dans le paquet et enleve la carte
	 * @param index - index de la carte
	 * @return - retourne la carte
	 */
	public Carte prendreCarte(int index) {
		return(validerPosition(index)?paquet.remove(index-1):null);
	}
	
	/**
	 * retourne toute les carte du coté défénit
	 * @param visible - la visibilité des carte
	 */
	public void retournerToutesLesCartes(boolean visible) {
		for(int i=0;i<paquet.size();i++) {
			paquet.get(i).setVisible(visible);
		}
	}
	
	/**
	 * La grosseur du paquet
	 * @return - la grosseur du paquet
	 */
	public int size() {
		return(paquet.size());
	}
	
	/**
	 * retourne vrai si le paquet est vide
	 * @return - true si le paquet est vide
	 */
	public boolean isEmpty() {
		return(paquet.isEmpty());
	}
	
	/**
	 * Valide la position d'une carte
	 * @param position
	 * @return
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
