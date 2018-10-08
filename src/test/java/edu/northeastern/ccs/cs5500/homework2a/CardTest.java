package edu.northeastern.ccs.cs5500.homework2a;

import junit.framework.TestCase;

public class CardTest extends TestCase {
	
	public void testCreateCard() {
		Card card = new Card(new Rank("Q", 0), new Suit("clubs", '1'));
		assertEquals(card.getRank().getName(), "Q");
		assertEquals(card.getRank().getPips(), 0);
		assertEquals(card.getSuit().getName(), "clubs");
		assertEquals(card.getSuit().getSymbol(), '1');
	}
	
	
	
}
