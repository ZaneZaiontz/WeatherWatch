package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class WeatherHistoryController {
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	Label label;

	public void initialize(){
		
		label.setText("Weather History");
		
	}

}
