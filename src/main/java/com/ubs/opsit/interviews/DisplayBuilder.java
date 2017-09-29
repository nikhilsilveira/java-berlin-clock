/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author Nikhil Silveira
 *
 */
public interface DisplayBuilder {
	/** create concrete product */
	void buildDisplay();
	
	void buildSeconds(int seconds);
	void buildHours(int hours);
	void buildMinutes(int minutes);
	
	TimeDisplay getDisplay();

}
