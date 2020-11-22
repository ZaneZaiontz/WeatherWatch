package application.controller;

import application.model.WeatherWatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
	ImageView icon;
	
	public void initialize(){
		try{
			WeatherWatch w = new WeatherWatch();
			w.loadFile();
			cityName.setText(w.getCityName());
			
			w.analyzeCurrent();
			w.analyzeOneCall(); 
			
			descr.setText(w.getDescription());
			Double result = Double.parseDouble(w.getTemp());
			int degree = (int)Math.round(result);
			temp.setText(degree + "°F");
			
			/*System.out.println(w.getDailyArray().get(1).getIcon());
			System.out.println(w.getDailyArray().get(2).getIcon());
			System.out.println(w.getDailyArray().get(3).getIcon());
			System.out.println(w.getDailyArray().get(4).getIcon());
			System.out.println(w.getDailyArray().get(5).getIcon());
			System.out.println(w.getDailyArray().get(6).getIcon());
			System.out.println(w.getDailyArray().get(7).getIcon());*/
			
			d1.setText(w.getDailyArray().get(1).getDay() + "");
			t1.setText(w.getDailyArray().get(1).getHighInt() + "° " + w.getDailyArray().get(1).getLowInt() + "°" );
			
			d2.setText(w.getDailyArray().get(2).getDay() + "");
			t2.setText(w.getDailyArray().get(2).getHighInt() + "° " + w.getDailyArray().get(2).getLowInt() + "°" );
			
			d3.setText(w.getDailyArray().get(3).getDay() + "");
			t3.setText(w.getDailyArray().get(3).getHighInt() + "° " + w.getDailyArray().get(3).getLowInt() + "°" );
			
			d4.setText(w.getDailyArray().get(4).getDay() + "");
			t4.setText(w.getDailyArray().get(4).getHighInt() + "° " + w.getDailyArray().get(4).getLowInt() + "°" );
			
			d5.setText(w.getDailyArray().get(5).getDay() + "");
			t5.setText(w.getDailyArray().get(5).getHighInt() + "° " + w.getDailyArray().get(5).getLowInt() + "°" );
			
			d6.setText(w.getDailyArray().get(6).getDay() + "");
			t6.setText(w.getDailyArray().get(6).getHighInt() + "° " + w.getDailyArray().get(6).getLowInt() + "°" );
			
			d7.setText(w.getDailyArray().get(7).getDay() + "");
			t7.setText(w.getDailyArray().get(7).getHighInt() + "° " + w.getDailyArray().get(7).getLowInt() + "°" );

			
			
			// If getWeatherIcon is cloudy etc set image and background as cloudy, etc
			if(w.getCurrentWeatherIcon().equals("clear")){
				//SetImage
				//SetBackground
				System.out.println("clear");
			}
			else if(w.getCurrentWeatherIcon().equals("clear night")){
				System.out.println("clear night");
			}
			else if(w.getCurrentWeatherIcon().equals("cloudSunny")){
				System.out.println("cloudSunny");
			}
			else if(w.getCurrentWeatherIcon().equals("cloudNight")){
				System.out.println("cloudNight");
			}
			else if(w.getCurrentWeatherIcon().equals("clouds")){
				System.out.println("clouds");
			}
			else if(w.getCurrentWeatherIcon().equals("moreclouds")){
				System.out.println("moreclouds");
				//MenuController mc = new MenuController();
				//mc.setBackground("/BackgroundImages/TempBG.png");
			}
			else if(w.getCurrentWeatherIcon().equals("rain")){
				System.out.println("rain");
			}
			else if(w.getCurrentWeatherIcon().equals("rainSun")){
				System.out.println("rainSun");
			}
			else if(w.getCurrentWeatherIcon().equals("rainNight")){
				System.out.println("rainNight");
			}
			else if(w.getCurrentWeatherIcon().equals("thunderstorm")){
				System.out.println("thunderStorm");
			}
			else if(w.getCurrentWeatherIcon().equals("snow")){
				System.out.println("snow");
			}
			else if(w.getCurrentWeatherIcon().equals("mist")){
				System.out.println("mist");
			}
			
			// Set 7 day forecast
			
			// Set Precipitation/Wind/Temp over day
			
			
			w.save();
		}catch(Exception e){}
		
	}
}
