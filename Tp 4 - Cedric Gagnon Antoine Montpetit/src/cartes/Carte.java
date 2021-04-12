package cartes;

import java.io.Serializable;

public class Carte implements Comparable<Carte>, Serializable
{
	
	/**
	 * Comparable serialVesionUID Value
	 */
	private static final long serialVersionUID = -7258697722759706370L;

	/**
	 * ?
	 */
	public static final char IMAGE_DOS = '☺';
	
	/**
	 * la carte est visible
	 */
	private boolean visible = false;
	
	/**
	 * La sorte de la carte
	 */
	private SorteCartes sorte;
	
	/**
	 * La valuer de la carte
	 */
	private ValeurCartes valeur;
	
	/**
	 * Créé une carte avec une valeur et une sorte
	 * @param pValeur - la valeur de la carte
	 * @param pSorte - la sorte de la carte
	 */
	public Carte(ValeurCartes pValeur, SorteCartes pSorte) {
		sorte=pSorte;
		valeur=pValeur;
	}
	
	/**
	 * retourne la valeur de la carte
	 * @return - la valeur de la carte
	 */
	public ValeurCartes getValeur() {
		return(valeur);
	}
	
	/**
	 * Défénit la valeur de la carte
	 * @param pValeur - la nouvelle valeur de la carte
	 */
	private void setValeur(ValeurCartes pValeur) {
		valeur=pValeur;
	}
	
	/**
	 * Retourn de le symbole de la carte
	 * @return - le symbole de la carte
	 */
	public String getValeurSymbole() {
		return(valeur.getSymbole());
	}
	
	/**
	 * retourne la sorte de la carte
	 * @return - la sorte de la carte
	 */
	public SorteCartes getSorte() {
		return(sorte);
	}
	
	/**
	 * Défénit une nouvelle sorte de carte
	 * @param pSorte - la nouvelle sorte de carte
	 */
	private void setSorte(SorteCartes pSorte) {
		sorte=pSorte;
	}
	
	/**
	 * Retourne le symbole de la carte
	 * @return - le symbole de la carte
	 */
	public char getSorteSymbole() {
		return(sorte.getSymbole());
	}
	
	/**
	 * retourne la visibilité de la carte
	 * @return - true si la carte est visible
	 */
	public boolean estVisible() {
		return(visible);
	}
	
	/**
	 * Défénit la visibilité de la carte
	 * @param pVisible - la nouvelle visibilité de la carte
	 */
	public void setVisible(boolean pVisible) {
		visible=pVisible;
	}
	
	/**
	 * Retourne un string de la carte
	 * @return - un string de la carte
	 */
	public String toStringCarte() {
		return(visible ? (valeur.getSymbole()+sorte.getSymbole()):(IMAGE_DOS+""));
	}
	
	@Override
	public boolean equals(Object pObject) {
		return(pObject instanceof Carte && sorte.equals(((Carte)pObject).sorte) && valeur.equals(((Carte)pObject).valeur) && visible==((Carte)pObject).visible);
	}
	
	@Override
	public int compareTo(Carte pCarte) {
		return((valeur.getSymbole() + sorte.getSymbole()).compareTo(pCarte.valeur.getSymbole() + pCarte.sorte.getSymbole()));
	}
	
	@Override
	public String toString() {
		return(valeur.getSymbole()+sorte.getSymbole());
		//return(valeur.getSymbole()+sorte.getSymbole()+", "+visible);
	}
}
