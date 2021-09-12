package summer21jdbc;

import java.sql.*;

public class JdbcPrepareStatement02 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");

		Statement st = con.createStatement();
		
		//Let us do UPDATE SET more dynamic
		String q1 = "UPDATE students SET std_grade = ? WHERE std_id = ?";
		PreparedStatement pst = con.prepareStatement(q1);
		
//		pst.setInt(1, 12); //1 means first question mark in the query
//		pst.setInt(2, 101); //2 means second question mark in the query
		
		pst.setInt(1, 11);
		pst.setInt(2, 102);
		
		pst.executeUpdate();
		
		con.close();
		st.close();
		pst.close();
		
		
		
		
	}	
		
}
