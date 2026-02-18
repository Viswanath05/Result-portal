package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	Login(Scanner s,Connection c) throws SQLException{
		System.out.print("User name:");
		String un = s.nextLine();
		System.out.print("Password:");
		String ps = s.nextLine();
		String com="select * from user";
		PreparedStatement p = c.prepareStatement(com);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			if(un.equals(rs.getString(1)) && ps.equals(rs.getString(2))) {
				System.out.println("\nLogin Successfull...");
				return;
			}

		}System.out.println("\nInvalid Username or password!!");
		System.exit(0);
	}
}
