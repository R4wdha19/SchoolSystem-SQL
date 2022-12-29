package DataBaseConnectivity;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class StudentsTable {

	public static void CreateMyStudentTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		String tableCreationsql = " create table  Students ( id integer PRIMARY KEY,fname VARCHAR (8),birthdate date,lname VARCHAR (8))";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();
//			st.executeUpdate(tableCreationsql);
			// Executing query
			int Executing = st.executeUpdate(tableCreationsql);
			if (Executing >= 0) {
				System.out.println("Created Successfully : " + tableCreationsql);
			} else {
				System.out.println("Creation Is Failed");
			}

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (

		Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	}

}