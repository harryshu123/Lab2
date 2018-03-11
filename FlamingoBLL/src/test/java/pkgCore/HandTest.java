package pkgCore;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandTest {

	public int[] HandHelper(ArrayList<Card> cards) {

		int[] result = null;

		try {
			
			//	c = structure of class 'Hand'
			Class<?> c = Class.forName("pkgCore.Hand");

			//	the arguements for 'AddCard' is a instance of Card
			Class[] cArgsAddCard = new Class[1];
			cArgsAddCard[0] = pkgCore.Card.class;

			//	Create an instance of Hand
			Object inst = c.newInstance();

			//	Find the method 'AddCard' in Hand
			Method mAddCard = c.getDeclaredMethod("AddCard", cArgsAddCard);
			
			//	Make the private method accessible 
			mAddCard.setAccessible(true);
			
			//	Invoke the AddCard method for each card passed into this method
			for (Card card: cards)
			{
				mAddCard.invoke(inst, card);
			}
			
			//	Find the method 'ScoreHand' in 'Hand'
			Method mScore = c.getDeclaredMethod("ScoreHand", null);
			
			//	Invoke 'ScoreHand'.  It returns an array of integers
			result = (int[]) mScore.invoke(inst, null);

			//	easy way to see each score.  not necessary.. but helps
			for (int i : result) {
				System.out.println(i);
			}

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void test1() {
		
		
		
	
		ArrayList<Card> cards = new ArrayList<Card>();
		
		
		cards.add(new Card(eRank.TWO,eSuit.CLUBS));
		cards.add(new Card(eRank.THREE,eSuit.CLUBS));
		cards.add(new Card(eRank.FOUR,eSuit.CLUBS));
		
		
		int[] score = HandHelper(cards);
		
		System.out.println("example1 score is: " + score[0]);
		
		assertEquals(score[0],9);		
	}

	@Test
	public void test2() {
	
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.TWO,eSuit.CLUBS));
		cards.add(new Card(eRank.THREE,eSuit.CLUBS));
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[0],15);
		System.out.println("example2 score is: " + score[0]);
		
		
	}

	@Test
	public void test3() {

		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.TWO,eSuit.CLUBS));
		cards.add(new Card(eRank.THREE,eSuit.CLUBS));
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[0],25);
		System.out.println("example3 score is: " + score[0]);
	}

	@Test
	public void test4() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[1],21);
		System.out.println("example4 score is: " + score[1]);
		
	}

	@Test
	public void test5() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[0],12);
		System.out.println("example5 score is: " + score[0]);
	}

	@Test
	public void test6() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.JACK,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[0],13);
		System.out.println("example6 score is: " + score[0]);
	}
	
	@Test
	public void test7() {
	
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.ACE,eSuit.CLUBS));
		cards.add(new Card(eRank.TWO,eSuit.CLUBS));
		int[] score = HandHelper(cards);
		assertEquals(score[0],6);
		assertEquals(score[1],16);
		System.out.println("example7 score is: " + score[0]);
		System.out.println("or example7 score is: " + score[1]);
		
	}

}
