package adminDesk;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void billGenerator(ActionEvent event) {
    	try {
            // Load the FXML file for the view
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/billGenerator/BillGenView.fxml"));

            // Create a new scene with the loaded root element
            Scene scene = new Scene(root);

            // Create a new stage (window) for the application
            Stage stage = new Stage();

            // Set the scene for the stage
            stage.setScene(scene);

            // Show the stage (window)
            stage.show();
        } catch (IOException e) {
            // If an error occurs during loading the FXML file or creating the stage, print the stack trace
            e.printStackTrace();
        } 
    }

    @FXML
    void billStatus(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/BillStatus/BillStatusView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void billollector(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/billCollector/billCollView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void customerGoogler(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/customerDashBoard/CustomerDash.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void customerOrganiser(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/customerOrganiser/CustomerView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void displayHawkers(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/HawkerTable/HawkerTableView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    } 

    @FXML
    void hawkerManager(ActionEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/hawkerOrganiserrrr/HawkerView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgCUstomer(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/customerOrganiser/CustomerView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgCollector(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/billCollector/billCollView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgGenerator(MouseEvent event) {
    	try {
            // Load the FXML file for the view
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/billGenerator/BillGenView.fxml"));

            // Create a new scene with the loaded root element
            Scene scene = new Scene(root);

            // Create a new stage (window) for the application
            Stage stage = new Stage();

            // Set the scene for the stage
            stage.setScene(scene);

            // Show the stage (window)
            stage.show();
        } catch (IOException e) {
            // If an error occurs during loading the FXML file or creating the stage, print the stack trace
            e.printStackTrace();
        } 
    } 

    @FXML
    void imgGoogler(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/customerDashBoard/CustomerDash.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgHawker(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/hawkerOrganiserrrr/HawkerView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgPaper(MouseEvent event) {
    	try {
            // Load the FXML file for the view
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/PaperMaster/PMasterView.fxml"));

            // Create a new scene with the loaded root element
            Scene scene = new Scene(root);

            // Create a new stage (window) for the application
            Stage stage = new Stage();

            // Set the scene for the stage
            stage.setScene(scene);

            // Show the stage (window)
            stage.show();
        } catch (IOException e) {
            // If an error occurs during loading the FXML file or creating the stage, print the stack trace
            e.printStackTrace();
        } 
    }

    @FXML
    void imgStatus(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/BillStatus/BillStatusView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void imgdisplayHaw(MouseEvent event) {
    	try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/HawkerTable/HawkerTableView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void meetTheDevelopers(ActionEvent event) {

    }

    @FXML
    void paperMaster(ActionEvent event) {
        try {
            // Load the FXML file for the view
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/PaperMaster/PMasterView.fxml"));

            // Create a new scene with the loaded root element
            Scene scene = new Scene(root);

            // Create a new stage (window) for the application
            Stage stage = new Stage();

            // Set the scene for the stage
            stage.setScene(scene);

            // Show the stage (window)
            stage.show();
        } catch (IOException e) {
            // If an error occurs during loading the FXML file or creating the stage, print the stack trace
            e.printStackTrace();
        } 
    }
    






    @FXML
    void initialize() {

    }

}
