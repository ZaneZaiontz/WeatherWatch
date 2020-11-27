package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * WeatherWatch.java gets current weather for a city, 
 * creates class objects of daily weather info and stores them in an ArrayList,
 * creates class objects of horuly weather info and stores them in an ArrayList,  
 * returns weather information. 
 *
 * @author Gabrielle Albrecht/ypo253
 *
 */

public class WeatherWatch {
	private String cityName;
	private String fileName = "data/city.csv";
	private String Temp, feelsLike, humidity, windSpeed, latitude, longitude, icon, description, windDegree, weatherMain;
	ArrayList<Daily> dailyObjects = new ArrayList<>();
	ArrayList<Hourly> hourlyObjects = new ArrayList<>();
	
	/**
	 * Default constructor
	 */
	public WeatherWatch() {
	}
	
	/**
	 * Constructor - sets cityName
	 * @param cityName Sets the name of the city to get the weather info for.
	 */
	public WeatherWatch(String cityName) {
		
		this.cityName = cityName;
	}
	
	/**
	 * 
	 * @param cityName Sets the name of the city to get the weather info for.
	 */
	public void setCityName(String cityName){
		this.cityName = cityName;
		
	}
	
	/**
	 * 
	 * @return cityName of the city that is being used to get weather info.
	 */
	public String getCityName(){
		return this.cityName;
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFileName(){
		return this.fileName;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void loadFile() throws IOException {
		File fileName = new File(this.fileName);
		
		Scanner scan = new Scanner( fileName );
		if(scan.hasNext()){
			String line = scan.nextLine();
			String tokens[] = line.split(",");
			setCityName(tokens[0]);
		}
		else { setCityName("San Antonio"); }
		scan.close();
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException{
		FileWriter write = new FileWriter (this.fileName);
		PrintWriter writeToFile = new PrintWriter(write);
		
		writeToFile.println(String.format("%s,%s,%s", getCityName(), getLatitude(), getLongitude())); // can add more
		
		writeToFile.close();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	} 
	
	//~~ Current
	/**
	 * 
	 * @throws Exception
	 */
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
	/**
	 * 
	 * @throws Exception
	 */
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
		setWindDegree(currentMap.get("wind_deg").toString());


		Object obj2 = new JSONParser().parse(jo.get("current").toString());
		JSONObject jo2 = (JSONObject) obj2; 
		JSONArray jArr = (JSONArray) jo2.get("weather");
		
	    Object weather = new JSONParser().parse(jArr.get(0).toString());
		JSONObject weatherObj = (JSONObject) weather;
	    setCurrentWeatherIcon(weatherObj.get("icon").toString());
	    setWeatherMain(weatherObj.get("main").toString());
	    setDescription(weatherObj.get("description").toString());
	    

		//~~ Daily;
		 JSONArray dArr = (JSONArray) jo.get("daily");
		 Iterator<?> iteratorDaily = dArr.iterator();

		 while(iteratorDaily.hasNext()) {
			  
		    Object daily = new JSONParser().parse(iteratorDaily.next().toString());
			JSONObject dailyObj = (JSONObject) daily; 
			
			Map<String, Object> tempMap = jsonToMap(dailyObj.get("temp").toString());
			//Map<String, Object> feelsLikeMap = jsonToMap(dailyObj.get("feels_like").toString());
			
			String timeStamp = dailyObj.get("dt").toString();
			Long date = Long.parseLong(timeStamp);
			 
			//SetWeather
			JSONArray dOArr = (JSONArray) dailyObj.get("weather");
			Object weather2 = new JSONParser().parse(dOArr.get(0).toString());
			JSONObject weatherObj2 = (JSONObject) weather2;
					
			Daily object = new Daily(tempMap.get("min").toString(), tempMap.get("max").toString(), 
					dailyObj.get("humidity").toString(),  dailyObj.get("wind_speed").toString(), 
					dailyObj.get("pop").toString(), weatherObj2.get("description").toString(), weatherObj2.get("icon").toString(), date);

			dailyObjects.add(object);
		 }

		//~~ Hourly
		 JSONArray hArr = (JSONArray) jo.get("hourly");
		 Iterator<?> iteratorHourly = hArr.iterator();

		 while(iteratorHourly.hasNext()) {
			  
		    Object hourly = new JSONParser().parse(iteratorHourly.next().toString());
			JSONObject hourlyObj = (JSONObject) hourly; 
			 
			String timeStampHourly = hourlyObj.get("dt").toString();
			Long dateHourly = Long.parseLong(timeStampHourly);
			//Date dateHourly = new Date(Long.parseLong(timeStampHourly)*1000);
			
			//SetWeather
			JSONArray hOArr = (JSONArray) (hourlyObj.get("weather"));
			Object weatherHourly = new JSONParser().parse(hOArr.get(0).toString());
			JSONObject weatherObjHourly = (JSONObject) weatherHourly;
					
			Hourly object = new Hourly(hourlyObj.get("temp").toString(), hourlyObj.get("humidity").toString(), 
					hourlyObj.get("wind_speed").toString(), weatherObjHourly.get("description").toString(),weatherObjHourly.get("icon").toString(), dateHourly);

			hourlyObjects.add(object);
		 }
		
	}
	
	//Set Latitude and longitude
	/**
	 * 
	 * @param data sets the latitude of the city used to get weather info for
	 */
	public void setLatitude(String data){
		this.latitude = data;
	}
	/**
	 * 
	 * @param data sets the longitude of the city used to get weather info for
	 */
	public void setLongitude(String data){
		this.longitude = data;
	}
	
	//Get Latitude and longitude
	/**
	 * 
	 * @return latitude of the city used to get weather info for.
	 */
	public String getLatitude(){
		return this.latitude;
	}
	
	/**
	 * 
	 * @return longitude of the city used to get weather info for.
	 */
	public String getLongitude(){
		return this.longitude;
	}
	
	//~~ Current
	/**
	 * 
	 * @param data used to set the current Temp
	 */
	public void setTemp(String data){
		this.Temp = data;
	}
	
	/**
	 * 
	 * @param data is used to set the current feelsLike 
	 */
	public void setFeelsLike(String data){
		this.feelsLike = data;
	}
	
	/**
	 * 
	 * @param data is used to set the current humidity
	 */
	public void setHumidity(String data){
		this.humidity = data;
	}
	
	/**
	 * 
	 * @param data is used to set the current windSpeed
	 */
	public void setWindSpeed(String data){
		this.windSpeed = data;
	}
	
	/**
	 * 
	 * @param data is used to set the current weather description
	 */
	public void setDescription(String data){
		this.description = data;
	}
	
	/**
	 * 
	 * @param data is used to set the current weather icon.
	 */
	public void setCurrentWeatherIcon(String data){
		this.icon = data;
	}

	/**
	 * 
	 * @param data is used to set the current windDegree
	 */
	public void setWindDegree(String data) {
		this.windDegree = data;
	}
	
	/**
	 * 
	 * @param data is used to set weatherMain
	 */
	public void setWeatherMain(String data) {
		this.weatherMain = data;
	}
	

	/**
	 * 
	 * @return Temp the current temperature
	 */
	public String getTemp(){
		return this.Temp;
	}
	
	/**
	 * 
	 * @return feelsLike the current weather feelsLike
	 */
	public String getFeelsLike(){
		return this.feelsLike;
	}
	
	/**
	 * 
	 * @return humidity the current humidity
	 */
	public String getHumidity(){
		return this.humidity;
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
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCurrentWeatherIcon(){
		return this.icon;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWindDegree() {
		return this.windDegree; 
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWeatherMain() {
		return this.weatherMain;
	}
	
	//~~ Daily 
	/**
	 * 
	 */
	public void setDailyArray(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Daily> getDailyArray(){
		return this.dailyObjects;
	}
	
	
	//~~ Hourly
	/**
	 * 
	 */
	public void setHourlyArray(){ 
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Hourly> getHourlyArray(){
		return this.hourlyObjects;
	}
}
