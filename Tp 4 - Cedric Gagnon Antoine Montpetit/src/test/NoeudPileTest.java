package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structures.pile.NoeudPile;

public class NoeudPileTest
{

	NoeudPile n1, n2, n3, n4;
	
	@Before
	public void testNoeudPileBefore()
	{
		n1 = new NoeudPile(10);
		n2 = new NoeudPile(20, null);
		n3 = new NoeudPile(true, n1);
		n4 = new NoeudPile("Hello!", n2);
	}

	@After
	public void testNoeudPileAfter()
	{
		n1 = null;
		n2 = null;
		n3 = null;
		n4 = null;
	}
	
	@Test
	public void testGetElement()
	{
		assertEquals(n1.getElement(), 10);
		assertEquals(n2.getElement(), 20);
		assertEquals(n3.getElement(), true);
		assertEquals(n4.getElement(), "Hello!");
	}

	@Test
	public void testSetElement()
	{
		n1.setElement("Im am the first");
		n2.setElement("Im sadly the second one");
		n3.setElement("I don't care");
		n4.setElement(true);
		assertEquals(n1.getElement(), "Im am the first");
		assertEquals(n2.getElement(), "Im sadly the second one");
		assertEquals(n3.getElement(), "I don't care");
		assertEquals(n4.getElement(), true);
	}

	@Test
	public void testGetPrecedent()
	{
		assertEquals(n1.getPrecedent(), null);
		assertEquals(n2.getPrecedent(), null);
		assertEquals(n3.getPrecedent(), n1);
		assertEquals(n4.getPrecedent(), n2);
	}

	@Test
	public void testSetPrecedent()
	{
		n1.setPrecedent(n4);
		n2.setPrecedent(n3);
		n3.setPrecedent(n2);
		n4.setPrecedent(null);
		assertEquals(n1.getPrecedent(), n4);
		assertEquals(n2.getPrecedent(), n3);
		assertEquals(n3.getPrecedent(), n2);
		assertEquals(n4.getPrecedent(), null);
	}

}
