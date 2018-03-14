package pkgCore;


import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Deck;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class RemainingTest {
	@Test
	public void RemainingTest() throws Exception {
		Deck a = new Deck(1);
		int sum = a.getRemaining(eRank.ACE);
		System.out.println("the sum of eRank.ACE are: " + sum);
		assertEquals(sum,4);
		int sum1 = a.getRemaining(eSuit.CLUBS);
		System.out.println("the sum of eRank.CLUBS are: "+ sum1);
		assertEquals(sum1,13);
	}

}
