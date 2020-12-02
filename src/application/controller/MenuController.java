package application.controller;

import javafx.fxml.FXMLLoader;    
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.*;
import java.io.FileInputStream;
import application.model.Icon;
import application.model.WeatherWatch;

/**
 * This class represents the MenuController
 *
 * Sets the view;
 * Calls each of the controller when they are clicked and sets the view
 * with the information from that controller
 * 
 * @author Gabrielle Albrecht/ypo253
 * 
 * UTSA CS 3443 - Team Project
 *  Fall 2020
 */

public class MenuController {  
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	public ImageView background; 
	@FXML
	Label label;
	Stage stage;
	
	static WeatherWatch w = new WeatherWatch();
	
	/**
	 * Initialize the MenuContoller
	 * @throws Exception if initialization fails
	 */
	public void initialize(){
		try{
			w.loadFile();
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			setBackground();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Forecast.fxml"));
			mainPane.setCenter(loader.load());
		}catch(Exception e){label.setText("An error occured");}
	}
	
	/** 
	 * @throws Exception for handleButton1Action
	 */
	@FXML
	private void handleButton1Action(ActionEvent event){
		label.setText("");
		try{
			setBackground();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Forecast.fxml"));
			mainPane.setCenter(loader.load());
		}catch(Exception e){label.setText("An error occured");}
	}

	/**
	 * @throws Exception for handleButton2Action
	 */
	@FXML
	private void handleButton2Action(ActionEvent event){
		label.setText("");
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Radar.fxml"));
			mainPane.setCenter(loader.load());
		}catch(Exception e){label.setText("An error occured");}
	}
	
	/**
	 * @throws Exception for handleButton3Action
	 */
	@FXML
	private void handleButton3Action(ActionEvent event){
		label.setText("");
		try{
			setBackground();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/DetailedWeather.fxml"));
			mainPane.setCenter(loader.load());
		}catch(Exception e){label.setText("An error occured");}
	}
	
	/**
	 * @throws Exception for handleButton4Action
	 */
	@FXML
	private void handleButton4Action(ActionEvent event){
		label.setText("");
		try{ 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Location.fxml"));
			mainPane.setCenter(loader.load());
			
			setBackground();
			}catch(Exception e){label.setText("An error occured");}
	} 
	
	/**
	 * Set the background
	 */
	public void setBackground(){
		label.setText(""); 
		try{
			w.loadFile();
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			Icon i = new Icon();
			i.setIconResult(w.getCurrentWeatherIcon());
			Image img = new Image(new FileInputStream(i.currWeatherBackground()));
			background.setImage(img);
		}catch(Exception e){label.setText("An error occured");}
	}
	
	/**
	 * All controllers use the same WeatherWatch object
	 * @return WeatherWatch object
	 */
	public WeatherWatch getW(){
		return MenuController.w;
	}
}
