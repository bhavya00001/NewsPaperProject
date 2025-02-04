package billGenerator;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.Period;
import javafx.scene.control.Label;

public class BillGenViewController {
	
	Connection con;
	PreparedStatement pst;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker billUptoDate;

    @FXML
    private ComboBox<String> comboMobile;

    @FXML
    private DatePicker lastDate;

    @FXML
    private TextField txtMissingDays;

    @FXML
    private TextField txtPapers;

    @FXML
    private TextField txtPrices;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtTotalPrice;

    @FXML
    private TextField txtname;
    @FXML
    private Label lblOut;

    @FXML
    void DoLastBillingDate(ActionEvent event) {

    }

    @FXML
    void doCalBill(ActionEvent event) {
    	
    	LocalDate ld1 = lastDate.getValue();
    	java.sql.Date dt = java.sql.Date.valueOf(ld1);
    	
    	LocalDate ld2 = billUptoDate.getValue();
    	java.sql.Date dt2 = java.sql.Date.valueOf(ld2);
    	
    	Period p=Period.between(ld1, ld2);
    	int diff = p.getDays();
    	int missing = Integer.valueOf(txtMissingDays.getText());
    	
    	float bill = sum*diff-(missing*sum);
    	txtTotal.setText(String.valueOf(bill));
    	
    	 try {
			pst = con.prepareStatement("insert into billgenerator values(?,?,?,?,?");
		    pst.setString(1,comboMobile.getSelectionModel().getSelectedItem());
		   pst.setDate(2, dt);
		   pst.setDate(3, dt2);
		   pst.setFloat(4, bill);
		   pst.setInt(5, 0);
		   pst.executeUpdate();
		   lblOut.setText("Bill Generated.......");
    	 } catch (SQLException e) {
			e.printStackTrace();
		}
    	 
    }
    float sum =0;
    @FXML
    void doFetchCustomerData(ActionEvent event) throws SQLException {
        pst = con.prepareStatement("select * from customermanager where cmobile=?");
        String mobo = comboMobile.getSelectionModel().getSelectedItem();
        pst.setString(1, mobo);
        ResultSet table = pst.executeQuery();
        while(table.next()) {
        	txtname.setText(table.getString("cname"));
        	String sel = table.getString("selprices");
        	 txtPapers.setText(table.getString("selpapers"));
        	 txtPrices.setText(sel);
        	 
        	 String ary[] = sel.split(",");
        	 for(String s:ary) {
        		 float num = Float.parseFloat(s);
        		 sum = sum + num;
        	 }
        	 txtTotalPrice.setText(String.valueOf(sum));
//        	 java.sql.Date dt = table.getDate("datefrom");
//        	 LocalDate ld = dt.toLocalDate();
        	 
        
        }
       
        
      
        
       
    }
    void doFillMobiles() throws SQLException {
    	pst = con.prepareStatement("select distinct cmobile from customermanager");
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
      	  comboMobile.getItems().add(rs.getString("cmobile"));  
        }
      }

    

    @FXML
    void initialize() throws SQLException {
      con = BillConnector.doConnect();
      doFillMobiles();
}
}
