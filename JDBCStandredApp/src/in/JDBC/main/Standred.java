package in.JDBC.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.JDBC.util.jdbcUtil;

public class Standred {
	
//@author-Himanshu
	
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		
		try {
			connection=jdbcUtil.getConnection();
			
			if(connection !=null)
			{
				statement =connection.createStatement();
			}
			if(statement !=null)
			{
				resultset=statement.executeQuery("select * from studnet");
			}
			if(resultset !=null)
			{
				System.out.printf("sid ,sname,sage");
				System.out.println();
				
				while(resultset.next())
				{
					System.out.printf("%2d%15s%12d",resultset.getInt(1),resultset.getString(2),resultset.getInt(3));
					System.out.println();
				}
			}
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				jdbcUtil.clenUp(connection, statement, resultset);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
