package HawkerTable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;


public class HawkerTableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<HawkerTableBean> thetable;

    @FXML
    void ExportToExcel(ActionEvent event) {

    }

    @FXML
    void PrintList(ActionEvent event) {

    }

    @FXML
    void doFetchRecords(ActionEvent event) {
      TableColumn<HawkerTableBean, String> name = new TableColumn<HawkerTableBean, String>("Hawker Name");
      name.setCellValueFactory(new PropertyValueFactory<>("hname"));
      
      TableColumn<HawkerTableBean, String> mobile = new TableColumn<HawkerTableBean, String>("Hawker Mobile No");
      mobile.setCellValueFactory(new PropertyValueFactory<>("nmobile"));
    	mobile.setMinWidth(50);
      

  	TableColumn<HawkerTableBean, String> alloarea=new TableColumn<HawkerTableBean, String>("Allocated Areas");//any thing
  	alloarea.setCellValueFactory(new PropertyValueFactory<>("alloaddress"));
  	alloarea.setMinWidth(50);
  	
  	TableColumn<HawkerTableBean, String> doj=new TableColumn<HawkerTableBean, String>("Date of joining");//any thing
  	doj.setCellValueFactory(new PropertyValueFactory<>("doj"));
  	doj.setMinWidth(50);
    
	
    thetable.getColumns().addAll(new ArrayList<>(Arrays.asList(name, mobile, alloarea, doj)));
    thetable.setItems(FetchALLHawkers());
    }
    
    Connection con;
    PreparedStatement pst;
    
    ObservableList<HawkerTableBean> FetchALLHawkers(){
    	ObservableList<HawkerTableBean>	ary=FXCollections.observableArrayList();
        try {
        	pst = con.prepareStatement("select * from hawkermanager");
        	ResultSet table=pst.executeQuery();
        	while(table.next()) {
        		String mobile=table.getString("nmobile");
        		String name= table.getString("hname");
        		String DOJ = String.valueOf(table.getDate("doj").toLocalDate());
        		String alloarea = table.getString("alloaddress");
        		
        		HawkerTableBean ref = new HawkerTableBean(name,mobile,alloarea,DOJ);
        		ary.add(ref);
        	}
        	
        	
        }
        catch(Exception exp) {exp.printStackTrace();}
        return ary;
    }
    @FXML
    void initialize() {
        con = billGenerator.BillConnector.doConnect();
        
    }

}
