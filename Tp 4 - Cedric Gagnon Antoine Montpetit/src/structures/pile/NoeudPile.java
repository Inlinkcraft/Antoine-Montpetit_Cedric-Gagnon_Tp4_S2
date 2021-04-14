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
	 * 
	 */
	private static final long serialVersionUID = 8903760988209232121L;
	
	/**
	 * Élément à conserver
	 */
	private Object element = null;
	
	/**
	 * Pointeur sur le noeud qui est en dessous
	 */
	private NoeudPile precedent = null;
	
	/**
	 * Constructeur
	 * @param elem, - l'élément à mettre dans le noeud
	 */
	public NoeudPile(Object elem) {
		element = elem;
	}
	
	/**
	 * Constructeur
	 * @param elem, - l'élément à mettre dans le noeud
	 * @param prev, - un pointeur sur un NoeudPile
	 */
	public NoeudPile(Object elem, NoeudPile prev) {
		element = elem;
		precedent = prev;
	}
	
	/**
	 * Obtenir l'élément contenu dans le noeud
	 * @return, l'objet dans le noeud
	 */
	public Object getElement() {
		return(element);
	}
	
	/**
	 * Modifier la valeur de l'élément contenu dans le noeud
	 * @param elem, - l'élément à mettre à jour
	 */
	public void setElement(Object elem) {
		element=elem;
	}
	
	/**
	 * Obtenir une référence sur le noeud précédent.
	 * @return, le pointeur sur le noeud précédent
	 */
	public NoeudPile getPrecedent() {
		return(precedent);
	}
	
	/**
	 * Modifier la valeur de la référence du noeud précédent.
	 * @param prev, - le pointeur du nouveau précédent
	 */
	public void setPrecedent(NoeudPile prev) {
		precedent = prev;
	}
	
}
