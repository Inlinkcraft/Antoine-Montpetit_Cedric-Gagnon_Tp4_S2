package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.PaquetDeCartes;
import cartes.SorteCartes;
import cartes.ValeurCartes;

public class PaquetDeCartesTest
{

	PaquetDeCartes p1, p2, p3, p4;
	
	@Before
	public void testPaquetDeCartesBefore()
	{
		p1 = new PaquetDeCartes();
		
		ArrayList<Carte> l1 = new ArrayList<Carte>();
		l1.add(new Carte(ValeurCartes.V_10, SorteCartes.CARREAU));
		l1.add(new Carte(ValeurCartes.V_2, SorteCartes.COEUR));
		l1.add(new Carte(ValeurCartes.V_KING, SorteCartes.CARREAU));
		l1.add(new Carte(ValeurCartes.V_8, SorteCartes.TREFLE));
		p2 = new PaquetDeCartes(l1);
		
		ArrayList<Carte> l2 = new ArrayList<Carte>();
		l2.add(new Carte(ValeurCartes.V_JACK, SorteCartes.TREFLE));
		l2.add(new Carte(ValeurCartes.V_5, SorteCartes.PIQUE));
		l2.add(new Carte(ValeurCartes.V_AS, SorteCartes.COEUR));
		l2.add(new Carte(ValeurCartes.V_3, SorteCartes.COEUR));
		p3 = new PaquetDeCartes(l2);
		
		ArrayList<Carte> l3 = new ArrayList<Carte>();
		l3.add(new Carte(ValeurCartes.V_QUEEN, SorteCartes.PIQUE));
		l3.add(new Carte(ValeurCartes.V_7, SorteCartes.CARREAU));
		l3.add(new Carte(ValeurCartes.V_2, SorteCartes.TREFLE));
		l3.add(new Carte(ValeurCartes.V_10, SorteCartes.PIQUE));
		p4 = new PaquetDeCartes(l3);
	}
	
	@After
	public void testPaquetDeCartesAfter()
	{
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
	}

	@Test
	public void testBrasser()
	{
		p1.brasser();
		PaquetDeCartes p5 = new PaquetDeCartes();
		int numberOfequals = 0;
		for (int i = 1; i < p1.size()+1; i++)
		{
			if (p1.consulterCarte(i).equals(p5.consulterCarte(i))) {
				numberOfequals++;
			}
		}
		if (numberOfequals/p5.size() > 0.1)
		{
			fail("Pas brasser");
		}
	}

	@Test
	public void testConsulterCarte()
	{
		assertEquals(p1.consulterCarte(1), new Carte(ValeurCartes.V_AS, SorteCartes.COEUR));
		assertEquals(p2.consulterCarte(2), new Carte(ValeurCartes.V_2, SorteCartes.COEUR));
		assertEquals(p3.consulterCarte(3), new Carte(ValeurCartes.V_AS, SorteCartes.COEUR));
		assertEquals(p4.consulterCarte(4), new Carte(ValeurCartes.V_10, SorteCartes.PIQUE));
	}

	@Test
	public void testPrendreCarte()
	{
		assertEquals(p1.prendreCarte(1), new Carte(ValeurCartes.V_AS, SorteCartes.COEUR));
		assertEquals(p2.prendreCarte(2), new Carte(ValeurCartes.V_2, SorteCartes.COEUR));
		assertEquals(p3.prendreCarte(3), new Carte(ValeurCartes.V_AS, SorteCartes.COEUR));
		assertEquals(p4.prendreCarte(4), new Carte(ValeurCartes.V_10, SorteCartes.PIQUE));
	}

	@Test
	public void testRetournerToutesLesCartes()
	{
		p1.retournerToutesLesCartes(true);
		for (int i = 1; i < p1.size()+1; i++)
		{
			assertEquals(p1.consulterCarte(i).estVisible(), true);
		}
		
		p2.retournerToutesLesCartes(true);
		for (int i = 1; i < p2.size()+1; i++)
		{
			assertEquals(p2.consulterCarte(i).estVisible(), true);
		}
		
		p3.retournerToutesLesCartes(false);
		for (int i = 1; i < p3.size()+1; i++)
		{
			assertEquals(p3.consulterCarte(i).estVisible(), false);
		}
		
		p4.retournerToutesLesCartes(false);
		for (int i = 1; i < p4.size()+1; i++)
		{
			assertEquals(p4.consulterCarte(i).estVisible(), false);
		}
		
	}

	@Test
	public void testSize()
	{
		assertEquals(p1.size(), 52);
		assertEquals(p2.size(), 4);
		assertEquals(p3.size(), 4);
		assertEquals(p4.size(), 4);
	}

	@Test
	public void testIsEmpty()
	{
		PaquetDeCartes p5 = new PaquetDeCartes(new ArrayList<Carte>());
		
		assertEquals(p5.isEmpty(), true);
		assertEquals(p1.isEmpty(), false);
		assertEquals(p2.isEmpty(), false);
		assertEquals(p3.isEmpty(), false);
		assertEquals(p4.isEmpty(), false);
		
	}


}
