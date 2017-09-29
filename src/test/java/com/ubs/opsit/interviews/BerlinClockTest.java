/**
 * 
 */
package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikhil Silveira
 *
 */
public class BerlinClockTest {
	private BerlinClock berlinClock ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		berlinClock = new BerlinClock();
	}

	@Test
	public void testSetTime() {
		berlinClock.setTime("23:59:59");
		assertTrue(berlinClock.getHours()==23 &&
				berlinClock.getMinutes()==59 &&
				berlinClock.getSeconds()==59
			);
	}
}
