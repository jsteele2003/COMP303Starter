package cards;

import cards.Card.Rank;
import cards.Card.Suit;

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
	private Stack<Card> aCards = new Stack<>();
	

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
		aCards = new Stack<Card>();
		reset();
		shuffle();
	}
	
	
	
	private void reset()
	{
		aCards.clear();
		for( Suit lSuit : Suit.values() )
		{
            for( Rank lRank : Rank.values() )
            {
                aCards.add( Card.get( lRank, lSuit ));
            }
		}
	}
	
	
	public void shuffle()
	{
		reset();
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
