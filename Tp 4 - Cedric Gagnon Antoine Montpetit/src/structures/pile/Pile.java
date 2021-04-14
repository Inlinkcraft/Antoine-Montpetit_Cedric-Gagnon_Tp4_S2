package structures.pile;

import java.io.Serializable;

import exceptions.PileException;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class Pile implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5590576741359778573L;
	
	/**
	 * Conserve le nombre d'éléments dans la pile
	 */
	private int taille = 0;
	
	/**
	 * Pointeur pour le sommet de la pile
	 */
	private NoeudPile sommet = null;
	
	/**
	 * Construit une pile vide
	 */
	public Pile() {
		vider();
	}
	
	/**
	 * Vérifie si la pile est vide
	 * @return vrai si elle est vide
	 */
	public boolean isEmpty() {
		return(sommet==null);
	}
	
	/**
	 * Vide la pile
	 */
	public void vider() {
		sommet=null;
		taille=0;
	}
	
	/**
	 * Empile un objet dans la pile.
	 * @param pObj, - l'élément à empiler
	 */
	public void empiler(Object pObj) {
		sommet = new NoeudPile(pObj, sommet);
		taille++;
	}
	
	/**
	 * Retourne l'objet contenu dans le noeud sur le dessus de la pile sans le dépiler.
	 * @return l'objet sur le dessus de la pile.
	 * @throws exceptions.PileException
	 */
	public Object getPremier() throws PileException {
		if(sommet==null)
			throw new PileException("Pile vide");
		return(sommet.getElement());
	}
	
	/**
	 * Retourne l'objet dépilé.
	 * @return l'élément dépilé
	 * @throws PileException
	 */
	public Object depiler() throws PileException {
		if(sommet==null)
			throw new PileException("Pile vide");
		Object temp = sommet.getElement();
		sommet=sommet.getPrecedent();
		taille--;
		return(temp);
	}
	
	/**
	 * Retourne le nombre d'éléments dans la pile
	 * @return le nombre d'éléments dans la pile
	 */
	public int size() {
		return(taille);
	}
	
	@Override
	/**
	 * Permet de créer une chaîne représentant les éléments qui sont dans la pile.
	 * @return String representation
	 */
	public String toString() {
		String out = "";
		NoeudPile current = sommet;
		while(current!=null) {
			out+=current.getElement().toString();
			current=current.getPrecedent();
		}
		return(out);
	}
}
