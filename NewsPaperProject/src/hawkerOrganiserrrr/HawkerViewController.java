package hawkerOrganiserrrr;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HawkerViewController {
	Connection con;
	PreparedStatement pst;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboArea;

    @FXML
    private ComboBox<String> comboHawkerName;

    @FXML
    private Label lblAadhar;

    @FXML
    private Label lblPicPath;


    @FXML
    private Label lblout;

    @FXML
    private ImageView picAadhar;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAllocated;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtMobile;

    ArrayList<String> Areas;
    @FXML
    void combooAreass(ActionEvent event) {
//    	comboArea.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	String selectedArea = comboArea.getSelectionModel().getSelectedItem();
 	   String sarea= txtAllocated.getText();
 	   
 	   if(sarea.equals(""))
 		    sarea = sarea + selectedArea;
 	   else
 		    sarea = sarea + "," + selectedArea;
 	   
 	   txtAllocated.setText(sarea);
 	  
    }
    @FXML
    void comboAreas(MouseEvent event) {
       if(event.getClickCount()==1) {
    	   String selectedArea = comboArea.getSelectionModel().getSelectedItem();
     	   String sarea= txtAllocated.getText();
     	  txtAllocated.setText(sarea);
       }
    }

    @FXML
    void doEnroll(ActionEvent event) throws SQLException {
       String name = comboHawkerName.getSelectionModel().getSelectedItem();
       String mobile = txtMobile.getText();
       String address = txtAddress.getText();
       String picpath = lblPicPath.getText();
//       LocalDate ld = doj.getValue();
//       java.sql.Date dt = java.sql.Date.valueOf(ld);
       
       pst = con.prepareStatement("insert into hawkermanager values");
       pst.setString(1, name);
       pst.setString(2, mobile);
       pst.setString(3, address);
       pst.setString(4, picpath);
       pst.setDate(5, java.sql.Date.valueOf(currDate));
       pst.setString(6, txtAllocated.getText());
       pst.execute();
       lblout.setText("Information Saved....");
       
    }

    @FXML
    void doFetch(ActionEvent event) throws SQLException, FileNotFoundException {
         pst=con.prepareStatement("select * from hawkermanager where hname=?");
         pst.setString(1, comboHawkerName.getSelectionModel().getSelectedItem());
         
         ResultSet table = pst.executeQuery();
         while(table.next()) {
        	 txtMobile.setText(table.getString("nmobile"));
        	 txtAddress.setText(table.getString("naddress"));
        	 lblPicPath.setText(table.getString("npicpath"));
        	 txtDate.setValue(currDate);
        	 txtAllocated.setText(table.getString("alloaddress"));
        	 picAadhar.setImage(new Image(new FileInputStream(table.getString("npicpath"))));
         }
         lblout.setText("Hawker Data Fetched....");
    }

    @FXML
    void doFire(ActionEvent event) throws SQLException {
          currDate = LocalDate.now();

          pst = con.prepareStatement("delete from hawkermanager where hname=?");
          pst.setString(1, comboHawkerName.getSelectionModel().getSelectedItem());
          pst.executeUpdate();
          lblout.setText("Hawker fired.....");
    }

    
	@FXML
    void doNew(ActionEvent event) {
		comboHawkerName.setValue(null);
    	txtMobile.clear();
    	txtAddress.clear();
    	lblPicPath.setText("");;
    	txtAllocated.clear();
    	lblAadhar.setText("");
    	txtDate.setValue(null);
    	picAadhar.setImage(null);
    	
    }
    private LocalDate currDate;

    @FXML
    void doUpdate(ActionEvent event) throws SQLException {
        String name = comboHawkerName.getSelectionModel().getSelectedItem();
        String mobile = txtMobile.getText();
        String address = txtAddress.getText();
        String picpath = lblPicPath.getText();

        pst = con.prepareStatement("update hawkermanager set nmobile=?, naddress=?, npicpath=?, doj=?, alloaddress=? where hname=?");
        pst.setString(1, mobile);
        pst.setString(2, address);
        pst.setString(3, picpath);
        pst.setDate(4, java.sql.Date.valueOf(currDate));
        pst.setString(5, txtAllocated.getText());
        pst.setString(6, name);
        pst.executeUpdate();
        lblout.setText("Information Updated....");
    }
    void doFillHawkerName() throws SQLException {
    	pst = con.prepareStatement("select distinct hname from hawkermanager");
    	ResultSet table = pst.executeQuery();
    	while(table.next()) {
    		comboHawkerName.getItems().add(table.getString("hname"));
    	}
    	if(lblout.getText()=="Hawker fired.....") {
    		
    	}
    }
    private FileChooser filechooser;
    @FXML
    void doUploadPic(MouseEvent event) {
    	
//       filechooser.setInitialDirectory(new File("C:\\Users\\"))  2nd lineeee........
    	
       filechooser = new FileChooser();
       File selectedfile = filechooser.showOpenDialog(null);
       lblPicPath.setText(selectedfile.getPath());
       Image image = new Image(selectedfile.toURI().toString());
       picAadhar.setImage(image);
       
    }

    @FXML
    void initialize() throws SQLException {
    	// for the connection with mysql database
       con = HawkerConnector.doConnect();
       //setting label text.
       lblout.setText("Welcome to our press.....");
       
       //calling self created function to add hawker names in combo box.
       doFillHawkerName();
       
       //Adding Areas in combo box
       Areas = new ArrayList<String>(Arrays.asList("Ramji Road","Sita Street","Krishna Lane","Radha Drive","Gandhi Alley","ToonPur Lane","Maharaja Path","Sidhi Street","Ridhi Route","Amrik singh Cresent"));
       comboArea.getItems().addAll(Areas);
    }

}
