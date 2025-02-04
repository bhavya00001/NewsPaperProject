package billGenerator;

import java.sql.Connection;
import java.sql.DriverManager;

public class BillConnector {

	static Connection con;
	
	public static Connection doConnect()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/newspaperautomation","root","Bhavya2910#1");
//			database.root.passworbench
			if(con!=null)
			   System.out.println("Connected............");
			else
				System.out.println("error");
			}
			catch(Exception exp) {
				System.out.println(exp);
			}
			
			return con;
	}
	public static void main(String[] args) {
		doConnect();
	}

}
