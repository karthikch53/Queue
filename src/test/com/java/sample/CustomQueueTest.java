package test.com.java.sample;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.sample.CustomQueue;
import com.java.sample.QueueEmptyException;
import com.java.sample.QueueFullException;

public class CustomQueueTest {
	
	@Test(expected = QueueFullException.class)
	public void testQueueFull() throws QueueFullException
	{
		CustomQueue queue = new CustomQueue();
		for(int i=0;i<=11;i++)
		{
			queue.push("Item " + i);
		}
	}
	
	@Test
	public void testQueueSize() throws QueueFullException, QueueEmptyException
	{
		CustomQueue queue = new CustomQueue();
		for(int i=1;i<=5;i++)
		{
			queue.push("Item " + i);
		}
		queue.pop();
		for(int i=6;i<=10;i++)
		{
			queue.push("Item " + i);
		}
		queue.pop();
		assertEquals("Items in queue", 8, queue.size());
	}
	
	@Test
	public void testQueuePop() throws QueueFullException, QueueEmptyException
	{
		CustomQueue queue = new CustomQueue();
		for(int i=1;i<=5;i++)
		{
			queue.push("Item" + i);
		}
		assertEquals("First Item in Queue", "Item1", queue.pop());
	}
	
	@Test(expected = QueueEmptyException.class)
	public void testPopWhileQueueEmpty() throws QueueEmptyException
	{
		CustomQueue queue = new CustomQueue();
		queue.pop();
	}

}
