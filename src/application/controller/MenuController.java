package application.controller;

import javafx.fxml.FXMLLoader;  
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import application.Main;
import application.model.WeatherWatch;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
 
public class MenuController {  
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	ImageView background;
	
	public void initialize(){
		try{
			URL fileUrl = Main.class.getResource("/application/view/DetailedWeather.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){}
	}
	
	@FXML
	private void handleButton1Action(ActionEvent event){
		try{
			URL fileUrl = Main.class.getResource("/application/view/Forecast.fxml");
			new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
			mainPane.setCenter(view);
			}catch(Exception e){e.printStackTrace();}
		
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
			URL fileUrl = Main.class.getResource("/application/view/DetailedWeather.fxml");
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
	
	/*public void setBackground(String fileName){
		try {
			Image image = new Image(new FileInputStream(fileName));
			background.setImage(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	*/
}
