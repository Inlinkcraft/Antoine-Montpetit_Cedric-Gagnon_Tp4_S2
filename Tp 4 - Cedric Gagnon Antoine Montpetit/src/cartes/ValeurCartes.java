package cartes;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public enum ValeurCartes
{
	/**
	 * Les valeur d'une carte
	 */
	V_AS("A", 1), V_2("2", 2), V_3("3", 3), V_4("4", 4), V_5("5", 5), V_6("6",
			6), V_7("7", 7), V_8("8", 8), V_9("9", 9), V_10("10",
					10), V_JACK("J", 11), V_QUEEN("Q", 12), V_KING("K", 13);

	/**
	 * Le symbole
	 */
	private String symbole = null;
	
	/**
	 * La valeur
	 */
	private int valeur = 0;

	/**
	 * Crée une valeur
	 * @param symbole - le symbole de la valeur
	 * @param valeur - la valeur
	 */
	private ValeurCartes(String symbole, int valeur)
	{
		setSymbole(symbole);
		setValeur(valeur);
	}

	/**
	 * retourne le symbole de la valeur
	 * @return - le symbole de la valeur
	 */
	public String getSymbole()
	{
		return symbole;
	}

	/**
	 * Défénit un nouveau symbole pour la valeur
	 * @param symbole - le nouveau symbole
	 */
	private void setSymbole(String symbole)
	{
		this.symbole = symbole;
	}

	/**
	 * Retourne la valeur de la valeur
	 * @return - la valeur de la valeur
	 */
	public int getValeur()
	{
		return valeur;
	}

	/**
	 * Défénit une nouvelle valeur a la valeur
	 * @param valeur - la nouvealle valeur
	 */
	private void setValeur(int valeur)
	{
		this.valeur = valeur;
	}

	@Override
	public String toString()
	{
		return getValeur() + " " + getSymbole();
	}
}
