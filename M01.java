package com.pack1;
import java.sql.*;

public class M01 {
	static Connection connection=null;
	static Statement statement=null;
	static ResultSet rs=null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)throws SQLException {
		
		
     String query=null;
     try {
    	 connection=DriverManager.getConnection("jdbc:mysql://localhost:8080:3306/magesh","root","");
    	 statement=connection.createStatement();
    	 /*String query="CREATE TABLE customers(custID int(11) NOT NULL,custName` varchar(50) NOT NULL,
    	 phone varchar(50) NOT NULL,
    	  address varchar(50) NOT NULL,
    	  city varchar(50) NOT NULL,
    	  state varchar(50) DEFAULT NULL,
    	  pincode varchar(15) DEFAULT NULL,
    	  country varchar(50) NOT NULL,
    	  PRIMARY KEY (custID)
    	 );*/
    	 
    	// String query="insert into customers values(101,'Ashath','9524164091','No:14, Kannaki Street','Chennai', 'Tamilnadu','600076','India'");



    	 //System.out.println(query);//
    	 
    	 statement.executeUpdate(query);
    	 query="select * from customers";
    	 rs=statement.executeQuery(query);
    	 while(rs.next())
    	 {
    		 System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+","+rs.getInt(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8));
     }
    	 }
	catch(SQLException e) {
		e.printStackTrace();
		
     }
	finally {
		rs.close();
		statement.close();
		connection.close();
	}
	System.out.println("Successfull");
}

	}



