package application.controller;

import java.io.IOException;

import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DetailedWeatherController {

	@FXML
	Label label;
	@FXML
	Label cityName;
	@FXML
	Label temp;
	@FXML
	Label feels_like;
	@FXML
	Label humidity;
	@FXML
	Label windSpeed;
	@FXML
	Label windDegree;
	@FXML
	Label weather;
	@FXML
	Label description;
	@FXML
	Label hourly;
	@FXML
	ListView hourly1;
	@FXML
	ListView hourly2;
	
	public void initialize() {
		try {
			//label.setText("Detailed Weather");
			
			WeatherWatch w = new WeatherWatch();
			w.loadFile();
			cityName.setText(w.getCityName());
		
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
//			for (int i = 0; i < w.getHourlyArray().size(); i++) {
//				System.out.println(w.getHourlyArray().get(i));
//				System.out.println(w.getHourlyArray().size());
//			}
			
			cityName.setText(w.getCityName());
			temp.setText("Current temperature: " + w.getTemp() + "°F");
			feels_like.setText("Temperature feels like: " + w.getFeelsLike() + "°F");
			humidity.setText("Humidity: " + w.getHumidity() + "%");
			windSpeed.setText("Wind speed: " + w.getWindSpeed() + " mph");
			windDegree.setText("Wind degree: " + w.getWindDegree() + "°");
			weather.setText("Weather: " + w.getWeatherMain());
			description.setText("Weather description: " + w.getDescription());
			
			hourly.setText("Weather data for " + w.getCityName() + " on upcoming days:");
			
			for (int i = 0; i < 24; i ++) {
				hourly1.getItems().add(w.getHourlyArray().get(i));
			}
			for (int j = 24; j < 48; j ++) {
				hourly2.getItems().add(w.getHourlyArray().get(j));
			}
		} catch (Exception e) {}
		
	}

}
