package model;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import cards.Card;

public class SuitStackManager
{
	private enum StackIndex{
		FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH,
	}
	
	private Map< StackIndex, Stack<Card>> aStacks = new HashMap<>();
	
	SuitStackManager()
	{
		initialize();
	}
	
	void initialize()
	{
		for( StackIndex index : StackIndex.values() )
		{
			aStacks.put(index, new Stack<Card>());
		}
	}

	
	boolean isEmpty(StackIndex pIndex)
	{
		return aStacks.get(pIndex).isEmpty();
	}

	boolean isCompleted()
	{
		for( Stack<Card> stack : aStacks.values())
		{
			if( stack.size() < Card.Rank.values().length )
			{
				return false;
			}
		}
		return true;
	}
	
	Card peek(StackIndex pIndex)
	{
		assert !aStacks.get(pIndex).isEmpty();
		return aStacks.get(pIndex).peek();
	}
	
	void push(Card pCard, StackIndex pIndex)
	{
		aStacks.get(pIndex).push(pCard);
	}

	Card pop(StackIndex pIndex)
	{
		assert !isEmpty(pIndex);
		return aStacks.get(pIndex).pop();
	}
}
