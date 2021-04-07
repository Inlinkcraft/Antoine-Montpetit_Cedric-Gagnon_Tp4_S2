package cartes;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class PaquetDeCartes implements Serializable
{

	private static final long serialVersionUID = 3341401817217136754L;

	public static final int NBR_ECHANGES = 1000;
	
	private List<Carte> paquet;
	
	public PaquetDeCartes() {
		paquet = new ArrayList<Carte>();
		for(int i=0;i<ValeurCartes.values().length*SorteCartes.values().length;i++) {
			paquet.add(new Carte(ValeurCartes.values()[i%ValeurCartes.values().length],SorteCartes.values()[i/ValeurCartes.values().length%SorteCartes.values().length]));
		}
	}
	
	public PaquetDeCartes(List<Carte> pPaquet) {
		paquet = pPaquet;
	}
	
	public void brasser() {
		int a;
		int b;
		for(int i=0;i<NBR_ECHANGES;i++) {
			a = (int) (Math.random()*paquet.size());
			do {
				b = (int) (Math.random()*paquet.size());
			} while(b==a);
			permuterCarte(a,b);
		}
	}
	
	private void permuterCarte(int a, int b) {
		Carte temp;
		temp=paquet.get(a);
		paquet.set(a,paquet.get(b));
		paquet.set(b, temp);
	}
	
	public Carte consulterCarte(int index) {
		return(validerPosition(index)?paquet.get(index-1):null);
	}
	
	public Carte prendreCarte(int index) {
		return(validerPosition(index)?paquet.remove(index-1):null);
	}
	
	public void retournerToutesLesCartes(boolean visible) {
		for(int i=0;i<paquet.size();i++) {
			paquet.get(i).setVisible(visible);
		}
	}
	
	public int size() {
		return(paquet.size());
	}
	
	public boolean isEmpty() {
		return(paquet.isEmpty());
	}
	
	private boolean validerPosition(int position) {
		return(position>0 && position<=paquet.size());
	}
	
	public static void main(String[] args)
	{
		PaquetDeCartes test = new PaquetDeCartes();
		System.out.println(test.paquet);
	}
}
