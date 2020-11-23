package application.controller;

import java.io.File;

public class Icon {
	
	String icon, weatherResult;
	
	public Icon(){
		
	}
	
	public Icon(String icon){
		this.icon  = icon;
	}
	
	public void setIcon(String icon){
		this.icon  = icon;
	}
	
	public String getIcon(){
		return this.icon;
	}
	
	public void setIconResult(String icon){
		if(icon.equals("01d")){
			this.weatherResult = "clear";
		}
		else if(icon.equals("01n")){
			this.weatherResult = "clear night";
		}
		else if(icon.equals("02d")){
			this.weatherResult = "cloudSunny";
		}
		else if(icon.equals("02n")){
			this.weatherResult = "cloudNight";
		}
		else if(icon.equals("03d") || icon.equals("03n")){
			this.weatherResult = "clouds";
		}
		else if(icon.equals("04d") || icon.equals("04n")){
			this.weatherResult = "moreclouds";
		}
		else if(icon.equals("09d") || icon.equals("09n")){
			this.weatherResult = "rain";
		}
		else if(icon.equals("10d")){
			this.weatherResult = "rainSun";
		}
		else if(icon.equals("10n")){
			this.weatherResult = "rainNight";
		}
		else if(icon.equals("11d") || icon.equals("11n")){
			this.weatherResult = "thunderstorm";
		}
		else if(icon.equals("13d") || icon.equals("13n")){
			this.weatherResult = "snow";
		}
		else if(icon.equals("50d") ||  icon.equals("50n")){
			this.weatherResult = "mist";
		}
		else { this.weatherResult = "mist";}
	}
	
	public String iconResult(){
		return this.weatherResult;
	}
	
	public String currWeatherIcon(){
		if(this.weatherResult.equals("clear")){
			return "images/WeatherIcons/sunny.png";
		}
		else if(this.weatherResult.equals("clear night")){
			return "images/WeatherIcons/clearNight.png";
		}
		else if(this.weatherResult.equals("cloudSunny")){
			return "images/WeatherIcons/partCloud.png";
		}
		else if(this.weatherResult.equals("cloudNight")){
			return "images/WeatherIcons/nightCloud.png";
		}
		else if(this.weatherResult.equals("clouds")){
			return "images/WeatherIcons/cloudy.png";
		}
		else if(this.weatherResult.equals("moreclouds")){
			return "images/WeatherIcons/moreCloud.png";
		}
		else if(this.weatherResult.equals("rain")){
			return "images/WeatherIcons/rain.png";
		}
		else if(this.weatherResult.equals("rainSun")){
			return "images/WeatherIcons/partRain.png";
		}
		else if(this.weatherResult.equals("rainNight")){
			return "images/WeatherIcons/rainNight.png";
		}
		else if(this.weatherResult.equals("thunderstorm")){
			return "images/WeatherIcons/storm.png";
		}
		else if(this.weatherResult.equals("snow")){
			return "images/WeatherIcons/cold.png";
		}
		else if(this.weatherResult.equals("mist")){
			return "images/WeatherIcons/Mist.png";
		}
		else { return "images/WeatherIcons/Mist.png"; }
	}

}
