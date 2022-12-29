package DataBaseConnectivity;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SubjectTable {

	public static void CreateMyTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		String tableCreationsql = " create table  Subjects ( id integer PRIMARY KEY,title VARCHAR (8), "
				+ "pricePerStudent decimal, descr VARCHAR (250))";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

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
