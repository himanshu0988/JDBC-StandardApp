package in.JDBC.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBC.util.jdbcUtil;

public class Insert {

	public static void main(String[] args) {
	
		Connection connection=null;
		PreparedStatement pstm=null;
		
		try {
			connection=jdbcUtil.getConnection();
			String Query="Insert into studnet (sid,`sname`,sage)values(?,?,?)";
			pstm=connection.prepareStatement(Query);
			
			Scanner scan=new Scanner(System.in);
			
			System.out.println(" enter the id");
			int id=scan.nextInt();
			System.out.println("enter the name");
			String name=scan.next();
			System.out.println("enter the age");
			int age=scan.nextInt();
			
			
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			
			int row=pstm.executeUpdate();			
			
			System.out.println(" total row affected is +"+row);
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.clenUp(connection, pstm, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
