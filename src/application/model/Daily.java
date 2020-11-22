package application.model;

import java.util.Date;

public class Daily {
	
	private String high, low,  humidity, windSpeed, description, icon;
	Date date;
	
	//~~ Constructor
	public Daily(String high, String low, String humidity, String windSpeed, String description, String icon, Date date){
		this.high = high;
		this.low = low;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.description = description;
		this.icon = icon;
		this.date = date;
	} 
	
	//~~ Setters
	public void setHigh(String data){
		this.high = data;
	}
	public void setLow(String data){
		this.low = data;
	}
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	public void setHumidity(String data){
		this.humidity = data;
	}
	public void setIcon(String data){
		this.icon = data;
	}
	public void setDescription(String data){
		this.description = data;
	}
	public void setDate(Date date){
		this.date = date;
	}
	
	//~~ Getters
	public String getHigh(){
		return this.high;
	}
	public String getLow(){
		return this.low;
	}
	public String getWindSpeed(){
		return this.windSpeed;
	}
	public String getHumidity(){
		return this.humidity;
	}
	public String getIcon(){
		return this.icon;
	}
	public String getDescription(){
		return this.description;
	}
	public Date getDate(){
		return this.date;
	}
	
	//~~ toString()
	public String toString(){
		return (this.high + "/" + this.low + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.date);
	}
}
