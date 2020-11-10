package application.controller;

import javafx.fxml.FXMLLoader; 
import javafx.event.ActionEvent; 
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.*;
import java.net.URL;
import application.Main;
 
public class MenuController {  
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	
	@FXML
	private void handleButton1Action(ActionEvent event){
		try{
			URL fileUrl = Main.class.getResource("/application/view/Forecast.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){}
		
	}
	
	
	@FXML
	private void handleButton2Action(ActionEvent event){
		try{
			URL fileUrl = Main.class.getResource("/application/view/Radar.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){}
	}
	
	@FXML
	private void handleButton3Action(ActionEvent event){
		try{
			URL fileUrl = Main.class.getResource("/application/view/WeatherHistory.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){}
	}
	
	@FXML
	private void handleButton4Action(ActionEvent event){
		try{
			URL fileUrl = Main.class.getResource("/application/view/Location.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){}
	} 
}