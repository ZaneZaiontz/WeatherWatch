package application;
	
import application.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

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

// testing, pushing code


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