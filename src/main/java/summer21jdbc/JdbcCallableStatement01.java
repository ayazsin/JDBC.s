package summer21jdbc;

import java.sql.*;

public class JdbcCallableStatement01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");

		Statement st = con.createStatement();
		
		//How to call a Function from DB why using JDBC
		
		//Create a functionwhich uses 2 integer parameters and returns the sum of the integers
//		String q1 = "CREATE OR REPLACE FUNCTION additionf(a NUMBER, b NUMBER) "
//				+ "RETURN NUMBER IS "
//				+ "BEGIN return a+b; "
//				+ "END;";
//		boolean isFuncCreated = st.execute(q1);
//		System.out.println("Was the addition fuction created? " + !isFuncCreated);
//		
//		CallableStatement cst = con.prepareCall("{? = call additionf(?, ?)}");
//		
//		cst.registerOutParameter(1, Types.INTEGER);
//		cst.setInt(2, 15);
//		cst.setInt(3, 17);
//		
//		cst.execute();
//		System.out.println("The result: " +cst.getInt(1));//12
		
		//Create a function which returns the name of a student 
		//from students table when you enter student id
//		String q2 = "create or replace function getNamef(id NUMBER) return varchar2 is "
//				+ "s_name students.std_name%TYPE; "
//				+ "s_id students.std_id%type; "
//				+ "begin "
//				+ "select std_name into s_name from students where std_id = id; "
//				+ "return s_name;"
//				+ " end;";
//		
//		System.out.println(!st.execute(q2));
		
		//Call the getNamef()
		CallableStatement cst = con.prepareCall("{? = call getNamef(?)}");
		cst.registerOutParameter(1, Types.VARCHAR);
		cst.setInt(2, 102);
		cst.execute();
		
		System.out.println(cst.getString(1));
		
		con.close();
		st.close();
		cst.close();
		
	}

}
