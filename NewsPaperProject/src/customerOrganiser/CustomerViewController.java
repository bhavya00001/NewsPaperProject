package customerOrganiser;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerViewController {
	
    Connection con;
    PreparedStatement pst;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboArea;

    @FXML
    private ListView<String> ListPaperAvailable;

    @FXML
    private ListView<String> ListPriceAvailable;

    @FXML
    private ListView<String> ListSelPapers;

    @FXML
    private ListView<String> ListSelPrice;

    @FXML
    private Label lblOut;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtHawkerName;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    void DeleteDblClickPapers(MouseEvent event) {
      if(event.getClickCount()==2) {
    	  int selectedIndex = ListSelPapers.getSelectionModel().getSelectedIndex();
    	  ListSelPrice.getSelectionModel().clearSelection();
    	 ListSelPrice.getSelectionModel().select(selectedIndex);
    	  ListSelPapers.getItems().remove(selectedIndex);
    	  ListSelPrice.getItems().remove(selectedIndex);
      }
    }

    @FXML
    void OndblClickPapers(MouseEvent event) {
    	if(event.getClickCount()==1) {
   		 int selectedIndex = ListPaperAvailable.getSelectionModel().getSelectedIndex();
   		ListPriceAvailable.getSelectionModel().clearSelection();
   		ListPriceAvailable.getSelectionModel().select(selectedIndex);
    	}
    	
//    	ArrayList<String> Array = new ArrayList<String>(Arrays.asList(selectedItem));
//        if(Selected)
    	
    	  if(event.getClickCount()==2) {
         	 String selectedItem = ListPaperAvailable.getSelectionModel().getSelectedItem();
             String selectedPrice = ListPriceAvailable.getSelectionModel().getSelectedItem();
             
             ListSelPapers.getItems().add(selectedItem);
             ListSelPrice.getItems().add(selectedPrice);
    	  }
    }
    private LocalDate currDate;
    @FXML
    void doFetch(ActionEvent event) throws SQLException {
    	 ListSelPapers.getItems().clear();
         ListSelPrice.getItems().clear();
    	ObservableList <String> sel=ListSelPapers.getItems();
        ObservableList <String> selPr=ListSelPrice.getItems();
    	for(String string:sel) {
    	    selPapers+=string+",";
    	    if(selPapers.endsWith(","))
    	    	selPapers= selPapers.substring(0, selPapers.length()-1);
    	}
    	for(String str:selPr) {
    	    selPrices+=str+",";
    	    if(selPrices.endsWith(",")) {
    	    	selPrices = selPrices.substring(0, selPrices.length()-1);
    	    }
    	}
    	
    	pst = con.prepareStatement("Select * from customermanager where cmobile=?");
    	pst.setString(1,txtMobile.getText() );
    	
    ResultSet table = pst.executeQuery();
    while(table.next()) {
    	 txtName.setText(table.getString("cname"));
    	 txtEmail.setText(table.getString("cemail"));
//    	 ListSelPapers
    	 String a=table.getString("carea");
    	 txtCustomerAddress.setText(table.getString("caddress"));
    	 txtHawkerName.setText(table.getString("chawker"));
//    	 txtHawkerName.setText(tabl);
    	 ComboArea.getSelectionModel().select(a);
    	
    	 java.sql.Date dt =table.getDate("dos");
    	 LocalDate ld = dt.toLocalDate(); 
    	 txtDate.setValue(ld);
    	 
    	 String ary[] = selPapers.split(",");
    	 for(String s:ary) {
    		 ListSelPapers.getItems().add(s);
    	 }
    	 String ary2[] = selPrices.split(",");

    	 for(String s:ary2) {
    		 ListSelPrice.getItems().add(s);
    	 }
    	 lblOut.setText("Data Fetched....");
 //   	 LocalDate ld = doj.getValue();
//       java.sql.Date dt = java.sql.Date.valueOf(ld);
      }
    }
    @FXML
    void comboArea(ActionEvent event) throws Exception{
    	  
    	  String allo = ComboArea.getSelectionModel().getSelectedItem();
    	  System.out.println(allo);
    	  pst = con.prepareStatement("select hname from hawkermanager where alloaddress like ?");
          pst.setString(1,"%"+allo+"%");
          ResultSet rs = pst.executeQuery();
          while (rs.next()) {
              String name = rs.getString("hname");
              txtHawkerName.setText(name);
//              // Process or display the retrieved hname value as needed
              System.out.println("hname: " + name);
          }
    }
    
    String selPapers="";
    String selPrices="";
    @FXML
    void doSubscribe(ActionEvent event) throws SQLException {
    	ObservableList <String> sel=ListSelPapers.getItems();
        ObservableList <String> selPrice=ListSelPrice.getItems();
    	for(String string:sel)
    	    selPapers+=string+",";
    	for(String string:selPrice)
    	    selPrices+=string+",";	
//    	System.out.println(selPapers+selPrices);
    	 currDate = LocalDate.now();
      pst = con.prepareStatement("insert into customermanager values(?,?,?,?,?,?,?,?,?)");
      pst.setString(1, txtMobile.getText());
      pst.setString(2, txtName.getText());
      pst.setString(3, selPapers);
      pst.setString(4, selPrices);
      pst.setString(5, ComboArea.getSelectionModel().getSelectedItem());
      pst.setString(6, txtHawkerName.getText() );
      pst.setString(7, txtEmail.getText());
      pst.setString(8, txtCustomerAddress.getText());
      pst.setDate(9, java.sql.Date.valueOf(currDate));
      pst.executeUpdate();
      
      
      
      lblOut.setText("Information Saved.....");
    }

    @FXML
    void doUnsubscribe(ActionEvent event) throws SQLException {
      pst= con.prepareStatement("delete from customermanager where cmobile=? ");
      pst.setString(1, txtMobile.getText());
      pst.executeUpdate();
      lblOut.setText("Customer out.....");
    }

    @FXML 
    void doUpdate(ActionEvent event) throws SQLException {
    	ObservableList <String> sel=ListSelPapers.getItems();
        ObservableList <String> selPrice=ListSelPrice.getItems();
    	for(String string:sel) 
    	    selPapers+=string+",";
    	  
    	for(String string:selPrice)
    	    selPrices+=string+",";	
    	ListSelPapers.getItems().clear();
    	ListSelPrice.getItems().clear();
    	
    	if(selPapers.endsWith(",")) {
    		selPapers = selPapers.substring(0, selPapers.length()-1);
    	}
    	if(selPrices.endsWith(",")) {
    	    selPrices = selPrices.substring(0,selPrices.length()-1);
    	}
    		    	
//    	System.out.println(selPapers+selPrices);
    	 currDate = LocalDate.now();
      pst = con.prepareStatement("update customermanager set cname=?, selpapers=?, selprices=?,carea=?,chawker=?,cemail=?,caddress=?,dos=? where cmobile=?");
     
      pst.setString(1, txtName.getText());
      pst.setString(2, selPapers);
      pst.setString(3, selPrices);
      pst.setString(4, ComboArea.getSelectionModel().getSelectedItem());
      pst.setString(5, txtHawkerName.getText() );
      pst.setString(6, txtEmail.getText());
      pst.setString(7, txtCustomerAddress.getText());
      pst.setDate(8, java.sql.Date.valueOf(currDate));
      pst.setString(9, txtMobile.getText());
      pst.executeUpdate();
      
      
      
      lblOut.setText("Information Updated.....");
          }
    ArrayList<String> Areas;
    @FXML
    void initialize() throws Exception {
        con = CustomerConnector.doConnect();
        pst = con.prepareStatement("select * from newspaper");
    	ResultSet table = pst.executeQuery();
    	while(table.next()) {
    		ListPaperAvailable.getItems().add(table.getString("pname"));
    		ListPriceAvailable.getItems().add(table.getString(String.valueOf("pprice")));
    	}
    	
    	// Adding areas hawker master
    	Areas = new ArrayList<String>(Arrays.asList("Ramji Road","Sita Street","Krishna Lane","Radha Drive","Gandhi Alley","ToonPur Lane","Maharaja Path","Sidhi Street","Ridhi Route","Amrik singh Cresent"));
    	ComboArea.getItems().addAll(Areas);
    }

}

