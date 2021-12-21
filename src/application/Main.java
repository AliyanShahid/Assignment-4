package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
			stg=primaryStage;
			stg.setTitle("Login");
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
		  stg.setScene(scene); 
		  stg.show(); 
		  stg.setTitle("Main Screen");
       
	}
      public void changeScene3(String fxml) throws IOException {
		
		
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
		  stg.setScene(scene); 
		  stg.show(); 
		  stg.setTitle("Main Screen");
       
	}
	
	  public void changeScene2(String fxml) throws IOException {
	  
	  
	  BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
	  Scene scene = new Scene(root,600,500);
	  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
	  stg.setScene(scene); 
	  stg.show(); 
	  stg.setTitle("Signin");
	  }
	 
	 
	  
	public static void main(String[] args) {
		
		
		launch(args);
	}
}
