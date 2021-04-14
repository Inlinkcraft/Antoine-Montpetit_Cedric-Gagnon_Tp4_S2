package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.PileException;
import structures.pile.Pile;

public class PileTest
{

	Pile p1, p2, p3, p4;
	
	@Before
	public void testPileBefore()
	{
		p1 = new Pile();
		p2 = new Pile();
		p3 = new Pile();
		p4 = new Pile();
	}
	
	@After
	public void testPileAfter()
	{
		p1 = new Pile();
		p2 = new Pile();
		p3 = new Pile();
		p4 = new Pile();
	}

	@Test
	public void testIsEmpty()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		assertEquals(p1.isEmpty(), false);
		assertEquals(p2.isEmpty(), false);
		assertEquals(p3.isEmpty(), true);
		assertEquals(p4.isEmpty(), true);
	}

	@Test
	public void testVider()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		p1.vider();
		p2.vider();
		p3.vider();
		p4.vider();
		assertEquals(p1.isEmpty(), true);
		assertEquals(p2.isEmpty(), true);
		assertEquals(p3.isEmpty(), true);
		assertEquals(p4.isEmpty(), true);
		
	}

	@Test
	public void testEmpiler()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		p4.empiler(true);
		assertEquals(p1.getPremier(), 7);
		assertEquals(p2.getPremier(), 6);
		assertEquals(p3.getPremier(), "Hello");
		assertEquals(p4.getPremier(), true);
	}

	@Test
	public void testGetPremier()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		assertEquals(p1.getPremier(), 7);
		assertEquals(p2.getPremier(), 6);
		assertEquals(p3.getPremier(), "Hello");
		try {
			p4.getPremier();
			fail("On peut pas get le premier de rien");
		}catch(PileException e) {
			
		}
	}

	@Test
	public void testDepiler()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		assertEquals(p1.depiler(),7);
		assertEquals(p2.depiler(),6);
		assertEquals(p3.depiler(),"Hello");
		try {
			p4.depiler();
			fail("Une pile vide ne peut pas être dépiler");
		}catch(PileException e) {
			
		}
		
	}

	@Test
	public void testSize()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		assertEquals(p1.size(),2);
		assertEquals(p2.size(),1);
		assertEquals(p3.size(),1);
		assertEquals(p4.size(),0);
	}

	@Test
	public void testToString()
	{
		p1.empiler(5);
		p2.empiler(6);
		p1.empiler(7);
		p3.empiler("Hello");
		assertEquals(p1.toString(),"75");
		assertEquals(p2.toString(),"6");
		assertEquals(p3.toString(),"Hello");
		assertEquals(p4.toString(),"");
		
	}

}
