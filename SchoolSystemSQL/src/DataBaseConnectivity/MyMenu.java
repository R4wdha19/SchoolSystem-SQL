package DataBaseConnectivity;

import java.util.Scanner;

public class MyMenu {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select An Option :");
		System.out.println("1 : Create Students Table ");
		System.out.println("2 : Create Subjects Table");
		System.out.println("3 : List Top 100 Students ");
		System.out.println("4 : List Top 50 Subjects");
		System.out.println("5 : Add a new Student");
		System.out.println("6 : Add a new Subject");
		System.out.println("7 : Load 1000000 student in Students Table");
		System.out.println("8 : Load 100000 subjects in Subjects Table");
		System.out.println("9 : Exit App");
		String option = sc.next();
		int op = Integer.parseInt(option);
		switch (op) {
		case 1:
			SubjectTable.CreateMyTable();
			break;
		case 2:
			StudentsTable.CreateMyStudentTable();
			break;
		case 3:

		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		}

	}
}