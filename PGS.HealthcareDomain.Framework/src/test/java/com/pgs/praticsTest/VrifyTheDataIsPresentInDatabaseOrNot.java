package com.pgs.praticsTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VrifyTheDataIsPresentInDatabaseOrNot {

	public static void main(String[] args) throws SQLException {

		Connection conn=null;

		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String Query="select * from project";
			ResultSet res = statement.executeQuery(Query);
			boolean flag=false;
			while(res.next())
			{
				String val=res.getString(4);
				if(val.equalsIgnoreCase("Project_Name"))
				{
					System.out.println("Project is created");
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				System.out.println("Project is not created");
			}

		}
		finally {
			conn.close();
		}

	}

}
