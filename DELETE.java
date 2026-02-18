package Student;

import java.sql.*;
import java.util.Scanner;

public class DELETE {
	DELETE(Scanner s,Connection c) throws SQLException{
		System.out.print("Enter id to delete:");
		int d=s.nextInt();
		String com="delete from details where id=?";
		String com1="delete from Stu_log where pass=?";
		PreparedStatement p = c.prepareStatement(com);
		p.setInt(1, d);
		p.execute();
		PreparedStatement p1 = c.prepareStatement(com1);
		p1.setInt(1, d);
		p1.execute();
		System.out.println("Deleted Successfully...");
		}
	}

