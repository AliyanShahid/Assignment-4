package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Party {
	 public void insertRecord_party(String partyname, String totalmember, String leader) throws SQLException
	    {

	        // Step 1: Establishing a Connection and 
	        // try-with-resource statement will auto close the connection.
	    	 try 
	    	           {
	    		 Class.forName("com.mysql.cj.jdbc.Driver");
	 			System.out.println("\nDriver Loaded Successfully!");

	 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","Aliyan_123456");
	    	         
	 			String sql = "INSERT into party (party_name,totalmembers,leader) VALUES (?, ?, ?)";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				
				
	 			
	 			preparedStatement.setString(1,partyname);
	 		   preparedStatement.setString(2, leader);     
	 			preparedStatement.setString(3, totalmember);
	    	         

	    	            System.out.println(preparedStatement);
	    	            // Step 3: Execute the query or update query
	    	            preparedStatement.executeUpdate();
	    	        } catch (SQLException e) {
	    	            // print SQL exception information
	    	        	e.printStackTrace();
	    	        } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	    }

	
	    
}
