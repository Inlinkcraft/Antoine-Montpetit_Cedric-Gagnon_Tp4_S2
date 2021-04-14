package cartes;

import java.awt.Color;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public enum SorteCartes
{
	/**
	 * Les carte
	 */
	COEUR('♥', Color.RED), CARREAU('\u2666', Color.RED), PIQUE('♠',
			Color.BLACK), TREFLE('♣', Color.BLACK);

	/**
	 * Le symbole de la carte
	 */
	private char symbole = ' ';
	
	/**
	 * La couleur de la carte
	 */
	private Color couleur = null;

	/**
	 * Crée une sorte de carte
	 * @param symbole - le symbole de la sorte
	 * @param couleur - la couleur de la sorte
	 */
	private SorteCartes(char symbole, Color couleur)
	{
		setSymbole(symbole);
		setCouleur(couleur);
	}

	/**
	 * Retourne le symbole de la sorte
	 * @return - le symbole de la sorte
	 */
	public char getSymbole()
	{
		return symbole;
	}

	/**
	 * Défénit un nouveau symbole a la sorte
	 * @param symbole - le nouveau symbole
	 */
	private void setSymbole(char symbole)
	{
		this.symbole = symbole;
	}

	/**
	 * Retourne la couleur de la sorte
	 * @return - la couleur de la sorte
	 */
	public Color getCouleur()
	{
		return couleur;
	}
	
	/**
	 * Défénit une nouvelle couleur a la sorte
	 * @param couleur - la nouvelle couleur
	 */
	private void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}

	@Override
	public String toString()
	{
		return getSymbole() + "";
	}
}
