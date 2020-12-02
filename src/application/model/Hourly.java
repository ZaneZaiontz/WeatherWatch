package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents the Hourly weather
 * Returns weather information for an hour
 * 	temp, humidity, windspeed, description, icon, date
 * 
 * @author Gabrielle Albrecht/ypo253 
 * @author Dariel Malave Perez
 * 
 * UTSA CS 3443 - Team Project
 *  Fall 2020 
 *
 */

public class Hourly {
	private String temp,  humidity, windSpeed, description, icon;
	Long date;

	//~~ Constructor
	/**
	 * 
	 * @param temp the hourly temperature (String)
	 * @param humidity the hourly humidity (String)
	 * @param windSpeed the hourly windSpeed (String)
	 * @param description the hourly weather description (String)
	 * @param icon the hourly weather icon (String)
	 * @param date the hourly date (Long)
	 */
	public Hourly(String temp, String humidity, String windSpeed, String description, String icon, Long date){
		this.temp = temp;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.description = description;
		this.icon = icon;
		this.date = date;
	} 
	
	//~~ Setters
	/**
	 * Set the Temp for hourly weather
	 * @param data sets the hourly temp (String)
	 */
	public void setTemp(String data){
		this.temp = data;
	}
	
	/**
	 * Set the WindSpeed for hourly weather
	 * @param data sets the hourly wind speed (String)
	 */
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	/**
	 * Set the Humidity for hourly weather
	 * @param data sets the hourly humidity (String)
	 */
	public void setHumidity(String data){
		this.humidity = data;
	}
	/**
	 * Set the Icon for hourly weather
	 * @param data sets the hourly icon (String)
	 */
	public void setIcon(String data){
		this.icon = data;
	}
	/**
	 * Set the Description for hourly weather
	 * @param data sets the hourly weather description (String)
	 */
	public void setDescription(String data){
		this.description = data;
	}
	/**
	 * Set the Date for hourly weather
	 * @param date sets the hourly date (Long)
	 */
	public void setDate(Long date){
		this.date = date;
	}
	
	//~~ Getters
	/**
	 * Get the Temp for hourly weather
	 * @return temp the hourly temperature
	 */
	public String getTemp(){
		return this.temp;
	}
	
	/**
	 * Get the WindSpeed for hourly weather
	 * @return windSpeed the hourly wind speed
	 */
	public String getWindSpeed(){
		return this.windSpeed;
	}
	
	/**
	 * Get the Humidity for hourly weather
	 * @return humidity for hourly weather
	 */
	public String getHumidity(){
		return this.humidity;
	}
	
	/**
	 * Get the Icon for hourly weather
	 * @return icon for hourly weather
	 */
	public String getIcon(){
		return this.icon;
	}
	
	/**
	 *  Get the Description for hourly weather
	 *  @return description of the hourly weather
	 */
	public String getDescription(){
		return this.description;
	}
	
	
	/**
	 * Get the date for hourly weather
	 * @return date of the hourly weather
	 */
	public Long getDate(){
		return this.date;
	}
	/**
	 * Get the Day for hourly weather
	 * @return newDate the hourly date
	 */
	public String getDay(){
		 Date date = new Date(this.date*1000L);
		 SimpleDateFormat jdf = new SimpleDateFormat("EEE MM dd hh:mm:ss z");
		 String newDate = jdf.format(date);

		 return newDate;
	}
	
	//~~ toString()
	/**
	 * toString() prints the hourly weather, returns a String
	 * @return data String to print the hourly weather
	 */
	public String toString(){
		return (getDay() + ": " + this.temp + "°F, " + this.humidity + "% humidity, " + this.windSpeed + " mph wind");
	}
}
