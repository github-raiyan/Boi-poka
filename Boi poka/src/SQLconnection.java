import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SQLconnection {
static Connection conn;
	
	public static Connection ConnecrOb() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boipoka2", "root", "");
			
			//JOptionPane.showMessageDialog(null, "Success");
			return conn;
			
		}
		 catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed");
			return null;
		}
	}
}
