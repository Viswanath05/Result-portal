package Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner (System.in);
		Add_stu add = new Add_stu();
		String url = "jdbc:mysql://localhost:3306/Student";
		String user = "root";
		String pass = "Viswa@2004";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(url, user, pass);
		System.out.println("********Welcome To Student Database********\n");
		System.out.print("Select Login option:\n\t1.Admin Login\n\t2.Student Login\nSelect Option:");
		int ch = s.nextInt();
		s.nextLine();
		switch (ch) {
		case 1:
			new Login(s,c);
			break;
		case 2:
			new Stu_log(s,c);
			System.exit(0);
		default:
			System.out.println("Unauthorized Access");
			System.exit(0);
		}
		while(true) {
			System.out.print("\n\n1.Add Student details"
					+ "\n2.View Student details"
					+ "\n3.Search Deatails by id"
					+ "\n4.Find topper"
					+ "\n5.Remove student by Id"
					+ "\n6.Sort student by marks"
					+ "\n7.Exit\nEnter your choice:");
			int choice = s.nextInt();
			switch(choice) {
			case 1:
				add.get(s,c);
				break;
			case 2:
				new View(c);
				break;
			case 3:
				new Search(s,c);
				break;
			case 4:
				new Topper(s,c);
				break;
			case 5:
				new DELETE(s,c);
				break;
			case 6:
				new Sort(c);
				break;
			case 7:
				System.out.println("Exiting....");
				System.exit(0);
			default:
				System.out.println("Enter correct option !!!");
				
			}
		}
	}

}

