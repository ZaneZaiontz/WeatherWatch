package application.controller;

import application.model.WeatherWatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LocationController {
	@FXML
	Label label;
	@FXML
	TextField city;
	@FXML
	Button submit;
	
	public void initialize(){
		label.setText("Location");
	}
	
	public void handle(ActionEvent e) {
		WeatherWatch.cityName = city.getText();
		label.setText(city.getText());
		WeatherWatch.analyze();
	}

}
