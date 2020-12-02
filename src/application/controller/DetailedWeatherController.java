package application.controller;

import application.model.Hourly;
import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * This class represents the DetailedWeatherController 
 * Displays more detailed current weather information
 * Displays the detailed weather information for the next 48 hours
 * 
 * @author Dariel Malave Perez
 * @author Zane Zaiontz
 * @author Gabrielle Albrecht/ypo253 
 * 
 *  UTSA CS 3443 - Team Project
 *  Fall 2020
 */

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
	ListView<Hourly> hourly1 = new ListView<>();

	/**
	 * Initializes the DetailedWeatherController
	 * @throws Exception if initialization fails
	 */
	public void initialize() throws Exception{
			MenuController mc = new MenuController();
			WeatherWatch w = mc.getW();
			
			w.loadFile();
			cityName.setText(w.getCityName());
		
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			cityName.setText(w.getCityName());
			temp.setText("Current temperature: " + w.getTemp() + "°F");
			feels_like.setText("Temperature feels like: " + w.getFeelsLike() + "°F");
			humidity.setText("Humidity: " + w.getHumidity() + "%");
			windSpeed.setText("Wind speed: " + w.getWindSpeed() + " mph");
			windDegree.setText("Wind degree: " + w.getWindDegree() + "°");
			weather.setText("Weather: " + w.getWeatherMain());
			description.setText("Weather description: " + w.getDescription());
			
			hourly.setText("Hourly weather data for " + w.getCityName());
			
			for (int i = 0; i < 48; i ++) {
				hourly1.getItems().add(w.getHourlyArray().get(i));
			}
	}
}
