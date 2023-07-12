package com.pgs.praticsTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			//Create a new instance
			Driver driverRef = new Driver();
			//Register into DriverManager class
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String Query="insert into project values('TY_PROJ_9099','Sid','29/06/2023','Tyss','Completed','6')";
			int result=statement.executeUpdate(Query);
			if(result==1)
			{
				System.out.println("Data is created");
			}
			else {
				System.out.println("Data is not created");
			}
		}
		finally {
			//conn.close();
		}




	}

}
