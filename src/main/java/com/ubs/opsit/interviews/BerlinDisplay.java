/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author Nikhil Silveira
 *
 */
public class BerlinDisplay implements TimeDisplay {
	public static final int DISPLAY_LINES = 5;
	public static final int MAX_LINE_LEN = 11;
	public static final int[] LINE_LAMP_COUNT = new int[] {1,4,4,11,4};
	private char[][] displayMatrix;
	
	BerlinDisplay() {
		displayMatrix = new char[DISPLAY_LINES][MAX_LINE_LEN];
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		for (int i=0; i < DISPLAY_LINES; i++ ) {
			sb.append(displayMatrix[i]);
			if (i< (DISPLAY_LINES-1)) {
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}


	@Override
	public void setSecondsDisplay(char[] secondsLine) {
		displayMatrix[0] = secondsLine;
	}


	@Override
	public void setHoursDisplay(char[][] hoursLines) {
		displayMatrix[1] = hoursLines[0];
		displayMatrix[2] = hoursLines[1];
	}


	@Override
	public void setMinutesDisplay(char[][] minutesLines) {
		displayMatrix[3] = minutesLines[0];
		displayMatrix[4] = minutesLines[1];
	}
}
