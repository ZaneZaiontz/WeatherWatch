package application.controller;

import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ForecastController {
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	Text cityName;
	
	
	public void initialize(){
		try{
			WeatherWatch w = new WeatherWatch();
			w.loadFile();
			cityName.setText(w.getCityName());
			
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			
			// If getWeatherIcon is cloudy etc set image and background as cloudy, etc
		/*	if(w.getWeatherIcon().equals("clear")){
				//SetImage
				//SetBackground
			}
			else if(w.getWeatherIcon().equals("clear night")){
				
			}
			else if(w.getWeatherIcon().equals("cloudSunny")){
			
			}
			else if(w.getWeatherIcon().equals("cloudNight")){

			}
			else if(w.getWeatherIcon().equals("clouds")){
				
			}
			else if(w.getWeatherIcon().equals("moreClouds")){
				
			}
			else if(w.getWeatherIcon().equals("rain")){

			}
			else if(w.getWeatherIcon().equals("rainSun")){

			}
			else if(w.getWeatherIcon().equals("rainNight")){
				
			}
			else if(w.getWeatherIcon().equals("thunderstorm")){
				
			}
			else if(w.getWeatherIcon().equals("snow")){
				
			}
			else if(w.getWeatherIcon().equals("mist")){
				
			}*/
			
			// Set 7 day forecast
			
			// Set Precipitation/Wind/Temp over day
		
		}catch(Exception e){}
		
	}

}
