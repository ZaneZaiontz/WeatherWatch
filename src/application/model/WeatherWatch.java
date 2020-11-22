package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import java.time.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
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
	private String Temp, feelsLike, humidity, windSpeed, latitude, longitude, icon;
	ArrayList<Daily> dailyObjects = new ArrayList<>();
	ArrayList<Hourly> hourlyObjects = new ArrayList<>();
	ArrayList<WeatherHistory> weatherHistoryObjects = new ArrayList<>();
	
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
	    while (scan.hasNext()){
	        str += scan.nextLine();
	    }
	    scan.close();
		
	    Object obj = new JSONParser().parse(str);
		JSONObject jo = (JSONObject) obj; 
	    
	    // ~~ Current
		Map<String, Object> currentMap = jsonToMap(jo.get("current").toString());
		
		setTemp(currentMap.get("temp").toString());
		setFeelsLike(currentMap.get("feels_like").toString());
		setHumidity(currentMap.get("humidity").toString());
		setWindSpeed(currentMap.get("wind_speed").toString());


		Object obj2 = new JSONParser().parse(jo.get("current").toString());
		JSONObject jo2 = (JSONObject) obj2; 
		JSONArray jArr = (JSONArray) jo2.get("weather");
		
	    Object weather = new JSONParser().parse(jArr.get(0).toString());
		JSONObject weatherObj = (JSONObject) weather;
	    setCurrentWeatherIcon(weatherObj.get("icon").toString());
	 
		 

		//~~ Daily;
		 JSONArray dArr = (JSONArray) jo.get("daily");
		 Iterator<?> iteratorDaily = dArr.iterator();

		 while(iteratorDaily.hasNext()) {
			  
		    Object daily = new JSONParser().parse(iteratorDaily.next().toString());
			JSONObject dailyObj = (JSONObject) daily; 
			
			Map<String, Object> tempMap = jsonToMap(dailyObj.get("temp").toString());
			//Map<String, Object> feelsLikeMap = jsonToMap(dailyObj.get("feels_like").toString());
			 
			
			String timeStamp = dailyObj.get("dt").toString();
			Date date = new Date(Long.parseLong(timeStamp)*1000);
			  
			//SetWeather
			JSONArray dOArr = (JSONArray) dailyObj.get("weather");
			Object weather2 = new JSONParser().parse(dOArr.get(0).toString());
			JSONObject weatherObj2 = (JSONObject) weather2;
					
			Daily object = new Daily(tempMap.get("min").toString(), tempMap.get("max").toString(), 
					dailyObj.get("humidity").toString(),  dailyObj.get("wind_speed").toString(), 
					weatherObj2.get("description").toString(), weatherObj2.get("icon").toString(), date);

			dailyObjects.add(object);
		 }

		//~~ Hourly
		 JSONArray hArr = (JSONArray) jo.get("hourly");
		 Iterator<?> iteratorHourly = hArr.iterator();

		 while(iteratorHourly.hasNext()) {
			  
		    Object hourly = new JSONParser().parse(iteratorHourly.next().toString());
			JSONObject hourlyObj = (JSONObject) hourly; 
			 
			String timeStampHourly = hourlyObj.get("dt").toString();
			Date dateHourly = new Date(Long.parseLong(timeStampHourly)*1000);
			
			//SetWeather
			JSONArray hOArr = (JSONArray) (hourlyObj.get("weather"));
			Object weatherHourly = new JSONParser().parse(hOArr.get(0).toString());
			JSONObject weatherObjHourly = (JSONObject) weatherHourly;
					
			Hourly object = new Hourly(hourlyObj.get("temp").toString(), hourlyObj.get("humidity").toString(), 
					hourlyObj.get("wind_speed").toString(), weatherObjHourly.get("description").toString(),weatherObjHourly.get("icon").toString(), dateHourly);

			hourlyObjects.add(object);
		
		 }
		
	}
	
	//~~ WeatherHistory
	public void analyzeWeatherHistory(){
		
	}
	
	
	//Set Latitude and longitude
	public void setLatitude(String data){
		this.latitude = data;
	}
	public void setLongitude(String data){
		this.longitude = data;
	}
	
	//Get Latitude and longitude
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
	
	public void setCurrentWeatherIcon(String icon){
		if(icon.equals("01d")){
			this.icon = "clear";
		}
		else if(icon.equals("01n")){
			this.icon = "clear night";
		}
		else if(icon.equals("02d")){
			this.icon = "cloudSunny";
		}
		else if(icon.equals("02n")){
			this.icon = "cloudNight";
		}
		else if(icon.equals("03d") || icon.equals("03n")){
			this.icon = "clouds";
		}
		else if(icon.equals("04d") || icon.equals("04n")){
			this.icon = "moreclouds";
		}
		else if(icon.equals("09d") || icon.equals("09n")){
			this.icon = "rain";
		}
		else if(icon.equals("10d")){
			this.icon = "rainSun";
		}
		else if(icon.equals("10n")){
			this.icon = "rainNight";
		}
		else if(icon.equals("11d") || icon.equals("11n")){
			this.icon = "thunderstorm";
		}
		else if(icon.equals("13d") || icon.equals("13n")){
			this.icon = "snow";
		}
		else if(icon.equals("50d") ||  icon.equals("50n")){
			this.icon = "mist";
		}
		else { this.icon = "mist";}
	}
	
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
	public String getCurrentWeatherIcon(){
		return this.icon;
	}
	
	//~~ Daily 
	public void setDailyArray(){
		
	}
	
	public ArrayList<Daily> getDailyArray(){
		return this.dailyObjects;
	}
	
	
	//~~ Hourly
	
	public void setHourlyArray(){ 
		
	}
	public ArrayList<Hourly> getHourlyArray(){
		return this.hourlyObjects;
	}

	
	//~~ Weather History
	public void setWeatherHistoryArray(){ 
		
	}
	public ArrayList<WeatherHistory> getWeatherHistoryArray(){
		return this.weatherHistoryObjects;
	}
	
}