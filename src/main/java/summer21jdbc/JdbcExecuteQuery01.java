package summer21jdbc;

//Password: Oradoc_db1

//1.Step:Having phone means "importing SQL Package"
import java.sql.*;

public class JdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.Step: Registering gsm operator means "registering to our driver(Oracle Driver)"
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step:Call your friend means "establish connection with the database"
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "nukte", "Oradoc_db1");
		
		//4.Step: Create some sentences to tell to your friend means "Create Statement"
		Statement st = con.createStatement();
		
		//5.Step:Start to talk with your friend means "Create SQL Query and execute it"
		//1. Example
		String q1 = "SELECT * FROM my_companies";
		ResultSet r1 = st.executeQuery(q1);
		
		//6.Step: Do some actions according to the result
		while(r1.next()) {
			System.out.println(r1.getInt(1) + " - " + r1.getString(2));
		}
		System.out.println("=====================");
		//2.Example
		String q2 = "SELECT * FROM my_companies WHERE company_id < 102";
		ResultSet r2 = st.executeQuery(q2);
		while (r2.next()) {
			System.out.println(r2.getString("company_name"));
		}
		System.out.println("=====================");
		
		//3.Example: Select third company_id and company_name after sorting descending
		String q3 = "SELECT company_id, company_name "
				+ "FROM my_companies "
				+ "ORDER BY company_id DESC "
				+ "OFFSET 2 ROW "
				+ "FETCH NEXT 1 ROW ONLY";
		ResultSet r3 = st.executeQuery(q3);
		while (r3.next()) {
			System.out.println(r3.getInt("company_id")+ "-->"+ r3.getString("company_name"));
		}
		
		System.out.println("=====================");
		//4.Example: Select the company whose id is the second lowest
		String q4 = "select company_id, company_name "
				+ "from my_companies "
				+ "order by company_id asc "
				+ "offset 1 row "
				+ "fetch next 1 row only";
		ResultSet r4 = st.executeQuery(q4);
		while (r4.next()) {
			System.out.println(r4.getInt("company_id")+ "-->"+ r4.getString("company_name"));
		}
		 
		
		//7.Step: End the call means "Close the DB Connection"
		con.close();
		st.close();
		r1.close();
		r2.close();
	}
}