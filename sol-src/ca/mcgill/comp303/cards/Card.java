package ca.mcgill.comp303.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Class card.
 */
public class Card 
{

	public static void main(String[] args)
	{
		Card card = new Card(Rank.ACE, Suit.CLUBS);
		Card card2 = new Card(Rank.TWO, Suit.CLUBS);
		ArrayList<Card> list = new ArrayList<>();
		list.add(card);
		list.add(card2);
		List<Card> newList = Collections.unmodifiableList(list);
		list.remove(0);
		// Use the debugger to confirm that you have two different
		// lists that refer to the same objects.
	}
	
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public Card( Card pCard )
	{
		aRank = pCard.aRank;
		aSuit = pCard.aSuit;
	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
// I included this example so I could discussed
// the dangers of returning mutable objects that represent some
// state we are trying to encapsulate. Ultimately, the Card class
// should instantiate immutable objects.
//	/**
//	 * Assigns a new rank to the card.
//	 * @param pRank The new rank.
//	 * @pre pRank != null
//	 */
//	public void setRank(Rank pRank)
//	{
//		aRank = pRank;
//	}
	
	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
	 * @pre pSuit != null
	 */
	public void setSuit(Suit pSuit)
	{
		aSuit = pSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
}
