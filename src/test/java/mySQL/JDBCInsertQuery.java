package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertQuery {

	public static void main(String[] args) throws SQLException {
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciat","root","Welcome$123");
		    //Create statement or query
		    String insertQuery = "INSERT INTO REGISTERDATA VALUES('ADAM','THOMAS','REACHAUTOTEST7@GMAIL.COM','6788567854','TEST7','TEST7')";
		    Statement stmt = con.createStatement();
		    //Execute the Statement
		    stmt.execute(insertQuery);		       
		    //Close the connection
		    con.close();
		    System.out.println("Query executed..");

			}}

