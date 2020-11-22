package application.model;

import java.util.Date;

public class Daily {
	
	private String high, low,  humidity, windSpeed, description;
	Date date;
	
	public Daily(String high, String low, String humidity, String windSpeed, Date date){//String description, String date){
		this.high = high;
		this.low = low;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		//this.description = description;
		this.date = date;
	}
	
	public String toString(){
		String stringRep = (this.high + "/" + this.low + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.date);
		return stringRep;
	}
}
