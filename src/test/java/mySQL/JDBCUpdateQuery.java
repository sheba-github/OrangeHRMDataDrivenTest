package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateQuery {

	public static void main(String[] args) throws SQLException {
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciat","root","Welcome$123");
		    //Create statement or query
		    String updateQuery = "UPDATE REGISTERDATA SET TELEPHONE ='1234567895' WHERE LASTNAME ='THOMAS'";
		    Statement stmt = con.createStatement();
		    //Execute the Statement
		    stmt.execute(updateQuery);		       
		    //Close the connection
		    con.close();
		    System.out.println("Query executed..");

	}

}
