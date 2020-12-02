package application.controller;

import application.model.WeatherWatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * This class represents the LocationController  
 * Writes the city name given by the user to city.csv
 * Which is then used in the other controllers to get the weather information
 * 
 * @author Gabrielle Albrecht/ypo253
 * @author Zane Zaiontz
 * 
 * UTSA CS 3443 - Team Project
 *  Fall 2020
 */

public class LocationController {
	@FXML
	Label label;
	@FXML
	TextField city;
	@FXML
	Button submit;
	
	private WeatherWatch w; 
	
	
	/**
	 * Initializes the LocationController
	 * @throws Exception if initialization fails
	 */
	public void initialize() throws Exception{
		MenuController mc = new MenuController();
		w = mc.getW();
		
		w.loadFile();
		label.setText(w.getCityName());
		label.setTextFill(Color.WHITE);
	}
	
	/**
	 * Changes the location for the weather on handle
	 * @param a the ActionEvent to handle
	 * @throws Exception if save fails
	 */

	public void handle(ActionEvent a) throws Exception {
		if(!city.getText().isEmpty())
		{
			w.setCityName(city.getText());
			label.setText(w.getCityName());
			label.setTextFill(Color.WHITE);
			w.save();

			//MenuController mc = new MenuController();
			//mc.setBackground();
		}
	}
}
