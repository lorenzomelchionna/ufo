package it.polito.tdp.ufo;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ufo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FXMLController {
    
	Model model;
	
	 @FXML
	 private ResourceBundle resources;
	 
	 @FXML
	 private URL location;

	 @FXML
	 private ComboBox<String> boxForma;

	 @FXML
	 private Label txtAvvistamenti;

	 @FXML
	 void doConta(ActionEvent event) {
		 
		 String forma = boxForma.getValue();
		 int count = model.countByForma(forma);
		 
		 txtAvvistamenti.setText("Gli UFO della forma "+forma+" sono: "+String.valueOf(count));

	 }
    
    public void setModel(Model model) {
    	
    	this.model = model;
    	boxForma.getItems().addAll(this.model.getFormeUFO());
    	
    }
    
    @FXML
    void initialize() {
    	
        assert boxForma != null : "fx:id=\"boxForma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAvvistamenti != null : "fx:id=\"txtAvvistamenti\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
}
