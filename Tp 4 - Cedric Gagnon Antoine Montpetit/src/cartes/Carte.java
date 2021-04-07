package cartes;

import java.io.Serializable;

public class Carte implements Comparable<Carte>, Serializable
{
	
	private static final long serialVersionUID = -7258697722759706370L;

	public static final char IMAGE_DOS = '☺';
	
	private boolean visible = false;
	
	private SorteCartes sorte;
	private ValeurCartes valeur;
	
	public Carte(ValeurCartes pValeur, SorteCartes pSorte) {
		sorte=pSorte;
		valeur=pValeur;
	}
	
	public ValeurCartes getValeur() {
		return(valeur);
	}
	
	private void setValeur(ValeurCartes pValeur) {
		valeur=pValeur;
	}
	
	public String getValeurSymbole() {
		return(valeur.getSymbole());
	}
	
	public SorteCartes getSorte() {
		return(sorte);
	}
	
	private void setSorte(SorteCartes pSorte) {
		sorte=pSorte;
	}
	
	public char getSorteSymbole() {
		return(sorte.getSymbole());
	}
	
	public boolean estVisible() {
		return(visible);
	}
	
	public void setVisible(boolean pVisible) {
		visible=pVisible;
	}
	
	public String toStringCarte() {
		return(visible ? (valeur.getSymbole()+sorte.getSymbole()):(IMAGE_DOS+""));
	}
	
	@Override
	public boolean equals(Object pObject) {
		return(pObject instanceof Carte && sorte.equals(((Carte)pObject).sorte) && valeur.equals(((Carte)pObject).valeur) && visible==((Carte)pObject).visible);
	}
	
	public int compareTo(Carte pCarte) {
		return((valeur.getSymbole() + sorte.getSymbole()).compareTo(pCarte.valeur.getSymbole() + pCarte.sorte.getSymbole()));
	}
	
	@Override
	public String toString() {
		return(valeur.getSymbole()+sorte.getSymbole());
		//return(valeur.getSymbole()+sorte.getSymbole()+", "+visible);
	}
}
