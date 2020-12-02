package application.controller;

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


/**
 * This class represents the RadarController
 * @author Zane Zaiontz 
 * 
 *  UTSA CS 3443 - Team Project
 *  Fall 2020
 */
public class RadarController {

	@FXML 
	StackPane fStack;
	@FXML 
	AnchorPane root;
	
	/**
	 * Initialize the RadarController
	 * @throws IOException if initialization fails
	 */
	public void initialize() throws IOException{
		File file = new File("data/city.csv");
		Scanner s1 = new Scanner(file);
		String line = s1.nextLine();
		String tokens[] = line.split(",");
		s1.close();
		
		WebView web = new WebView();
		WebEngine engine = web.getEngine();
		
		engine.load(String.format("https://www.windy.com/-Weather-radar-radar?radar,%s,%s,10", tokens[1], tokens[2]));
		fStack.getChildren().add(web);
	}

}
