package application.controller;

import java.io.IOException;

import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ForecastController {
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	Label label;
	
	public void initialize(){
		try{
		label.setText("Forecast"); 
		WeatherWatch w = new WeatherWatch();
		w.loadFile();
		w.analyzeCurrent();
		w.analyzeOneCall();
		
		
		
		}catch(IOException e){}
		
	}

}
