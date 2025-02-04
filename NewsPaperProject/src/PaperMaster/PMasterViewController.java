package PaperMaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PMasterViewController {
	@FXML
    private Label lblout;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    
    @FXML
    private ComboBox<String> comboPaper;

    @FXML
    private TextField txtprice;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void doAvail(ActionEvent event) {
      float price = Float.parseFloat(txtprice.getText());
     try { 
      pst = con.prepareStatement("insert into newspaper(pname,pprice) values(?, ?)");
      pst.setString(1, comboPaper.getSelectionModel().getSelectedItem());
      pst.setFloat(2, price);
      pst.execute();
      lblout.setText("Paper Availed....");
     }
     catch(Exception exp) {
    	 System.out.println(exp);
     }
    }

    @FXML
    void doEdit(ActionEvent event) throws SQLException {
    	float price = Float.parseFloat(txtprice.getText());
       
		pst = con.prepareStatement("update newspaper set pprice=? where pname= ?");
		pst.setFloat(1, price);
		pst.setString(2, comboPaper.getSelectionModel().getSelectedItem());
		pst.executeUpdate();
		lblout.setText("Price Updated....");
    }
    
    @FXML
    void doSearch(ActionEvent event) throws SQLException { 
    	pst = con.prepareStatement("select * from newspaper where pname=?");
    	pst.setString(1,comboPaper.getSelectionModel().getSelectedItem());
    	ResultSet table=pst.executeQuery(); 
    	while(table.next()) {
        float pprice = table.getFloat("pprice");
        txtprice.setText(String.valueOf(pprice));
    	}
    }

    @FXML
    void doWithdraw(ActionEvent event) throws SQLException {
         pst = con.prepareStatement("delete from newspaper where pname=?");
         pst.setString(1, comboPaper.getSelectionModel().getSelectedItem());
         pst.executeUpdate();
         lblout.setText("Paper Deleted....");
    }
    
    void doFillPapers() throws SQLException {
    	pst = con.prepareStatement("select distinct pname from newspaper");
    	ResultSet table = pst.executeQuery();
    	while(table.next()) {
    		comboPaper.getItems().add(table.getString("pname"));
    	}
    }

    @FXML
    void initialize() throws SQLException {
    	lblout.setText("Welocome to our press....");
             con = PMasterConnector.doConnect();
             doFillPapers();
    }

}
