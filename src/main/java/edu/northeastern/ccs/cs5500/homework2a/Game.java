package edu.northeastern.ccs.cs5500.homework2a;

import java.util.*;

public class Game {
	private static int DEFAULT_DECK_NUM = 1;
	private List<Deck> decks = new ArrayList<Deck>();
	private List<Hand> hands = new ArrayList<Hand>();

	public void createDeck(String deckType) {
		createDeck(deckType, DEFAULT_DECK_NUM);
	}

	public void createDeck(String deckType, int numberOfDecks) {
		for (int i = 0; i < numberOfDecks; ++i) {
			if (deckType == "Standard") {
				decks.add(new Standard());
			} else if (deckType == "Pinochle") {
				decks.add(new Pinochle());
			} else if (deckType == "Euchre") {
				decks.add(new Euchre());
			} else if (deckType == "Vegas") {
				decks.add(new Vegas());
			}
		}
	}

	public void setNumberOfHands(int howManyHands) {
		for (int i = 0; i < howManyHands; ++i) {
			hands.add(new Hand());
		}
	}

	public void deal() {

	}
}
