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
			if(w.getCurrentWeatherIcon().equals("clear")){
				//SetImage
				//SetBackground
				System.out.println("clear");
			}
			else if(w.getCurrentWeatherIcon().equals("clear night")){
				System.out.println("clear night");
			}
			else if(w.getCurrentWeatherIcon().equals("cloudSunny")){
				System.out.println("cloudSunny");
			}
			else if(w.getCurrentWeatherIcon().equals("cloudNight")){
				System.out.println("cloudNight");
			}
			else if(w.getCurrentWeatherIcon().equals("clouds")){
				System.out.println("clouds");
			}
			else if(w.getCurrentWeatherIcon().equals("moreClouds")){
				System.out.println("moreclouds");
			}
			else if(w.getCurrentWeatherIcon().equals("rain")){
				System.out.println("rain");
			}
			else if(w.getCurrentWeatherIcon().equals("rainSun")){
				System.out.println("rainSun");
			}
			else if(w.getCurrentWeatherIcon().equals("rainNight")){
				System.out.println("rainNight");
			}
			else if(w.getCurrentWeatherIcon().equals("thunderstorm")){
				System.out.println("thunderStorm");
			}
			else if(w.getCurrentWeatherIcon().equals("snow")){
				System.out.println("snow");
			}
			else if(w.getCurrentWeatherIcon().equals("mist")){
				System.out.println("mist");
			}
			
			// Set 7 day forecast
			
			// Set Precipitation/Wind/Temp over day
		
		}catch(Exception e){}
		
	}

}
