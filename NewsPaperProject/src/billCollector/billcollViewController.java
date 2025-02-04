package billCollector;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import billGenerator.BillConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class billcollViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblOut;

    @FXML
    private TextField txMobile;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtstartDate;

    @FXML
    void doBillDetails(ActionEvent event) throws SQLException {
         pst = con.prepareStatement("select * from customermanager where mobile=?");
         pst.setString(1,txMobile.getText());
         ResultSet table = pst.executeQuery();
         while(table.next()) {
        	 
         }
         }

    @FXML
    void showPaymentDetails(ActionEvent event) {

    }

    @FXML
    void txtAmount(ActionEvent event) {

    }
    Connection con;
    PreparedStatement pst;
    @FXML
    void initialize() throws SQLException {
        con = billGenerator.BillConnector.doConnect();
//        
//        pst = con.prepareStatement("Select * from customermanager");
//        ResultSet table = pst.executeQuery();
//        while(table.next()) {
//        	
//        }
        
    }

}
