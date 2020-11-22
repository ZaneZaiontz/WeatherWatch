package application.controller;

import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailedWeatherController {

	@FXML
	Label label;
	
	public void initialize(){
		
		label.setText("Detailed Weather");
		
	}

}
