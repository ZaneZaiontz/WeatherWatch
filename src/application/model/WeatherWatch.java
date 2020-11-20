package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import com.google.gson.*;
import com.google.gson.reflect.*;

// Isn't my best work, just trying to get something workable for the demo.
// Some problems - Current - Can't get map "weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}] 
//				 - Not sure how to do radar. 
//				 - Can't use OneCall to get info. 
// Had to do current to get lon and lat, 
// Use OneCall for Current, Daily, Hourly, and WeatherHistory. 
//~Gabrielle


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
	public void analyzeCurrent() throws IOException{

			StringBuilder result = new StringBuilder();
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
			URLConnection conn = url.openConnection();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			//System.out.println(result);
			
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			Map<String, Object> coord = jsonToMap(respMap.get("coord").toString());
			//Map<String, Object> wMap = jsonToMap(respMap.get("weather").toString());
			
			//System.out.println("Lat: " + coord.get("lat"));
			//System.out.println("Long: " + coord.get("lon"));
			//System.out.println("Current h: " + mainMap.get("humidity"));  
			//System.out.println("Current feels like Temperatures: " + mainMap.get("feels_like"));
			//System.out.println("Current Humidity: " + mainMap.get("humidity"));
			//System.out.println("Wind speeds: " + windMap.get("speed"));
			//System.out.println("Wind angle: " + windMap.get("deg"));
			
			setTemp(mainMap.get("temp").toString());
			setFeelsLike(mainMap.get("feels_like").toString());
			setHumidity(mainMap.get("humidity").toString());
			setWindSpeed(windMap.get("speed").toString());
			setLatitude(coord.get("lat").toString());
			setLongitude(coord.get("lon").toString()); 
	}

	//~~ OneCall
	public void analyzeOneCall() throws IOException{
		//https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}&units={units}
		StringBuilder result = new StringBuilder();
		URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?" + "lat=" + getLatitude() + "&lon=" + getLongitude() + "&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
		URLConnection conn = url.openConnection();

		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		//System.out.println(result);
		
		Map<String, Object> respMap = jsonToMap(result.toString());
		//System.out.println(respMap);
		//Map<String, Object> mainMap = jsonToMap(respMap.get("current").toString());
		
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
	/*public void setWeather(String data){
		
	}
	public void setPrecipitation(String data){
		
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