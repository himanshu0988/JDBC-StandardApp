package in.JDBC.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBC.util.jdbcUtil;

public class Delete {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement pstm=null;
		Scanner scan=new Scanner(System.in);
		
		try {
			connection=jdbcUtil.getConnection();
			
			if(connection!=null)
			{
				String SqlQuery="Delete from studnet where sid= ?";
				pstm=connection.prepareStatement(SqlQuery);
				
			}
			if(pstm!=null)
			{
				
				System.out.println("Enter the Sid ");
				int id=scan.nextInt();
				
				pstm.setInt(1, id);
				
				int rowa=pstm.executeUpdate();
				
				System.out.println(" total row affected is "+rowa);
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				jdbcUtil.clenUp(connection, pstm, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scan.close();
		}
		
		

	}

}
