package in.JDBC.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBC.util.jdbcUtil;

public class Select {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet resultset=null;
		Scanner scan=new Scanner(System.in);
		
		try {
			connection=jdbcUtil.getConnection();
			
			if(connection!=null)
			{
				String SqlQuery="Select * from studnet where sid= ?";
				pstm=connection.prepareStatement(SqlQuery);
				
			}
			if(pstm!=null)
			{
				
				System.out.println("Enter the Sid ");
				int id=scan.nextInt();
				
				pstm.setInt(1, id);
				resultset=pstm.executeQuery();
			}
			if(resultset!=null)
			{
				if(resultset.next())
				{
					System.out.println("sid\tsname\tsage");
					System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3));
				}
				else
				{
					System.out.println("id is not avilable in rc");
				}
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
	}}
	

