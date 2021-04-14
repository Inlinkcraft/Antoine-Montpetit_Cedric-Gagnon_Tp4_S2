package test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cartes.*;
import exceptions.PileException;
import exceptions.PiocheException;

public class PiocheTest {
	
	Pioche p1, p2;
	
	@Before
	public void beforePioche() {
		p1 = new Pioche(new PaquetDeCartes());
		p2 = new Pioche(null);
	}

	@Test
	public void testPioche() {
		assertEquals(p1.size(),13*4);
		assertEquals(p2.size(),0);
	}

	@Test
	public void testPiger() {
		assertEquals(p1.piger(),new Carte(ValeurCartes.V_AS,SorteCartes.COEUR));
		assertEquals(p1.piger(),new Carte(ValeurCartes.V_2,SorteCartes.COEUR));
		assertEquals(p2.piger(),null);
	}

	@Test
	public void testConsulterDessus() {
		assertEquals(p1.consulterDessus(),new Carte(ValeurCartes.V_AS,SorteCartes.COEUR).toStringCarte());
		assertEquals(p1.consulterDessus(),new Carte(ValeurCartes.V_AS,SorteCartes.COEUR).toStringCarte());
		try {
			assertEquals(p2.consulterDessus(),null);
			fail("Ne peut consulter dessus d'une pioche vide");
		}
		catch(PiocheException e) {
		}
	}

	@Test
	public void testIsEmpty() {
		assertFalse(p1.isEmpty());
		assertTrue(p2.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(p1.size(),52);
		assertEquals(p2.size(),0);
	}

	@Test
	public void testToString() {
		assertEquals(p1.toString(),new Carte(ValeurCartes.V_AS,SorteCartes.COEUR).toString());
		try {
			p2.toString();
		}
		catch(PileException e) {
		}
	}

}
