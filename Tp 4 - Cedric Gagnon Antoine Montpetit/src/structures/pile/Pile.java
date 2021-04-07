package structures.pile;

import java.io.Serializable;

import exception.PileException;

public class Pile implements Serializable
{
	
	private static final long serialVersionUID = -5590576741359778573L;
	
	private int taille = 0;
	
	private NoeudPile sommet = null;
	
	public Pile() {
		vider();
	}
	
	public boolean isEmpty() {
		return(sommet==null);
	}
	
	public void vider() {
		sommet=null;
		taille=0;
	}
	
	public void empiler(Object pObj) {
		sommet = new NoeudPile(pObj, sommet);
		taille++;
	}
	
	public Object getPremier() throws PileException {
		if(sommet==null)
			throw new PileException("Pile vide");
		return(sommet.getElement());
	}
	
	public Object depiler() throws PileException {
		if(sommet==null)
			throw new PileException("Pile vide");
		Object temp = sommet.getElement();
		sommet=sommet.getPrecedent();
		taille--;
		return(temp);
	}
	
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
