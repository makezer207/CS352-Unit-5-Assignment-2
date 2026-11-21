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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	/* Add appropriate instance attributes, constructors, and accessor/mutator methods */
}
