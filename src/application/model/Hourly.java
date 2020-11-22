package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hourly {
	private String temp,  humidity, windSpeed, description, icon;
	Long date;

//~~ Constructor
public Hourly(String temp, String humidity, String windSpeed, String description, String icon, Long date){
	this.temp = temp;
	this.humidity = humidity;
	this.windSpeed = windSpeed;
	this.description = description;
	this.icon = icon;
	this.date = date;
} 

//~~ Setters
public void setTemp(String data){
	this.temp = data;
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
	this.date = date;
}

//~~ Getters
public String getTemp(){
	return this.temp;
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
	return this.date;
}

public String getDay(){
	 Date date = new Date(this.date*1000L);
	 SimpleDateFormat jdf = new SimpleDateFormat("E dd");
	 String java_date = jdf.format(date);
	 return java_date;
}

//~~ toString()
public String toString(){
	return (this.temp + "Humidity: " + this.humidity + " " + this.windSpeed + " " + this.date);
}
}
