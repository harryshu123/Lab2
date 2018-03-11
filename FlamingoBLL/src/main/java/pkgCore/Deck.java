package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private int numberOfDecks;
	private ArrayList<Card> Cards = new ArrayList<Card>();

	
	public Deck() {
		BuildDeck();
	}
	
	public Deck(int numberOfDecks) {
		
		for(int i = 0; i < numberOfDecks; i++) {
			BuildDeck();
		}
		
	}
	
	private void BuildDeck() {
		for(eRank eRank: eRank.values()) {
			
			for(eSuit eSuit: eSuit.values()) {
				
				Cards.add(new Card(eRank, eSuit));
				
			}
			
		}
		
		Collections.shuffle(Cards);
		/*Collections.sort(Cards);
		
		for(Card c: Cards) {
			
			System.out.print(c.geteRank() + " ");
			System.out.println(c.geteSuit());
			
		}*/
		
	}
	
	
	public Card draw() throws Exception {
		
		if(Cards.size() == 0) {
			
			throw new Exception("Decis is empty");
		}
		
		return Cards.remove(0);	
	}	
	
	public int deckSize() {
		return this.Cards.size();
	}
	
	/*public static Deck sortDeck(Deck d) {
		Collections.sort(d.Cards);
		return d;
	}*/
	
}
