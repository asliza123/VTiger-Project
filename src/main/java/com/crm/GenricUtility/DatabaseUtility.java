package com.crm.GenricUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	static Driver dbDriver;
	static Connection con;
	static ResultSet set;

	/**
	 * used to establish database connection
	 * @throws SQLException
	 */

	public void connectDB() throws SQLException 
	{
		dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		con=DriverManager.getConnection(IConstants.JDBC_Url, IConstants.JDBC_username, IConstants.JDBC_Password);
	}

	/**
	 * used to close the connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException 
	{
		con.close();
	}
	
	/**
	 * used to execute Query without select statements
	 * @param Query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String Query) throws SQLException 
	{
		set=con.createStatement().executeQuery(Query);
		return set;
	}
	
	/**
	 * used to execute query with select statement
	 * @param Query
	 * @return
	 * @throws SQLException 
	 */

	public int executeUpdate(String Query) throws SQLException 
	{
		int rowupdate=con.createStatement().executeUpdate(Query);	
		return rowupdate;
	}
}
	
