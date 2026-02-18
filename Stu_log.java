package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Stu_log {
	Stu_log(Scanner s,Connection c) throws SQLException{
		
		System.out.print("User name:");
		int un = s.nextInt();
		System.out.print("Password:");
		int ps = s.nextInt();
		String com="select * from Stu_log";
		PreparedStatement p = c.prepareStatement(com);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			if(un==rs.getInt(1) && ps==rs.getInt(2)) {
				System.out.println("\nLogin Successfull...");
				new Search(c,un);
				return;
			}
		}System.out.println("\nInvalid Username or password!!");
		System.exit(0);
	}

}
