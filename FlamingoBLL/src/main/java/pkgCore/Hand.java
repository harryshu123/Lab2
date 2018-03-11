package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;

public class Hand {

	private int iScore;
	private ArrayList<Card> hand;
	private int handValue;
	private int Count;
	
	
	public Hand()
	{
		this.hand = new ArrayList<Card>();
		handValue = 0;
		Count = 0;
	}
	public Hand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	
	public int[] ScoreHand()
	{
		//ArrayList<Integer> scores = new ArrayList<Integer>();
		int [] iScore = new int[2];
		int CountACE = 0;
		iScore[0] = 0;
		iScore[1] = 0;
		
		Collections.sort(hand);
		
		boolean bAce = false;
		for (Card c: hand)
		{	
			iScore[0] = iScore[0] + c.geteRank().getCardValueMin(); // min scores
			iScore[1] = iScore[1] + c.geteRank().getCardValueMax(); // max scores
			
			
			
			if(c.geteRank() == eRank.ACE) {
				bAce = true;
				CountACE ++;
				
			}
			if(bAce) {
				iScore[1] = iScore[0] + 10;
			}else {
				iScore[1] = iScore[0];
			}
		}
		while(iScore[1] > 21 && CountACE !=0) {
			iScore[1] -= 10;
			CountACE--;
		}
		
		return iScore;
	}
		
		
	
	
	public boolean bCanDealerHit() 
	{
		
		for (int scores: ScoreHand()) {
			if(scores >= 17 && scores <= 21) {
				return false;
			}
		}
		return true;
	}
	
	public boolean bCanPlayerHit() 
	{
		
		for (int scores: ScoreHand()) {
			if(scores < 21) {
				return true;
			}
		}
		return false;
	}
	
	/*public ArrayList<Card> BuildHand(Deck d) {
		hand.add(d.draw());
		hand.add(d.draw());
		return hand;	
	}*/
	
	public void Draw(Deck d) throws Exception
	{
		hand.add(d.draw());
	}
	
	private void AddCard(Card c)
	{
		hand.add(c);
	}
	
}
