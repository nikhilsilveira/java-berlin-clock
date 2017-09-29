/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author Nikhil Silveira
 *
 */
public class BerlinDisplayBuilder implements DisplayBuilder {
	private TimeDisplay timeDisplay;

	@Override
	public void buildDisplay() {
		timeDisplay = new BerlinDisplay();
	}


	@Override
	public void buildSeconds(int seconds) {
		char[] secondsLine = new char[1];
		if (seconds % 2 == 0) {
			secondsLine[0] = 'Y';
		}
		else {
			secondsLine[0] = 'O';
		}
		
		System.out.println(secondsLine);
		timeDisplay.setSecondsDisplay(secondsLine);
	}

	@Override
	public void buildHours(int hours) {
		char[][] hoursLines = new char[2][4];
		for (char[] line : hoursLines) {
			for (int i=0; i<4; i++) {
				line[i] = 'O';
			}
		}

		int fiveHourLamps = hours / 5;
		int singleHourLamps = hours % 5;

		for (int i=0; i< fiveHourLamps; i++) {
			hoursLines[0][i]='R';
		}
		
		for (int i=0; i< singleHourLamps; i++) {
			hoursLines[1][i]='R';
		}

		for (char[] line : hoursLines) {
			for (int i=0; i<4; i++) {
				System.out.print(line[i]);
			}
			System.out.println();
		}
		
		timeDisplay.setHoursDisplay(hoursLines);
	}

	@Override
	public void buildMinutes(int minutes) {
		char[][] minutesLines = new char[2][];
		minutesLines[0] = new char[11];
		minutesLines[1] = new char[4];
		
		for (int i=0; i<11; i++)
			minutesLines[0][i] = 'O';

		for (int i=0; i<4; i++)
			minutesLines[1][i] = 'O';

		int fiveMinLamps = minutes / 5;
		int oneMinLamps = minutes % 5;

		for (int i=0; i< fiveMinLamps; i++) {
			minutesLines[0][i]= (i>0 && (i+1)%3==0) ? 'R' : 'Y';
		}
		
		for (int i=0; i< oneMinLamps; i++) {
			minutesLines[1][i]='Y';
		}

		for (int i=0; i<11; i++)
			System.out.print(minutesLines[0][i]);
		System.out.println();
		
		for (int i=0; i<4; i++)
			System.out.print(minutesLines[1][i]);
		
		timeDisplay.setMinutesDisplay(minutesLines);
	}

	@Override
	public TimeDisplay getDisplay() {
		return timeDisplay;
	}
	
	public static void main(String... args) {
		BerlinDisplayBuilder app = new BerlinDisplayBuilder();
		app.buildDisplay();
		app.buildSeconds(3);
		app.buildHours(1);
		app.buildMinutes(17);
	}

}
