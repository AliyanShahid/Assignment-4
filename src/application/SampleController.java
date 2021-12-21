package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class SampleController {
	  
	
	    public SampleController() {
	    	
	    }
	    @FXML
	    private Button button_login;

	    @FXML
	    private Button button_signup;

	    @FXML
	    private TextField tf_password;

	    @FXML
	    private TextField tf_useranme;
	    @FXML
	    private Label wrongLogin;

		//private String fxml;
	    
      //**************************************	Main Screen ***************************
	    
	    @FXML
	    private Button voter_id;

	    @FXML
	    private Button admin_btn;

	    @FXML
	    void button_admin(ActionEvent event) throws IOException {
	    	Main m1=new Main();
	    	m1.changeScene2("Admin_Pannel.fxml");

	    }
	    
	    
	    @FXML
	    void voter_login(ActionEvent event) throws IOException {
          Main m2=new Main();
          m2.changeScene("Sample.fxml");
	    }
	    
	    
	    
	    
	    //***********************************Admin Panel*******************************
	    
	    @FXML
	    void add_candidate(ActionEvent event) throws IOException {
	    	 Main m1=new Main();
             m1.changeScene2("Add_Candiddate.fxml");   
	    }

	    @FXML
	    void add_party(ActionEvent event) throws IOException {
              Main m=new Main();
              m.changeScene2("Add_party.fxml");
	    }

	    @FXML
	    void help(ActionEvent event) {

	    }

	    @FXML
	    void logout(ActionEvent event) throws IOException {
	    	 Main m=new Main();
             m.changeScene2("Main_Page.fxml");
	    }

	    @FXML
	    void result(ActionEvent event) {

	    }

	    @FXML
	    void voter_detail(ActionEvent event) throws IOException {
                Main m = new Main();
               m.changeScene("Search.fxml");
	    }
 
	    
      //*****************************************Add Party**************************
	    
	    

	    @FXML
	    private Button add_party;

	    @FXML
	    private Button back;

	    @FXML
	    private TextField leader_name;

	    @FXML
	    private TextField number_of_member;

	    @FXML
	    private TextField party_name;

	    @FXML
	    void btn_addparty(ActionEvent event) throws SQLException {
                      addparty();
	    }
	    public void addparty() throws SQLException {
	    	Window owner = add_party.getScene().getWindow();
	    	 System.out.println(party_name.getText());
	         System.out.println(leader_name.getText());
	         System.out.println(number_of_member.getText());
	         
	         if (party_name.getText().isEmpty()) {
		           showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter your name");
		             return;
		         }
		         
		         if (leader_name.getText().isEmpty()) {
		             showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter your Cnic Number");
		             return;
		         }
		         if (number_of_member.getText().isEmpty()) {
		             showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter a password");
		             return;
		         }
		         
		         String partyname = party_name.getText();
		         String leadername = leader_name.getText();
		         String numberofmember =number_of_member.getText();

		         Party jdbcDao = new Party();
		         jdbcDao.insertRecord_party(partyname,leadername,numberofmember);
		    	
		         
		         showAlert1(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
		                 "Welcome " + leader_name.getText());
		    	
		    	//Main m1 = new Main();
		   	  //m1.changeScene2("Sample.fxml");
		    }

			private void showAlert1(AlertType error, Window owner, String string, String string2) {
				// TODO Auto-generated method stub
				 Alert alert = new Alert(error);
			        alert.setTitle(string);
			        alert.setHeaderText(null);
			        alert.setContentText(string2);
			        alert.initOwner(owner);
			        alert.show();
				
			}



	    @FXML
	    void btn_back(ActionEvent event) throws IOException {
                  Main m1 = new Main();
                  m1.changeScene2("Admin_Pannel.fxml");
                		  }
	    

	    //********************************** Add Candidate *********************************
	    
	    
	    @FXML
	    private Button add_candidate;

	    @FXML
	    private Button back_addparty;

	    @FXML
	    private TextField candidate_name;

	    @FXML
	    private TextField party_candidate;

	    @FXML
	    private TextField candidate_voter_id;
	    @FXML
	    void btn_addcandidate(ActionEvent event) {

	    	Window owner = add_candidate.getScene().getWindow();
	    	 System.out.println(candidate_name.getText());
	         System.out.println(candidate_voter_id.getText());
	         System.out.println(party_candidate.getText());
	         
	         if (candidate_name.getText().isEmpty()) {
		           showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter Candidate Name ");
		             return;
		         }
		         
		         if (candidate_voter_id.getText().isEmpty()) {
		             showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter Candidate Voter Id");
		             return;
		         }
		         if (party_candidate.getText().isEmpty()) {
		             showAlert1(Alert.AlertType.ERROR, owner, "Error!",
		                 "Please enter Candidate Party");
		             return;
		         }
		       
		        
		         //jdbcDao.insertRecord_Candidate(partyname,leadername,numberofmember);
		    	
		         
		         showAlert1(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
		                 "Welcome " + leader_name.getText());
		    	
		    	//Main m1 = new Main();
		   	  //m1.changeScene2("Sample.fxml");
		    }

			@SuppressWarnings("unused")
			private void showAlert2(AlertType error, Window owner, String string, String string2) {
				// TODO Auto-generated method stub
				 Alert alert = new Alert(error);
			        alert.setTitle(string);
			        alert.setHeaderText(null);
			        alert.setContentText(string2);
			        alert.initOwner(owner);
			        alert.show();
				
	    }

	    @FXML
	    void btn_back_addcandidate(ActionEvent event) throws IOException {
	    	Main m1 = new Main();
            m1.changeScene2("Admin_Pannel.fxml");
	    }
	    
	    
	    //***************************search *************************************
	    Connection con;
	    PreparedStatement pst;
	    
	    @FXML
	    private Button search;

	    @FXML
	    private TextField search_cnic;

	    @FXML
	    private TextField search_name;
	    
	    @FXML
	    private TextField cnic_voter;
	    
	    public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","Aliyan_123456");
	        }
	        catch (ClassNotFoundException ex)
	        {
	                    ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	                     ex.printStackTrace();
	                }
	            }
	    @FXML
	    void btn_search(ActionEvent event) {
	    	 Connect();
	         String id = search_cnic.getText();
	         
	         try {
	             pst = con.prepareStatement("select full_name,cnic from user where cnic = ?");
	             pst.setString(1, id);
	             
	     ResultSet rs = pst.executeQuery();
	 
	            if(rs.next()==true)
	            {
	              
	                String name = rs.getString(1);
	                       
	                
	               search_name.setText(name);
	               cnic_voter.setText(id);
	            
	                
	                
	            }  
	          
	 
	         
	    }
	         catch (SQLException e) {
	             // print SQL exception information
	             printSQLException(e);
	         }
	 
	  
	    
	    
	
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
                             
public void initialize(URL url, ResourceBundle rb)
{
    Connect();
}    
@FXML
void btn_back_search(ActionEvent event) throws IOException {
	 Main m1 = new Main();
     m1.changeScene2("Admin_Pannel.fxml");
}
	    
	    
	    //*********************************************
	    
	    
	    
	    
	    @FXML
	   public void userlogin(ActionEvent event) throws SQLException, ClassNotFoundException {
            checklogin();
	    }
	private void checklogin() throws SQLException, ClassNotFoundException {
		
		Window owner = button_login.getScene().getWindow();

        System.out.println(tf_useranme.getText());
        System.out.println(tf_password.getText());
        
		if (tf_useranme.getText().isEmpty() && tf_password.getText().isEmpty())
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Enter Username And Password!!");
            alert.showAndWait();
			
		}
		
		
		if (tf_useranme.getText().isEmpty()) {
            showAlert1(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your User Name");
            return;
        }
        if (tf_password.getText().isEmpty()) {
            showAlert1(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }

        String emailId = tf_useranme.getText();
        String password = tf_password.getText();

       DButils jdbcDao = new DButils();
        boolean flag;
		
			flag = jdbcDao.validate(emailId, password);
		

        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
           try {
			login_success();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
		
	}
	
	public void login_success() throws IOException {
		 Main m1 = new Main();
         m1.changeScene2("logged-in.fxml");
	}
	public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
  @SuppressWarnings("unused")
private void showAlert(Alert.AlertType error, Window owner, String string, String string2) {
		//AlertType alertType;
	// TODO Auto-generated method stub
	  Alert alert = new Alert(error);
      alert.setTitle(string);
      alert.setHeaderText(null);
	alert.setContentText(string2);
      alert.initOwner(owner);
      alert.show();
	}
@FXML
 public void  signup(ActionEvent event) throws IOException {
	  Main m1 = new Main();
	  m1.changeScene2("sign-in.fxml");
    }
}
