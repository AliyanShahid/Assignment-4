package application;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class signupController {
	
	 @FXML
	    private Button register_btn;

	    @FXML
	    private PasswordField sigin_pass;

	    @FXML
	    private TextField signin_cnic;

	    @FXML
	    private TextField signuser_name;

	    @FXML
	    void register_button(ActionEvent event) throws SQLException {
	    	Window owner = register_btn.getScene().getWindow();
	    	 System.out.println(signuser_name.getText());
	         System.out.println(sigin_pass.getText());
	         System.out.println(signin_cnic.getText());
	         if (signuser_name.getText().isEmpty()) {
	           showAlert(Alert.AlertType.ERROR, owner, "Error!",
	                 "Please enter your name");
	             return;
	         }
	         
	         if (signin_cnic.getText().isEmpty()) {
	             showAlert(Alert.AlertType.ERROR, owner, "Error!",
	                 "Please enter your Cnic Number");
	             return;
	         }
	         if (sigin_pass.getText().isEmpty()) {
	             showAlert(Alert.AlertType.ERROR, owner, "Error!",
	                 "Please enter a password");
	             return;
	         }
	         
	         String fullName = signuser_name.getText();
	         String emailId = signin_cnic.getText();
	         String password =sigin_pass.getText();

	         DButils jdbcDao = new DButils();
	         jdbcDao.insertRecord(fullName, emailId, password);
	    	
	         
	         showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
	                 "Welcome " + signuser_name.getText());
	    	
	    	//Main m1 = new Main();
	   	  //m1.changeScene2("Sample.fxml");
	    }

		private void showAlert(AlertType error, Window owner, String string, String string2) {
			// TODO Auto-generated method stub
			 Alert alert = new Alert(error);
		        alert.setTitle(string);
		        alert.setHeaderText(null);
		        alert.setContentText(string2);
		        alert.initOwner(owner);
		        alert.show();
			
		}

}
