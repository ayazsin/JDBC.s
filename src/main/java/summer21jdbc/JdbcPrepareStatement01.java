package summer21jdbc;

import java.sql.*;

public class JdbcPrepareStatement01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");

		Statement st = con.createStatement();
		//Let us do insertion operation more dynamic
		
		String q1 = "INSERT INTO students VALUES(?,?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(q1);
		
//		pst.setInt(1,101);
//		pst.setString(2, "Ali Can");
//		pst.setString(3, "11-Aug-2005");
//		pst.setInt(4, 11);
//		pst.setInt(5, 14);
//		
//		pst.executeUpdate();
		
//		pst.setInt(1,102);
//		pst.setString(2, "Veli Han");
//		pst.setString(3, "11-Aug-2007");
//		pst.setInt(4, 9);
//		pst.setInt(5, 14);
//		
//		pst.executeUpdate();
		
		String q2 = "SELECT * FROM students";
		ResultSet r2 = st.executeQuery(q2);
		while(r2.next()) {
			System.out.println(r2.getInt(1) + " - " + r2.getString(2) + " - " + r2.getString(3) + " - " + r2.getString(4) + " - " + r2.getString(5));
		}
		
		con.close();
		st.close();
		pst.close();
		r2.close();
		
	}

}
