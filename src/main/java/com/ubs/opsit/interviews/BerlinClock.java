/**
 * 
 */
package com.ubs.opsit.interviews;


/**
 * @author Nikhil Silveira
 *
 */
public class BerlinClock implements TimeConverter {
	private int hours;
	private int minutes;
	private int seconds;
	private DisplayBuilder displayBuilder;

	
	BerlinClock() {
		displayBuilder = new BerlinDisplayBuilder();
	}
	
	//////////////////
	// PUBLIC METHODS

	@Override
	public String convertTime(String aTime) {
		setTime(aTime);
		displayBuilder.buildDisplay();
		displayBuilder.buildSeconds(seconds);
		displayBuilder.buildHours(hours);
		displayBuilder.buildMinutes(minutes);
		TimeDisplay berlinDisplay = displayBuilder.getDisplay();
		return berlinDisplay.toString();
	}
	
	
	///////////////////
	// DEFAULT METHODS
	
	
	void setTime(String time) {
		 if (!time.matches("\\d{2}:\\d{2}:\\d{2}")) {
			 throw new IllegalArgumentException("Time expected as 00:00:00, not " + time);
		 }
		 String[] timeParts = time.split(":");
		 hours = Integer.parseInt(timeParts[0]);
		 minutes = Integer.parseInt(timeParts[1]);
		 seconds = Integer.parseInt(timeParts[2]);
	}

	int getHours() {
		return hours;
	}

	int getMinutes() {
		return minutes;
	}

	int getSeconds() {
		return seconds;
	}

	

}
