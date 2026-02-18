package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search {
	Search(Scanner s,Connection c) throws SQLException{
			System.out.print("Enter id to search:");
			int i = s.nextInt();
			String com="select * from details";
			PreparedStatement p = c.prepareStatement(com);
			ResultSet rs = p.executeQuery();
			System.out.println("\nS.no\t\tId\t\tName\t\tDepartment\tMark\t\tGrade\t\tresult");
			int count=1;
			while(rs.next()) {
				if(i==rs.getInt(1)) {
					System.out.println(count+"\t\t"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4)
					+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6));
					count ++;
				}
	
			}if(count == 1) System.out.println("\nStudent id is Invalid!!");
		}
	Search(Connection c,int id) throws SQLException{
		String com="select * from details";
		PreparedStatement p = c.prepareStatement(com);
		ResultSet rs = p.executeQuery();
		System.out.println("\nS.no\t\tId\t\tName\t\tDepartment\tMark\t\tGrade\t\tresult");
		int count=1;
		while(rs.next()) {
			if(id==rs.getInt(1)) {
				System.out.println(count+"\t\t"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4)
				+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6));
				count ++;
			}

		}if(count == 1) System.out.println("\nStudent id is Invalid!!");
	}
	}


