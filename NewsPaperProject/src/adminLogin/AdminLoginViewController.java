package adminLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class AdminLoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblOut;
           
    @FXML
    private PasswordField passfield;
            
	@FXML
    void generatePass(ActionEvent event) {
    	PasswordField passwordField = new PasswordField();
    	passwordField.setPromptText("bhavya#1");
         if(passfield.getText().equals("bhavya#1")) {
        	 try {
                 Parent root;
                 root = FXMLLoader.load(getClass().getResource("/adminDesk/AdminView.fxml"));
                 Scene scene = new Scene(root);
                 Stage stage = new Stage();
                 stage.setScene(scene);
               //to hide the opened window
    			 
     			Scene scene1=(Scene)lblOut.getScene();
     			   scene1.getWindow().hide();
     			
                 stage.show();
                 lblOut.setText("Password Correct..");
             } catch (IOException e) {
                 e.printStackTrace();
             } 
         }
    }

    @FXML
    void initialize() {
       
    }

}
