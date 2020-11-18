package application;

import application.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


// :)))))))))))))))))))))))))))))))))))))))))

/**
* The Main class launches the application and sets up MainController.fxml.
*
*  @author Gabrielle Albrecht/ypo253
*  @author Dariel Malave Perez
*  @author Robert Taylor
*  @author Jina Wilde
*  @author Zane Zaiontz
*
*  UTSA CS 3443 - Team Project
*  Fall 2020
*/

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Menu.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("Weather Watch");

			MenuController mC = loader.getController();
			mC.initialize();

			Scene scene = new Scene(root, 800,800);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.Map;
//import java.util.HashMap;
//
//import com.google.gson.*;
//import com.google.gson.reflect.*;
//
//public class Main {
//	public static Map<String, Object> jsonToMap(String str) {
//		Map<String, Object> map = new Gson().fromJson(
//				str, new TypeToken<HashMap<String, Object>>() {}.getType()
//				);
//
//		return map;
//	}
//
//	public static void main(String[] args) {
//		try {
//			StringBuilder result = new StringBuilder();
//			// Example URL for San Francisco (works for cities)
//			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=San Francisco&appid=48fb3ffd07fec36d9f2a24f46772bada&units=imperial");
//			URLConnection conn = url.openConnection();
//
//			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line;
//			while ((line = rd.readLine()) != null) {
//				result.append(line);
//			}
//			rd.close();
//			System.out.println(result);
//
//			Map<String, Object> respMap = jsonToMap(result.toString());
//			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
//			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
//
//			System.out.println("Current Temperatures: " + mainMap.get("temp"));
//			System.out.println("Current Humidity: " + mainMap.get("humidity"));
//			System.out.println("Wind speeds: " + windMap.get("speed"));
//			System.out.println("Wind angle: " + windMap.get("deg"));
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//	}
//}