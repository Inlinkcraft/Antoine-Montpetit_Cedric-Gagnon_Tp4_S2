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
	 * Retourne vrai si la pile est vide
	 * @return - true si la pile est vide
	 */
	public boolean isEmpty() {
		return(sommet==null);
	}
	
	/**
	 * Suprime tous les élément d'une pile
	 */
	public void vider() {
		sommet=null;
		taille=0;
	}
	
	/**
	 * Empile un objet dans la pile.
	 * @param pObj - le nouveau element
	 */
	public void empiler(Object pObj) {
		sommet = new NoeudPile(pObj, sommet);
		taille++;
	}
	
	/**
	 * Retourne le premier object de la pile
	 * @return - le premier object de la pile
	 * @throws PileException - si la pile est vide
	 */
	public Object getPremier() throws PileException {
		if(sommet==null)
			throw new PileException("Pile vide");
		return(sommet.getElement());
	}
	
	/**
	 * Retourne l'objet dépilé.
	 * @return - le premier élement de la pile
	 * @throws PileException - si la pile est vide
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
	 * Retourne la grosseur de la pile
	 * @return - la grosseur de la pile
	 */
	public int size() {
		return(taille);
	}
	
	@Override
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
