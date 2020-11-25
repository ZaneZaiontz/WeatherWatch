package application.controller;

import java.io.IOException; 
import application.model.WeatherWatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LocationController {
	@FXML
	Label label;
	@FXML
	TextField city;
	@FXML
	Button submit;
	
	private WeatherWatch w = new WeatherWatch(); 
	
	public void initialize(){
		try{
			w.loadFile();
			label.setText(w.getCityName());
			label.setTextFill(Color.WHITE);
		}catch(IOException e){}
	}
	
	public void handle(ActionEvent a) {
		try{
			if(!city.getText().isEmpty())
			{
				w.setCityName(city.getText());
				label.setText(w.getCityName());
				label.setTextFill(Color.WHITE);
				w.save();
			}
		}catch(IOException e){}
	}

}
