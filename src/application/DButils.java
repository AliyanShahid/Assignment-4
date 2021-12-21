package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	
	// private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/voting?useSSL=false";
	  //  private static final String DATABASE_USERNAME = "root";
	    //private static final String DATABASE_PASSWORD = "Aliyan_123456";
	    //private static final String INSERT_QUERY = "INSERT INTO registration (full_name, email_id, password) VALUES (?, ?, ?)";
    
	    public void insertRecord(String fullName, String emailId, String password) throws SQLException
	    {

	        // Step 1: Establishing a Connection and 
	        // try-with-resource statement will auto close the connection.
	    	 try 
	    	           {
	    		 Class.forName("com.mysql.cj.jdbc.Driver");
	 			System.out.println("\nDriver Loaded Successfully!");

	 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","Aliyan_123456");
	    	         
	 			String sql = "INSERT into user (full_name,cnic,password) VALUES (?, ?, ?)";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				
				
	 			
	 			preparedStatement.setString(1, fullName);
	 		   preparedStatement.setString(3, password);     
	 			preparedStatement.setString(2, emailId);
	    	         

	    	            System.out.println(preparedStatement);
	    	            // Step 3: Execute the query or update query
	    	            preparedStatement.executeUpdate();
	    	        } catch (SQLException e) {
	    	            // print SQL exception information
	    	            printSQLException(e);
	    	        } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	    }
	    

	    public boolean validate(String emailId, String password) throws SQLException, ClassNotFoundException{
	    	
	    	 try 
	           {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\nDriver Loaded Successfully!");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","Aliyan_123456");
	         
		String sql = "SELECT * FROM user WHERE full_name = ? and password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, emailId);
		preparedStatement.setString(2, password);       

	            System.out.println(preparedStatement);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return true;
	            }
	           
	    }
	    	 catch (SQLException e) {
	             // print SQL exception information
	             printSQLException(e);
	         }
	         return false;
	    
	    
	    }
	    
	    
	   
	    
	    public static void printSQLException(SQLException ex) {

	    	for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
                                                                                                       
}
