import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest
{

	Queue<String> queueA;
	
	@BeforeEach
	void setUp() throws Exception
	{
		queueA = new Queue<String>();
	}

	@Test
	void testEmpty()
	{
		assertEquals(true, queueA.isEmpty());
	}
	
	@Test
	void testThrowException()
	{
		assertThrows(QueueUnderFlowException.class, () -> {
			queueA.pop();
		});
	}
	
	@Test
	void testPushPop() 
	{
		queueA.push("Hello");
		queueA.push("Hi");
		queueA.push("Greetings");
		
		assertEquals("Hello", queueA.pop());
		assertEquals("Hi", queueA.pop());
		assertEquals("Greetings", queueA.pop());
		
		assertThrows(QueueUnderFlowException.class, () -> {
			queueA.pop();
		});
	}
	
	@Test
	void testPushPopEmpty() 
	{
		queueA.push("Hello");
		
		assertEquals(false, queueA.isEmpty());

		assertEquals("Hello", queueA.pop());
		
		assertEquals(true, queueA.isEmpty());
	}

}
