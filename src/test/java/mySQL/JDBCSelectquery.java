package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Select Query
public class JDBCSelectquery {

	public static void main(String[] args) throws SQLException {
	//Creating a connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciat","root","Welcome$123");
    //Create statement or query
    String selectQuery = "Select firstname,lastname,email,telephone,password,passwordConfirm from RegisterData";
    Statement stmt = con.createStatement();
    //Execute the Statement
    ResultSet rs =stmt.executeQuery(selectQuery);
    while (rs.next()==true)
    	    {System.out.println(rs.getString("firstname")+" ");
    	    System.out.println(rs.getString("Lastname")+" ");
    	    System.out.println(rs.getString("Email")+" ");
    	    System.out.println(rs.getString("Telephone")+" ");
    	    System.out.println(rs.getString("Password")+" ");
    	    System.out.println(rs.getString("PasswordConfirm")+" ");
    	    System.out.println();
    	   }
    
    //Close the connection
    con.close();
    System.out.println("Query executed..");

	}

}
