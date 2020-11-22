package application.controller;

import application.model.WeatherWatch; 
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RadarController {

	@FXML
	Label label;
	@FXML 
	StackPane fStack;
	@FXML 
	AnchorPane root;

	public void initialize(){
		
		//label.setText("Radar");
		//WeatherWatch w = new WeatherWatch();
		//w.analyzeCurrent()
		WebView web = new WebView();
		WebEngine engine = web.getEngine();
		//engine.load("https://www.windy.com/-Weather-radar-radar?radar,"+w.getLatitude()+",+"+ w.getLongitude()+",5");
		engine.load("https://www.windy.com/-Weather-radar-radar?radar,33.138,-92.769,5");
		//engine.load("https://openweathermap.org/weathermap?basemap=map&cities=false&layer=radar&lat=30&lon=-20&zoom=3");
		
		fStack.getChildren().add(web);

	}

}
