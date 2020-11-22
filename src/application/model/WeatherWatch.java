package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

import com.google.gson.*;
import com.google.gson.reflect.*;


public class WeatherWatch {
	//public static String cityName;
	private String cityName;
	private String fileName = "data/city.csv";
	private String Temp, feelsLike, humidity, windSpeed, latitude, longitude;
	
	
	public WeatherWatch() {
	}
	
	public WeatherWatch(String cityName) {
		
		this.cityName = cityName;
	}
	
	public void setCityName(String cityName){
		this.cityName = cityName;
		
	}
	
	public String getCityName(){
		return this.cityName;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
		
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public void loadFile() throws IOException {
		File fileName = new File(this.fileName);
		
		Scanner scan = new Scanner( fileName );
		if(scan.hasNext()){
			String line = scan.nextLine();
			setCityName(line);
		}
		else { setCityName("San Antonio"); }
		scan.close();
	}
	
	public void save() throws IOException{
		FileWriter write = new FileWriter (this.fileName);
		PrintWriter writeToFile = new PrintWriter(write);
		
		writeToFile.println(getCityName());
		
		writeToFile.close();
	}
	
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	} 
	
	//~~ Current
	public void analyzeCurrent() throws Exception{

		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
		
		Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	   
		Map<String, Object> respMap = jsonToMap(str);
		Map<String, Object> coordMap = jsonToMap(respMap.get("coord").toString());
		
		setLatitude(coordMap.get("lat").toString());
		setLongitude(coordMap.get("lon").toString()); 
	}		
			

	//~~ OneCall
	public void analyzeOneCall() throws Exception{
		//https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}&units={units}
		
		URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + getLatitude() + "&lon=" + getLongitude() + "&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
		
		Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
		
	    Object obj = new JSONParser().parse(str);
		JSONObject jo = (JSONObject) obj; 
	    
	    // ~~ Current
		Map<String, Object> currentMap = jsonToMap(jo.get("current").toString());
		
		setTemp(currentMap.get("temp").toString());
		setFeelsLike(currentMap.get("feels_like").toString());
		setHumidity(currentMap.get("humidity").toString());
		setWindSpeed(currentMap.get("wind_speed").toString());
		
		System.out.println(currentMap);
	
		System.out.println(currentMap.get("weather"));

	
		//setWeatherDescription();
		//setWeatherMain()
		//setWeatherIcon(icon)
		
		//~~ Daily;
		//Map<String, Object> dailyMap = jsonToMap(jo.get("daily").toString());
		//System.out.println(dailyMap);
	
		//~~ Hourly
		
	}
	
	//Set Latitude and longitude
	public void setLatitude(String data){
		this.latitude = data;
	}
	public void setLongitude(String data){
		this.longitude = data;
	}
	
	public String getLatitude(){
		return this.latitude;
	}
	public String getLongitude(){
		return this.longitude;
	}
	
	//~~ Current
	public void setTemp(String data){
		this.Temp = data;
	}
	public void setFeelsLike(String data){
		this.feelsLike = data;
	}
	public void setHumidity(String data){
		this.humidity = data;
	}
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	
	//public void setWeatherIcon(String data){
		
	
	//}
	
	/*public void setPrecipitation(String data){
		
	}*/
	
	public String getTemp(){
		return this.Temp;
	}
	public String getFeelsLike(){
		return this.feelsLike;
	}
	public String getHumidity(){
		return this.humidity;
	}
	public String getWindSpeed(){
		return this.windSpeed;
	}
	/*public void setWeather(String data){
		
	}
	public void setPrecipitation(String data){
		
	}*/
	
	//~~ Hourly
	
	
	//~~ Daily 
	
	
	
	//~~ Radar
	
}