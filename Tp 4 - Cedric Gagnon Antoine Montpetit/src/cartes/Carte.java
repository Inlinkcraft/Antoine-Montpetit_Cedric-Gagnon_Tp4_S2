package cartes;

import java.io.Serializable;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 * 
 */
public class Carte implements Comparable<Carte>, Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7258697722759706370L;

	/**
	 * Image du dos de la carte
	 */
	public static final char IMAGE_DOS = '☺';
	
	/**
	 * Un boolean pour savoir si une carte est face visible (vrai) ou pas (faux)
	 */
	private boolean visible = false;
	
	/**
	 * La sorte de la carte (Coeur, carreau, pique et trèfle).
	 */
	private SorteCartes sorte;
	
	/**
	 * La valeur de la carte.
	 */
	private ValeurCartes valeur;
	
	/**
	 * Constructeur avec paramètres.
	 * @param pValeur - la valeur de la carte
	 * @param pSorte - la sorte de la carte (Coeur, carreau, pique et trèfle)
	 */
	public Carte(ValeurCartes pValeur, SorteCartes pSorte) throws exceptions.ConstructeurException {
		if(pValeur==null || pSorte == null)
			throw new exceptions.ConstructeurException();
		sorte=pSorte;
		valeur=pValeur;
	}
	
	/**
	 * Obtenir la valeur de la carte
	 * @return un objet de l'énumération.
	 */
	public ValeurCartes getValeur() {
		return(valeur);
	}
	
	/**
	 * Mettre à jour la valeur de la carte
	 * @param pValeur - la nouvelle valeur de la carte, null n'est pas accepté
	 */
	private void setValeur(ValeurCartes pValeur) {
		if(pValeur!=null) {
			valeur=pValeur;
		}
	}
	
	/**
	 * Obtenir la représentation chaîne de caractères pour la valeur de la carte.
	 * @return la chaîne représentant la valeur de la carte.
	 */
	public String getValeurSymbole() {
		return(valeur.getSymbole());
	}
	
	/**
	 * Obtenir la sorte de carte (Coeur, carreau, pique et trèfle)
	 * @return un objet énumération qui représente la sorte de la carte
	 */
	public SorteCartes getSorte() {
		return(sorte);
	}
	
	/**
	 * Mettre à jour la sorte de carte
	 * @param pSorte - la nouvelle sorte de carte, null n'est pas accepté
	 */
	private void setSorte(SorteCartes pSorte) {
		if(pSorte!=null) {
			sorte=pSorte;
		}
	}
	
	/**
	 * Obtenir la représentation caractère pour la sorte de carte.
	 * @return le caractère représentant la sorte de carte.
	 */
	public char getSorteSymbole() {
		return(sorte.getSymbole());
	}
	
	/**
	 * Permet de savoir si une carte est visible (face vers le haut ou pas)
	 * @return vrai si la face est vers le haut
	 */
	public boolean estVisible() {
		return(visible);
	}
	
	/**
	 * Permet de modifier la visibilité d'une carte (retourne la carte), soit on voit le dos avec "false" ou sa face visible avec "true"
	 * @param pVisible - , vrai si on veut que la carte soit visible, faux sinon.
	 */
	public void setVisible(boolean pVisible) {
		visible=pVisible;
	}
	
	/**
	 * Retourne l'image de la carte selon sa visibilité.
	 * @return l'image de la carte. Une concaténation du symbole de la valeur et du symbole de la sorte OU l'image du dos
	 */
	public String toStringCarte() {
		return(visible ? (valeur.getSymbole()+sorte.getSymbole()):(IMAGE_DOS+""));
	}
	
	@Override
	/**
	 * Permet de savoir si deux cartes sont égales en terme de valeur et de sorte.
	 * @param obj - , l'objet à comparer avec l'objet courant "this"
	 * @return vrai si les deux cartes sont visibles et qu'elles ont la même valeur et la même sorte.
	 */
	public boolean equals(Object pObject) {
		return(pObject instanceof Carte && sorte.equals(((Carte)pObject).sorte) && valeur.equals(((Carte)pObject).valeur) && visible==((Carte)pObject).visible);
	}
	
	/**
	 * Compare 2 cartes selon leur valeur et leur sorte.
	 * @param obj, - l'objet carte à comparer
	 * @return une valeur négative ou = à 0 ou positive selon que l'objet courant est plus < ou = ou > que l'objet reçu en entrée.
	 */
	public int compareTo(Carte pCarte) {
		return(int)Math.signum((pCarte==null)?1:(0 + ((getValeur().getValeur()==pCarte.getValeur().getValeur())?((getSorte().getSymbole()+"").compareTo(pCarte.getSorte().getSymbole()+"")):(getValeur().getValeur()-pCarte.getValeur().getValeur()))));
		//if null, 1, else:
			//if values equal, compare chars of sorte, else:
				//signum of difference of values (1 or -1)
		
	}
	
	@Override
	/**
	 * Obtenir une chaîne des infos au sujet d'une carte.
	 */
	public String toString() {
		return(new String(valeur.getSymbole()+sorte.getSymbole()));
		//return(valeur.getSymbole()+sorte.getSymbole()+", "+visible);
	}
}
