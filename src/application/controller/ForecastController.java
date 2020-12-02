package application.controller;

import java.io.FileInputStream;

import application.model.Icon;
import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

/**
 * This class represents the ForecastController 
 * Sets the current temperature and icon
 * Sets the temperature and icons for the next 7 days
 *
 * @author Gabrielle Albrecht/ypo253
 * UTSA CS 3443 - Team Project
 *  Fall 2020
 *
 */

public class ForecastController {
	
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane view;
	@FXML
	Text cityName, descr, temp;
	@FXML
	Label d1, d2, d3, d4, d5, d6, d7, t1, t2, t3, t4, t5, t6, t7;
	@FXML
	ImageView Image, I1, I2, I3, I4, I5, I6, I7;
	
	
	/**
	 * Initializes the ForecastController
	 * @throws Exception if initialization fails
	 */
	public void initialize() throws Exception{
			MenuController mc = new MenuController();
			WeatherWatch w = mc.getW();
		
			w.loadFile();

			cityName.setText(w.getCityName());
	
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			descr.setText(w.getDescription());
			Double result = Double.parseDouble(w.getTemp());
			int degree = (int)Math.round(result);
			temp.setText(degree + "°F");
			
			Icon i = new Icon();
			i.setIconResult(w.getCurrentWeatherIcon());

			Image img = new Image(new FileInputStream(i.currWeatherIcon()));
			Image.setImage(img);
			
			// Set 7 day forecast 
			d1.setText(w.getDailyArray().get(1).getDay() + "");
			Icon icon = new Icon();
			icon.setIconResult(w.getDailyArray().get(1).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I1.setImage(img);
			t1.setText(w.getDailyArray().get(1).getHighInt() + "° " + w.getDailyArray().get(1).getLowInt() + "°" );
			
			d2.setText(w.getDailyArray().get(2).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(2).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I2.setImage(img);
			t2.setText(w.getDailyArray().get(2).getHighInt() + "° " + w.getDailyArray().get(2).getLowInt() + "°" );
			
			d3.setText(w.getDailyArray().get(3).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(3).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I3.setImage(img);
			t3.setText(w.getDailyArray().get(3).getHighInt() + "° " + w.getDailyArray().get(3).getLowInt() + "°" );
			
			d4.setText(w.getDailyArray().get(4).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(4).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I4.setImage(img);
			t4.setText(w.getDailyArray().get(4).getHighInt() + "° " + w.getDailyArray().get(4).getLowInt() + "°" );
			
			d5.setText(w.getDailyArray().get(5).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(5).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I5.setImage(img);
			t5.setText(w.getDailyArray().get(5).getHighInt() + "° " + w.getDailyArray().get(5).getLowInt() + "°" );
			
			
			d6.setText(w.getDailyArray().get(6).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(6).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I6.setImage(img);
			t6.setText(w.getDailyArray().get(6).getHighInt() + "° " + w.getDailyArray().get(6).getLowInt() + "°" );
			
			
			d7.setText(w.getDailyArray().get(7).getDay() + "");
			icon.setIconResult(w.getDailyArray().get(7).getIcon());
			img = new Image(new FileInputStream(icon.currWeatherIcon()));
			I7.setImage(img);
			t7.setText(w.getDailyArray().get(7).getHighInt() + "° " + w.getDailyArray().get(7).getLowInt() + "°" );
				
			w.save();
	}
}
