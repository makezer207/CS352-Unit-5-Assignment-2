/**
 * Mitchell Kezer
 CS352 Unit 5 Assignment 2
 11/22/2026
 *
 * Stores low and high temperature data for a city/state 
 */
public class Temperature {
	private String city;
	private String state;
	private int low;
	private int high;

	public Temperature(String city, String state, int low, int high) {
		this.city = city;
		this.state = state;
		this.low = low;
		this.high = high;
	}

	public int Differential() {
		return Math.abs(high - low);
	}


	
	/* Add appropriate instance attributes, constructors, and accessor/mutator methods */
}
