package ca.mcgill.comp303.cards;

import ca.mcgill.comp303.cards.Card.Rank;
import ca.mcgill.comp303.cards.Card.Suit;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * 
 * A model of a Deck of 52 Cards.
 *
 */
public class Deck
{
private final Stack<Card> aCards = new Stack<>();
	

/**
 * Creates a new deck of 52 cards, shuffled.
 */
	public Deck()
	{
	}
	
	/**
	 * 
	 * @return An unmodifiable list of the Deck's cards.
	 */
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}
	
/**
 * 	
 * @param pDeck a
 */
	public Deck( Deck pDeck )
	{
		for( Card card : pDeck.aCards )
		{
			aCards.add(new Card(card));
		}
	}
	
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	public Card draw()
	{
		return aCards.pop();
	}

}
