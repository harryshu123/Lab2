package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Deck;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		//	TODO: Build a deck(1), make sure there are 52 cards in the deck
		Deck d = new Deck(1);
		System.out.println(d.deckSize());
		if (d.deckSize() < 52){
			System.out.println("too small");
			fail("Too few cards in deck");
		}else if(d.deckSize() > 52) {
			System.out.println("too big");
			fail("Too many cards in deck");
		}
		//	TODO: Build a deck(6), make sure there are 312 cards in the deck 
		Deck dsix = new Deck(6);
		System.out.println(dsix.deckSize());
		if (dsix.deckSize() < 6*52){
			System.out.println("multiple decks too small");
			fail("Too few cards in deck");
		}else if(dsix.deckSize() > 6*52) {
			System.out.println("multiple decks too big");
			fail("Too many cards in deck");
		}
	}
}
