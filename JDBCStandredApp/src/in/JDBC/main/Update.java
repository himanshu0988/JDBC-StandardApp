package in.JDBC.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.JDBC.util.jdbcUtil;

public class Update {

	public static void main(String[] args) throws SQLException, IOException {
		Connection connection=null;
		PreparedStatement pstm=null;
		Scanner scan=new Scanner(System.in);
		
		 connection=jdbcUtil.getConnection();
		 
		 if(connection!=null)
		 {
			 String SqlQuery="update studnet set sage= ? where sid= ?";
			 pstm=connection.prepareStatement(SqlQuery);
		 }
		 if(pstm!=null)
		 {
			 
			 System.out.println(" please enter the Student Age");
			 int age=scan.nextInt();
			 
			 System.out.println("please enter the sid");
			 int id=scan.nextInt();
			 
			 pstm.setInt(1,age);
			 pstm.setInt(2, id);
			 
			 
			 int rowAffect=pstm.executeUpdate();
			 
			 System.out.println(" total row Affected is  "+rowAffect);
		 }
		 jdbcUtil.clenUp(connection, pstm, null);
		 scan.close();
	}

}
