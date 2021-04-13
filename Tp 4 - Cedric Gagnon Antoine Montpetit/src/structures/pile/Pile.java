package structures.pile;

import java.io.Serializable;

import exception.PileException;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class Pile implements Serializable
{
	/**
	 * Compare to serialVersionUID value
	 */
	private static final long serialVersionUID = -5590576741359778573L;
	
	/**
	 * la taille de la pile
	 */
	private int taille = 0;
	
	/**
	 * Le noeu qui est au sommet de la pile
	 */
	private NoeudPile sommet = null;
	
	/**
	 * Crée une nouvelle pile vide
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
	 * Empile un nouveau élément dans la pile
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
	 * Enleve le premier élément de la pile
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
