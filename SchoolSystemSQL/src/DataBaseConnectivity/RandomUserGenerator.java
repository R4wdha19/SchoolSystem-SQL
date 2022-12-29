package DataBaseConnectivity;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class RandomUserGenerator {

	public static void main(String[] args) {
		String user = "sa";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM Students";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");
				Date birthdate = rs.getDate("birthdate");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, birthdate);
				System.out.println(id + firstName + lastName + birthdate);
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

}
