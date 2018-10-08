package edu.northeastern.ccs.cs5500.homework2a;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	
	private Map<String, Integer> faceMap = new HashMap<String, Integer>();
	private Map<String, Integer> suitMap = new HashMap<String, Integer>();

	public DeckTest() {
		faceMap.put("J", 11);
		faceMap.put("Q", 12);
		faceMap.put("K", 13);
		faceMap.put("A", 14);
		suitMap.put("clubs", 1);
		suitMap.put("diamonds", 2);
		suitMap.put("hearts", 3);
		suitMap.put("spades", 4);
	}
	
	public void testStandardDecksTypeAndNum() {
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
	
	public void testEuchreDecksTypeAndNum() {
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
}
