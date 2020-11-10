package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadarController {

	@FXML
	Label label;
	
	public void initialize(){
		
		label.setText("Radar");
		
	}

}
