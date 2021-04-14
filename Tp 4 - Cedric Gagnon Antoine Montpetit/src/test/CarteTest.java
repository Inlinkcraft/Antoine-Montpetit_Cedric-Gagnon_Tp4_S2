package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.SorteCartes;
import cartes.ValeurCartes;
import exceptions.ConstructeurException;

public class CarteTest
{
	Carte c1, c2, c3, c4;
	
	@Before
	public void testCarteBefore()
	{
		c1 = new Carte(ValeurCartes.V_2, SorteCartes.COEUR);
		c2 = new Carte(ValeurCartes.V_4, SorteCartes.TREFLE);
		c3 = new Carte(ValeurCartes.V_8, SorteCartes.CARREAU);
		c4 = new Carte(ValeurCartes.V_KING, SorteCartes.PIQUE);
		
		try {
			new Carte(null, SorteCartes.CARREAU);
			fail("Les carte ne peuvent pas avoir de sorte null");
		}catch(ConstructeurException e) {
			
		}
		
		try {
			new Carte(ValeurCartes.V_2, null);
			fail("Les carte ne peuvent pas avoir de valeur null");
		}catch(ConstructeurException e) {
			
		}
	}
	
	@After
	public void testCarteAfter()
	{
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
	}

	@Test
	public void testGetValeur()
	{
		assertEquals(c1.getValeur(), ValeurCartes.V_2);
		assertEquals(c2.getValeur(), ValeurCartes.V_4);
		assertEquals(c3.getValeur(), ValeurCartes.V_8);
		assertEquals(c4.getValeur(), ValeurCartes.V_KING);
	}

	@Test
	public void testGetValeurSymbole()
	{
		assertEquals(c1.getValeurSymbole(), ValeurCartes.V_2.getSymbole());
		assertEquals(c2.getValeurSymbole(), ValeurCartes.V_4.getSymbole());
		assertEquals(c3.getValeurSymbole(), ValeurCartes.V_8.getSymbole());
		assertEquals(c4.getValeurSymbole(), ValeurCartes.V_KING.getSymbole());
	}

	@Test
	public void testGetSorte()
	{
		assertEquals(c1.getSorte(), SorteCartes.COEUR);
		assertEquals(c2.getSorte(), SorteCartes.TREFLE);
		assertEquals(c3.getSorte(), SorteCartes.CARREAU);
		assertEquals(c4.getSorte(), SorteCartes.PIQUE);
	}

	@Test
	public void testGetSorteSymbole()
	{
		assertEquals(c1.getSorte(), SorteCartes.COEUR.getSymbole());
		assertEquals(c2.getSorte(), SorteCartes.TREFLE.getSymbole());
		assertEquals(c3.getSorte(), SorteCartes.CARREAU.getSymbole());
		assertEquals(c4.getSorte(), SorteCartes.PIQUE.getSymbole());
	}

	@Test
	public void testEstVisible()
	{
		c1.setVisible(false);
		c2.setVisible(true);
		c3.setVisible(false);
		c4.setVisible(true);
		assertEquals(c1.estVisible(), false);
		assertEquals(c2.estVisible(), true);
		assertEquals(c3.estVisible(), false);
		assertEquals(c4.estVisible(), true);
	}

	@Test
	public void testSetVisible()
	{
		c1.setVisible(false);
		c2.setVisible(true);
		c3.setVisible(false);
		c4.setVisible(true);
		assertEquals(c1.estVisible(), false);
		assertEquals(c2.estVisible(), true);
		assertEquals(c3.estVisible(), false);
		assertEquals(c4.estVisible(), true);
	}

	@Test
	public void testToStringCarte()
	{
		c1.setVisible(false);
		c2.setVisible(true);
		c3.setVisible(false);
		c4.setVisible(true);

		assertEquals(c1.toStringCarte(), Carte.IMAGE_DOS + "");
		assertEquals(c2.toStringCarte(), c2.getValeurSymbole() + "" + c2.getSorteSymbole());
		assertEquals(c3.toStringCarte(), Carte.IMAGE_DOS + "");
		assertEquals(c4.toStringCarte(), c4.getValeurSymbole() + "" + c4.getSorteSymbole());

	}

	@Test
	public void testEqualsObject()
	{
		c1.setVisible(false);
		c2.setVisible(true);
		c3.setVisible(false);
		c4.setVisible(true);
		
		assertEquals(c1.equals(c2), false);
		assertEquals(c1.equals(c3), false);
		assertEquals(c1.equals(c4), false);
		assertEquals(c1.equals(null), false);
		assertEquals(c1.equals((Object)"Hello"), false);
		
		Carte c5 = new Carte(ValeurCartes.V_2, SorteCartes.COEUR);
		
		assertEquals(c1.equals(c5), true);
	}

	@Test
	public void testCompareTo()
	{
		c1.setVisible(false);
		c2.setVisible(true);
		c3.setVisible(false);
		c4.setVisible(true);
		
		assertEquals(c1.compareTo(c2), -1);
		assertEquals(c1.compareTo(c3), -1);
		assertEquals(c1.compareTo(c4), -1);
		assertEquals(c4.compareTo(c1), 1);
		assertEquals(c1.compareTo(null), 1);
		
		Carte c5 = new Carte(ValeurCartes.V_2, SorteCartes.COEUR);
		
		assertEquals(c1.compareTo(c5), 0);
	}

	@Test
	public void testToString()
	{
		
	}

}
