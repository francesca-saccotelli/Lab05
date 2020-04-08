package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model=new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtRisultatiCorretti;

    @FXML
    private TextArea txtRisultatiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
        txtRisultatiCorretti.clear();
        txtRisultatiErrati.clear();
    	
    	List<String>anagrammi=model.anagrammi(txtParola.getText());
    	
    	for(String s:anagrammi) {
    		if(this.model.isCorrect(s)) {
    		txtRisultatiCorretti.appendText(s+"\n");
    		}else {
    			txtRisultatiErrati.appendText(s+"\n");
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
         txtParola.clear();
         txtRisultatiCorretti.clear();
         txtRisultatiErrati.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultatiCorretti != null : "fx:id=\"txtRisultatiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultatiErrati != null : "fx:id=\"txtRisultatiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
