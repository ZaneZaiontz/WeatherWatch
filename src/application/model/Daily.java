package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Daily {
	
	private String high, low,  humidity, windSpeed, description, icon;
	Long timestamp;
	//Date date;
	
	//~~ Constructor
	public Daily(String high, String low, String humidity, String windSpeed, String description, String icon,Long timestamp){
		this.high = high;
		this.low = low;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.description = description;
		this.icon = icon;
		this.timestamp = timestamp;
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
	public void setDate(Long date){
		this.timestamp = date;
	}
	
	//~~ Getters
	public String getHigh(){
		return this.high;
	}
	public int getHighInt(){
		Double result = Double.parseDouble(this.high);
		int degree = (int)Math.round(result);
		return degree;
	}
	public int getLowInt(){
		Double result = Double.parseDouble(this.low);
		int degree = (int)Math.round(result);
		return degree;
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
	public Long getDate(){
		return this.timestamp;
	}
	
	public String getDay(){
		 Date date = new Date(this.timestamp*1000L);
		 SimpleDateFormat jdf = new SimpleDateFormat("E dd");
		 String java_date = jdf.format(date);
		 return java_date;
	}
	
	//~~ toString()
	public String toString(){
		return (this.high + "/" + this.low + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.timestamp);
	}
}
