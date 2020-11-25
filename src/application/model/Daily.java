package application.model;

import java.text.SimpleDateFormat; 
import java.util.Date;

/**
 * 
 * @author Gabrielle Albrecht/ypo253
 *
 */

public class Daily {
	
	private String high, low,  humidity, windSpeed, description, icon, pop;
	Long timestamp;
	
	//~~ Constructor
	/**
	 * 
	 * @param high
	 * @param low
	 * @param humidity
	 * @param windSpeed
	 * @param pop
	 * @param description
	 * @param icon
	 * @param timestamp
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
	 * 
	 * @param data
	 */
	public void setHigh(String data){
		this.high = data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setLow(String data){
		this.low = data;
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
	 * @param data
	 */
	public void setPop(String data){
		this.pop = data;
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setDate(Long date){
		this.timestamp = date;
	}
	
	//~~ Getters
	/**
	 * 
	 * @return
	 */
	public String getHigh(){
		return this.high;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHighInt(){
		Double result = Double.parseDouble(this.high);
		int degree = (int)Math.round(result);
		return degree;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLowInt(){
		Double result = Double.parseDouble(this.low);
		int degree = (int)Math.round(result);
		return degree;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLow(){
		return this.low;	
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
		return this.timestamp;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPop(){
		return this.pop;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getPopPercent(){
		Double result = Double.parseDouble(this.pop);
		double percent = (result*100);
		
		return percent;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDay(){
		 Date date = new Date(this.timestamp*1000L);
		 SimpleDateFormat jdf = new SimpleDateFormat("E dd");
		 String java_date = jdf.format(date);
		 return java_date;
	}
	
	//~~ toString()
	/**
	 * 
	 */
	public String toString(){
		return (this.high + "/" + this.low + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.timestamp);
	}
}
