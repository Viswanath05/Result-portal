package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sort {
	Sort(Connection c) throws SQLException{
		String com="select * from details order by percentage DESC";
		PreparedStatement p = c.prepareStatement(com);
		ResultSet rs = p.executeQuery();
		System.out.println("\nS.no\t\tId\t\tName\t\tDepartment\tMark\t\tGrade\t\tresult");
		int count=1;
		
		while(rs.next()) {
			System.out.println(count+"\t\t"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4)
			+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6));
			count ++;	
			}
	}
}
