package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Gabrielle Albrecht/ypo253
 *
 */

public class Hourly {
	private String temp,  humidity, windSpeed, description, icon;
	Long date;

	//~~ Constructor
	/**
	 * 
	 * @param temp
	 * @param humidity
	 * @param windSpeed
	 * @param description
	 * @param icon
	 * @param date
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
	 * 
	 * @param data
	 */
	public void setTemp(String data){
		this.temp = data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setHumidity(String data){
		this.humidity = data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setIcon(String data){
		this.icon = data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setDescription(String data){
		this.description = data;
	}
	/**
	 * 
	 * @param date
	 */
	public void setDate(Long date){
		this.date = date;
	}
	
	//~~ Getters
	/**
	 * 
	 * @return
	 */
	public String getTemp(){
		return this.temp;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWindSpeed(){
		return this.windSpeed;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHumidity(){
		return this.humidity;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIcon(){
		return this.icon;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription(){
		return this.description;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Long getDate(){
		return this.date;
	}
	/**
	 * 
	 * @return
	 */
	public String getDay(){
		 Date date = new Date(this.date*1000L);
		 SimpleDateFormat jdf = new SimpleDateFormat("EEE MM dd hh:mm:ss z");
		 String newDate = jdf.format(date);

		 return newDate;
	}
	
	//~~ toString()
	/**
	 * 
	 */
	public String toString(){
		return (getDay() + ": " + this.temp + "°F, " + this.humidity + "% humidity, " + this.windSpeed + " mph wind");
	}
}
