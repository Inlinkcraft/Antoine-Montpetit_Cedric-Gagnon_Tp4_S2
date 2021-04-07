package structures.pile;

import java.io.Serializable;

public class NoeudPile implements Serializable 
{

	private static final long serialVersionUID = 8903760988209232121L;
	
	private Object element = null;
	
	private NoeudPile precedent = null;
	
	public NoeudPile(Object elem) {
		element = elem;
	}
	
	public NoeudPile(Object elem, NoeudPile prev) {
		element = elem;
		precedent = prev;
	}
	
	public Object getElement() {
		return(element);
	}
	
	public void setElement(Object elem) {
		element=elem;
	}
	
	public NoeudPile getPrecedent() {
		return(precedent);
	}
	
	public void setPrecedent(NoeudPile prev) {
		precedent = prev;
	}
	
}
