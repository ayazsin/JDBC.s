package summer21jdbc;

import java.sql.*;

public class JavaExecute01 {
	
	/*
	 	1)In DDL(Data Definition Language: CREATE TABLE, DROP TABLE, ALTER TABLE), we use execute()
	 	2)execute() returns boolean
	 	3)When you use execute() in DDL, it returns false
	 	  When you use execute() in DQL, it returns ResultSet
	 	  When you use execute() in DQL, it returns true
	 	 
	 */

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		
		Statement st = con.createStatement();
		
		//0.Example: DROP students table
		String q0 = "DROP TABLE students";
		boolean isItDropped = st.execute(q0);
		System.out.println("Was the table dropped? " + !isItDropped);//true
		
		//1.Example: Create students table whose fields are id(NUMBER), name(VARCHAR2), dob(DATE)
		String q1 = "CREATE TABLE students(id NUMBER(3), name VARCHAR2(50), dob DATE)";
		boolean isItCreated = st.execute(q1);
		System.out.println("Was the table created? " + !isItCreated);//true
	
		//2.Example: Change the field names std_id, std_name, std_dob
		String q2 = "ALTER TABLE students RENAME COLUMN id TO std_id";
		boolean isIDAltered = st.execute(q2);
		System.out.println("Was the ID field altered? " + !isIDAltered);//true
		
		String q3 = "ALTER TABLE students RENAME COLUMN name TO std_name";
		boolean isNameAltered = st.execute(q3);
		System.out.println("Was the name field altered? " + !isNameAltered);//true
		
		//3.Example: Add 2 new fields std_grade(Number(2)), std_age(NUMBER(3)) into students table
		String q4 = "ALTER TABLE students ADD (std_grade NUMBER(2), std_age NUMBER(3))";
		boolean isFieldsAdded = st.execute(q4);
		System.out.println("Was the fields added? " + !isFieldsAdded);//true
		
		con.close();
		st.close();
	}

}
