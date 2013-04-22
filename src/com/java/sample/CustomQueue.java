package com.java.sample;
import java.util.Stack;
public class CustomQueue 
{
	int initSize;
	int currentIndex;
	private int initStackCount = 0;
	private int tempStackCount = 0;
	Stack<String> initStack;
	Stack<String> tempStack;
	
	public CustomQueue()
	{
		this.initSize = 10;
		currentIndex = 0;
		initStack = new Stack<String>();
		tempStack = new Stack<String>();
	}
	public int size()
	{
		return initStackCount + tempStackCount;
	}
	
	public void push(String item) throws QueueFullException
	{
		if(currentIndex<initSize)
		{
			initStack.push(item);
			currentIndex++;
			initStackCount ++;
		}
		else
		{
			throw new QueueFullException("Queue is full. Cannot add new elements");
		}
	}
	public String pop() throws QueueEmptyException
	{
		if(initStack.isEmpty())
		{
			throw new QueueEmptyException("No elements in Queue");
		}
		if(tempStack.isEmpty())
		{
			while(!initStack.isEmpty())
			{
				tempStack.push(initStack.pop());
				initStackCount --;
				tempStackCount ++;
			}
		}
		tempStackCount --;
		return tempStack.pop();
	}
}


