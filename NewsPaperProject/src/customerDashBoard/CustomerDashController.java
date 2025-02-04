package customerDashBoard;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import HawkerTable.HawkerTableBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerDashController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private ComboBox<String> combopaper;

    @FXML
    private TableView<CustomerDashBean> thetable;

    @FXML
    void ExportTOExcel(ActionEvent event) {

    }
    
    @FXML
    void comboArea(ActionEvent event) {

    }

    @FXML
    void comboPaper(ActionEvent event) {

    }

    @FXML
    void doFetchAreas(ActionEvent event) {
    	TableColumn<CustomerDashBean, String> name = new TableColumn<CustomerDashBean, String>("Customer Name");
        name.setCellValueFactory(new PropertyValueFactory<>("cname"));
        TableColumn<CustomerDashBean, String> selPaper = new TableColumn<CustomerDashBean, String>("Selected papers");
        selPaper.setCellValueFactory(new PropertyValueFactory<>("selPapers"));
        
        thetable.getColumns().clear();
        thetable.getColumns().addAll(new ArrayList<>(Arrays.asList(name,selPaper)));
        thetable.setItems(FetchData());
    }
    ObservableList<CustomerDashBean> FetchData(){
    	ObservableList<CustomerDashBean>ary=FXCollections.observableArrayList();
    	try {
    		pst = con.prepareStatement("select * from customermanager where carea=?");
    		pst.setString(1,comboarea.getSelectionModel().getSelectedItem());
            
         	ResultSet table=pst.executeQuery();
         	while(table.next()) {
         		String name = table.getString("cname");
         		String selpaper = table.getString("selPapers");
         		CustomerDashBean ref = new CustomerDashBean(name,selpaper);
         		ary.add(ref);
         	}
    	}
        catch(Exception exp) {exp.printStackTrace();}
        	
        	
			return ary;
    	}
     

    @FXML
    void doFetchPapers(ActionEvent event) {
    	TableColumn<CustomerDashBean, String> name = new TableColumn<CustomerDashBean, String>("Customer Name");
        name.setCellValueFactory(new PropertyValueFactory<>("cname"));
        TableColumn<CustomerDashBean, String> mobile = new TableColumn<CustomerDashBean, String>("Mobile No.");
        mobile.setCellValueFactory(new PropertyValueFactory<>("cmobile"));
        TableColumn<CustomerDashBean, String> area = new TableColumn<CustomerDashBean, String>("Area ");
        area.setCellValueFactory(new PropertyValueFactory<>("carea"));
        TableColumn<CustomerDashBean, String> email = new TableColumn<CustomerDashBean, String>("Customer Email");
        email.setCellValueFactory(new PropertyValueFactory<>("cemail"));
        TableColumn<CustomerDashBean, String> address = new TableColumn<CustomerDashBean, String>("Address");
        address.setCellValueFactory(new PropertyValueFactory<>("caddress"));
        
        thetable.getColumns().clear();
        thetable.getColumns().addAll(new ArrayList<>(Arrays.asList(name, mobile, area,email,address)));
        thetable.setItems(FetchALLHawkers());
        }
        
        
        ObservableList<CustomerDashBean> FetchALLHawkers(){
        	ObservableList<CustomerDashBean>ary=FXCollections.observableArrayList();
        	 try {
             	pst = con.prepareStatement("select * from customermanager where selpapers like ?");
             	pst.setString(1, "%"+combopaper.getSelectionModel().getSelectedItem()+"%");
             
             	ResultSet table=pst.executeQuery();
             	while(table.next()) {
             		String name= table.getString("cname");
             		String mobile=table.getString("cmobile");
             		String area = table.getString("carea");
             		String email = table.getString("cemail");
             		String address = table.getString("caddress");
             		
             		CustomerDashBean ref = new CustomerDashBean(name,mobile,area,email,address);
             		ary.add(ref);
             	}
             	
             	
             }
             catch(Exception exp) {exp.printStackTrace();}
        	
        	
			return ary;
    }

    @FXML
    void doPrint(ActionEvent event) {

    }
    Connection con;
    PreparedStatement pst;
    ArrayList<String> Areas;
    @FXML
    void initialize() throws SQLException {
        con = billGenerator.BillConnector.doConnect();
    	Areas = new ArrayList<String>(Arrays.asList("Ramji Road","Sita Street","Krishna Lane","Radha Drive","Gandhi Alley","ToonPur Lane","Maharaja Path","Sidhi Street","Ridhi Route","Amrik singh Cresent"));
    	comboarea.getItems().addAll(Areas);
    	 pst = con.prepareStatement("select * from newspaper");
    	ResultSet table = pst.executeQuery();
    	while(table.next()) {
    		combopaper.getItems().add(table.getString(String.valueOf("pname")));
    	}
    }

}
