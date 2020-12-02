package application.model;


/**
 *  This class represents the icon,
 *  returns the image path for weatherIcon
 *  returns the image path for background image
 *  
 *  @author Gabrielle Albrecht/ypo253 
 * 
 *  UTSA CS 3443 - Team Project 
 *  Fall 2020
 */

public class Icon {
	
	String icon, weatherResult;
	
	/**
	 * Default constructor
	 */
	public Icon(){
		
	}
	
	/**
	 * 
	 * @param icon string representing the icon information
	 */
	public Icon(String icon){
		this.icon  = icon;
	}
	
	/**
	 * Sets the name of the icon
	 * @param icon to set (String)
	 */
	public void setIcon(String icon){
		this.icon  = icon;
	}
	
	/**
	 * Gets the name of the icon
	 * @return icon the name of the icon
	 */
	public String getIcon(){
		return this.icon;
	}
	
	/**
	 * Sets the weatherResult,
	 * @param icon the IconResult to set (String)
	 */
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
	
	/**
	 * Return the description of the icon
	 * @return weatherResult the description of the icon
	 */
	public String iconResult(){
		return this.weatherResult;
	}
	
	/**
	 * Return the image path to the weather icon
	 * @return path the image path to the weatherIcon
	 */
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
			return "images/WeatherIcons/coldCloud.png";
		}
		else if(this.weatherResult.equals("mist")){
			return "images/WeatherIcons/Mist.png";
		}
		else { return "images/WeatherIcons/Mist.png"; }
	}
	
	/**
	 * Return the image path to the weather background
	 * @return path the image path to the background image
	 */
	public String currWeatherBackground(){
		if(this.weatherResult.equals("clear")){
			return "images/BackgroundImages/Sunny.png";
		}
		else if(this.weatherResult.equals("clear night")){
			return "images/BackgroundImages/clearNight.png";
		}
		else if(this.weatherResult.equals("cloudSunny")){
			return "images/BackgroundImages/TempBG.png";
		}
		else if(this.weatherResult.equals("cloudNight")){
			return "images/BackgroundImages/TempBG.png";
		}
		else if(this.weatherResult.equals("clouds")){
			return "images/BackgroundImages/TempBG.png";
		}
		else if(this.weatherResult.equals("moreclouds")){
			return "images/BackgroundImages/TempBG.png";
		} 
		else if(this.weatherResult.equals("rain")){
			return "images/BackgroundImages/RainyBackground.jpg";
		}
		else if(this.weatherResult.equals("rainSun")){
			return "images/BackgroundImages/Rain.png";
		}
		else if(this.weatherResult.equals("rainNight")){
			return "images/BackgroundImages/RainyBackground.jpg";
		}
		else if(this.weatherResult.equals("thunderstorm")){
			return "images/BackgroundImages/Thunder.png";
		}
		else if(this.weatherResult.equals("snow")){
			return "images/BackgroundImages/snow.png";
		}
		else if(this.weatherResult.equals("mist")){
			return "images/BackgroundImages/mist.png";
		}
		else { return "images/BackgroundImages/Mist.png"; }
	}
		
}
