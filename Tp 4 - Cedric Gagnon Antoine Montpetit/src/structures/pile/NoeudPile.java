package structures.pile;

import java.io.Serializable;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class NoeudPile implements Serializable 
{

	/**
	 * Compare to serialVersionUID value
	 */
	private static final long serialVersionUID = 8903760988209232121L;
	
	/**
	 * element contenue
	 */
	private Object element = null;
	
	/**
	 * le noeu précédent
	 */
	private NoeudPile precedent = null;
	
	/**
	 * Crée un noeu avec un element
	 * @param elem - l'élement contenue
	 */
	public NoeudPile(Object elem) {
		element = elem;
	}
	
	/**
	 * Crée un noeu avec un element et un noeu précédent
	 * @param elem - l'élement contenue
	 * @param prev - le noeu précédent
	 */
	public NoeudPile(Object elem, NoeudPile prev) {
		element = elem;
		precedent = prev;
	}
	
	/**
	 * Retourne l'élement du noeu
	 * @return - l'élement
	 */
	public Object getElement() {
		return(element);
	}
	
	/**
	 * Défénit un nouveau élement dans le noeu
	 * @param elem - le noueveau élément
	 */
	public void setElement(Object elem) {
		element=elem;
	}
	
	/**
	 * Retourne le noeu précédent dans la pile
	 * @return
	 */
	public NoeudPile getPrecedent() {
		return(precedent);
	}
	
	/**
	 * Défénit un nouveau noeu précédent
	 * @param prev - le nouveau noeu précédent
	 */
	public void setPrecedent(NoeudPile prev) {
		precedent = prev;
	}
	
}
