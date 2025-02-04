package BillStatus;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BillStatusViewController {
    Connection con;
    PreparedStatement pst;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup TMTM;

    @FXML
    private TableView<?> theTable;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtTotalAmount;

    @FXML
    void RadioPaid(ActionEvent event) {

    }

    @FXML
    void RadioPending(ActionEvent event) {

    }

    @FXML
    void doBillHistory(ActionEvent event) {

    }

    @FXML
    void doExport(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	con = billGenerator.BillConnector.doConnect(); 

}
}
