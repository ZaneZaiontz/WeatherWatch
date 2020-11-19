package application.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class WeatherWatch {
	public static String cityName;
	
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType()
				);

		return map;
	}

	public static void analyze() {
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
			URLConnection conn = url.openConnection();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			System.out.println(result);

			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

			System.out.println("Current Temperatures: " + mainMap.get("temp"));
			System.out.println("Current Humidity: " + mainMap.get("humidity"));
			System.out.println("Wind speeds: " + windMap.get("speed"));
			System.out.println("Wind angle: " + windMap.get("deg"));
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}