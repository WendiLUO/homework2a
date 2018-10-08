package edu.northeastern.ccs.cs5500.homework2a;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TestCases extends TestCase {
	
	private Map<String, Integer> faceMap = new HashMap<String, Integer>();
	private Map<String, Integer> suitMap = new HashMap<String, Integer>();

	public TestCases() {
		faceMap.put("J", 11);
		faceMap.put("Q", 12);
		faceMap.put("K", 13);
		faceMap.put("A", 14);
		suitMap.put("clubs", 1);
		suitMap.put("diamonds", 2);
		suitMap.put("hearts", 3);
		suitMap.put("spades", 4);
	}
	
	// Test 1
	public void testCreateCard() {
		Card card = new Card(new Rank("Q", 0), new Suit("clubs", '1'));
		assertEquals(card.getRank().getName(), "Q");
		assertEquals(card.getRank().getPips(), 0);
		assertEquals(card.getSuit().getName(), "clubs");
		assertEquals(card.getSuit().getSymbol(), '1');
	}
	
	// Test 2
	public void testStandardDeck() {
		Deck standard = new Standard();
		assertEquals(52, standard.officialSize());
		for(Map.Entry<String, Integer> suitPair: suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(),
					(char)((int)(suitPair.getValue()) + '0'));
			for(int i = 2; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				assertTrue(standard.containsCard(new Card(rank, suit)));
			}
			for (Map.Entry<String, Integer> facePair: faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				assertTrue(standard.containsCard(new Card(rank, suit)));
			}
		}
	}
	
	public void testEuchreDeck() {
		Deck euchre = new Euchre();
		assertEquals(24, euchre.officialSize());
		for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
			for (int i = 9; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				assertTrue(euchre.containsCard(new Card(rank, suit)));
			}
			for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				assertTrue(euchre.containsCard(new Card(rank, suit)));
			}
		}
	}
	
	public void testPinochleDeck() {
		Deck pinochle = new Pinochle();
		assertEquals(48, pinochle.officialSize());
		for (int j = 0; j < 2; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 9; i <= 10; i++) {
					Rank rank = new Rank(String.valueOf(i), i);
					assertTrue(pinochle.containsCard(new Card(rank, suit)));
				}
				for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
					Rank rank = new Rank(facePair.getKey(), 0);
					assertTrue(pinochle.containsCard(new Card(rank, suit)));
				}
			}
		}
	}
	
	public void testVegasDeck() {
		Deck vegas = new Vegas();
		assertEquals(6*52, vegas.officialSize());
		for (int j = 0; j < 6; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 1; i <= 10; i++) {
					Rank rank = new Rank(String.valueOf(i), i);
					assertTrue(vegas.containsCard(new Card(rank, suit)));
				}
				for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
					Rank rank = new Rank(facePair.getKey(), 0);
					assertTrue(vegas.containsCard(new Card(rank, suit)));
				}
			}
		}
	}
	
	// Test 3
	public void testShuffle() {
		Deck standard1 = new Standard();
		Deck standard2 = new Standard();
		
		// Ensure that Deck1 and Deck2 are the same.
		assertTrue(standard1.equals(standard2));
		
		// Ensure Deck2 after shuffle is different from Deck1.
		standard2.shuffle();
		assertTrue(!standard1.equals(standard2));
	}
	
	// Test 4
	public void testSort() {
		Deck standard1 = new Standard();
		standard1.shuffle();
		standard1.sort("");
	}
	
}
