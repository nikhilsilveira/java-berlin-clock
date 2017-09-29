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
public class BerlinDisplayBuilderTest {
	
	BerlinDisplayBuilder berlinDisplayBuilder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		berlinDisplayBuilder = new BerlinDisplayBuilder();
		berlinDisplayBuilder.buildDisplay();
	}

	@Test
	public void testBuildDisplay() {
		berlinDisplayBuilder.buildSeconds(3);
		berlinDisplayBuilder.buildHours(1);
		berlinDisplayBuilder.buildMinutes(17);
		TimeDisplay berlinDisplay = berlinDisplayBuilder.getDisplay();
		
		char[][] expectedOutput = new char[BerlinDisplay.DISPLAY_LINES][4];
		expectedOutput[0] = new char[1];
		expectedOutput[0][0] = 'O';
		
		expectedOutput[1] = new char[4];
		expectedOutput[2] = new char[4];
		expectedOutput[3] = new char[11];
		expectedOutput[4] = new char[4];
		
		for (int i=0; i<4; i++) {
			expectedOutput[1][i] = 'O';
			expectedOutput[2][i] = 'O';
			expectedOutput[3][i] = 'O';
			expectedOutput[4][i] = 'O';
		}
		for (int i=4; i<11; i++) {
			expectedOutput[3][i] = 'O';
		}
		expectedOutput[2][0] = 'R';
		expectedOutput[3][0] = 'Y';
		expectedOutput[3][1] = 'Y';
		expectedOutput[3][2] = 'R';
		expectedOutput[4][0] = 'Y';
		expectedOutput[4][1] = 'Y';
		StringBuilder sb = new StringBuilder(); 
		for (int i=0; i < BerlinDisplay.DISPLAY_LINES; i++ ) {
			sb.append(expectedOutput[i]);
			if (i<BerlinDisplay.DISPLAY_LINES-1) {
				sb.append("\n");
			}
		}
		
		assertEquals(berlinDisplay.toString(), 
				sb.toString()
				);
	}

}
