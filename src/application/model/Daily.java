package application.model;

import java.text.SimpleDateFormat; 
import java.util.Date;

/**
 * This class represents the Daily weather
 * 	It has:
 * 		the high and low temperature for a day
 * 		humidity, windspeed, pop (probability of precipitation)  
 * 		the description of the weather
 * 		the weather icon
 * 		the timestamp - the date the weather info is for
 * 
 * @author Gabrielle Albrecht/ypo253
 * @author Dariel Malave Perez
 * 
 * UTSA CS 3443 - Team Project
 * Fall 2020
 */

public class Daily {
	
	private String high, low,  humidity, windSpeed, description, icon, pop;
	Long timestamp;
	
	//~~ Constructor
	/**
	 * 
	 * @param high sets the daily high temp (String)
	 * @param low sets the daily low temp (String)
	 * @param humidity sets the daily humidity (String)
	 * @param windSpeed sets the daily windspeed (String)
	 * @param pop sets the daily pop (String)
	 * @param description sets the daily description (String)
	 * @param icon sets the daily icon (String)
	 * @param timestamp sets the daily timestamp (Long)
	 */
	public Daily(String high, String low, String humidity, String windSpeed,String pop, String description, String icon,Long timestamp){
		this.high = high;
		this.low = low;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.pop = pop;
		this.description = description;
		this.icon = icon;
		this.timestamp = timestamp;
	} 
	
	//~~ Setters
	/**
	 * Set the daily high temperature
	 * @param data the daily high temperature (String)
	 */
	public void setHigh(String data){
		this.high = data;
	}
	/**
	 * Set the daily low temperature
	 * @param data the daily low temperature (String)
	 */
	public void setLow(String data){
		this.low = data;
	}
	/**
	 * Set the WindSpeed for daily weather
	 * @param data set the daily windSpeed (String)
	 */
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	
	/**
	 * Set the Humidity for daily weather
	 * @param data set the daily humidity (String)
	 */
	public void setHumidity(String data){
		this.humidity = data;
	}
	
	/**
	 * Set the Icon for daily weather
	 * @param data set the Icon with the daily weather icon (String)
	 */
	public void setIcon(String data){
		this.icon = data;
	}
	
	/**
	 * Set the Description for daily weather
	 * @param data set the description with the daily weather description (String)
	 */
	public void setDescription(String data){
		this.description = data;
	}
	
	/**
	 * Set the Probability for Precipitation- Pop for daily weather
	 * @param data set the pop with the daily weather pop (String)
	 */
	public void setPop(String data){
		this.pop = data;
	}
	
	/**
	 * Set the Date for daily weather
	 * @param date set the date with the daily weather date (Long)
	 */
	public void setDate(Long date){
		this.timestamp = date;
	}
	
	//~~ Getters
	/**
	 * Get the High for daily weather
	 * @return high the daily high temperature (String)
	 */
	public String getHigh(){
		return this.high;
	}
	
	/**
	 * Get the HighInt for daily weather
	 * @return degree the high temperature rounded to nearest degree (int)
	 */
	public int getHighInt(){
		Double result = Double.parseDouble(this.high);
		int degree = (int)Math.round(result);
		return degree;
	}
	
	/**
	 * Get the LowInt for daily weather
	 * @return degree the low temperature rounded to nearest degree (int)
	 */
	public int getLowInt(){
		Double result = Double.parseDouble(this.low);
		int degree = (int)Math.round(result);
		return degree;
	}
	
	/**
	 * Get the Low for daily weather
	 * @return low the daily low temperature (String)
	 */
	public String getLow(){
		return this.low;	
	}
	
	/**
	 * Get the WindSpeed for daily weather
	 * @return windSpeed of daily weather
	 */
	public String getWindSpeed(){
		return this.windSpeed;
	}
	
	/**
	 * Get the Humidity for daily weather
	 * @return humidity of daily weather
	 */
	public String getHumidity(){
		return this.humidity;
	}
	
	/**
	 * Get the Icon for daily weather
	 * @return icon of the daily weather
	 */
	public String getIcon(){
		return this.icon;
	}
	
	/**
	 * Get the Description for daily weather
	 * @return description of the daily weather
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * Get the Date for daily weather
	 * @return timestamp the date of the daily weather
	 */
	public Long getDate(){
		return this.timestamp;
	}
	
	/**
	 * Get the Pop, Probability of Precipitation, for daily weather
	 * @return pop the probability of precipitation (String)
	 */
	public String getPop(){
		return this.pop;
	}
	
	/**
	 * Get the percent of pop for daily weather
	 * @return percent of pop (double)
	 */
	public double getPopPercent(){
		Double result = Double.parseDouble(this.pop);
		double percent = (result*100);
		
		return percent;
	}
	
	/**
	 * Get the day for the daily weather
	 * @return java_date the day for the weather information (String)
	 */
	public String getDay(){
		 Date date = new Date(this.timestamp*1000L);
		 SimpleDateFormat jdf = new SimpleDateFormat("E dd");
		 String java_date = jdf.format(date);
		 return java_date;
	}
	
	//~~ toString()
	/**
	 * toString() prints the daily weather, returns a String
	 * @return data String to print the daily weather information
	 */
	public String toString(){
		return (this.high + "/" + this.low + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.timestamp);
	}
}
