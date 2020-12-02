package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


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
			primaryStage.getIcons().add(new Image("file:./../images/appIcon.png"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
