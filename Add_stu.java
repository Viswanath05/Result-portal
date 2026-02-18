package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_stu {
	String  name;
	int id=100;
	String dpt;
	double percentage;
	void get(Scanner s,Connection c) throws SQLException {
		s.nextLine();
		System.out.print("Enter name: ");
		name = s.nextLine();
		
		System.out.print("Enter department: ");
		dpt = s.nextLine();
		System.out.print("Enter Mark:");
		int mark = s.nextInt();
		String grade;
		String result = "Pass";
		if(mark>=90) grade="O";
		else if(mark>=80 && mark <90) grade = "A+";
		else if(mark>=70 && mark<80) grade = "A";
		else if(mark>=60 && mark<70) grade = "B+";
		else if(mark>=50 && mark<60) grade = "B";
		else {
			grade = "F";
			result = "Fail";
		}
		String com="insert into details(id,name,department,percentage,grade,result) values (?,?,?,?,?,?)";
		PreparedStatement p = c.prepareStatement(com);
		p.setInt(1, id);
		p.setString(2, name);
		p.setString(3, dpt);
		p.setDouble(4, mark);
		p.setString(5,grade);
		p.setString(6,result);
		p.execute();
		String com1="insert into Stu_log(username,pass) values (?,?)";
		PreparedStatement p1 = c.prepareStatement(com1);
		p1.setInt(1, id);
		p1.setInt(2, id);
		p1.execute();
		this.id++;
		System.out.println("\nInserted Successfully...");
	}
}
