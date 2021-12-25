package application;

import java.io.IOException;

//import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClinicHandler {

	@FXML
	Button login;

	@FXML
	Button Re_login;
	
	@FXML
	Button Home;
	
	@FXML
	TextArea feedback;

	@FXML
	Button Submit;
	
	DBHandler db=new DBHandler();
	
	@FXML
	private Text Prompt=new Text();
	
	@FXML
	Label prompt = new Label();
	
	@FXML
	TextField  user_n = new TextField();
	
	@FXML
	TextField pass_w = new TextField();
	
	@FXML
	TextField  appointment_id = new TextField();
	
	@FXML
	TextField patient_id = new TextField();


/*	@FXML
	TextField InvDisp= new TextField();
*/
	//hello from zainab
	String str1 = "a";
	String str2 = "a";
	String str3 = "1";
	String str4 = "2";
	
	
	private static Clinic clinic;

	public ClinicHandler() {
		clinic = clinic.getInstance();
	}
    @FXML
    private void LogIn() throws IOException {

        db.Intialize();
    	String username = user_n.getText();
        String password = pass_w.getText();
        if (username.equals(str1) && password.equals(str2)) {
    		Stage stage = (Stage) login.getScene().getWindow();
   	     
    	    stage.close();
    	    
    	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
    	     getResource("Main_Menu.fxml")));
    		 Stage primaryStage1 = new Stage();
    		 primaryStage1.setScene(quizScene);
    		 primaryStage1.show();
        }
        
        else {
    		Stage stage = (Stage) login.getScene().getWindow();
      	     
    	    stage.close();

    	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
    	     getResource("Re_Login.fxml")));
    		 Stage primaryStage1 = new Stage();
    		 primaryStage1.setScene(quizScene);
    		 primaryStage1.show();
        }
        
    }
    
   
    
    @FXML
    private void  Appointmentoptions(ActionEvent event) throws IOException {
    	Parent CalenderView = FXMLLoader.load(getClass().getResource("AppointmentOptions.fxml"));
		Scene CalenderScene=  new Scene(CalenderView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(CalenderScene);
		window.setTitle("");
		window.show();
    }
    
    @FXML
    private void  ViewTransactions(ActionEvent event) throws IOException {
    	Parent CalenderView = FXMLLoader.load(getClass().getResource("TransactionsView.fxml"));
		Scene CalenderScene=  new Scene(CalenderView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(CalenderScene);
		window.setTitle("");
		window.show();
    }
    @FXML
    private void  ViewPatientProfile(ActionEvent event) throws IOException {
    	Parent CalenderView = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
		Scene CalenderScene=  new Scene(CalenderView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(CalenderScene);
		window.setTitle("");
		window.show();
    }
    @FXML
    private void  Give_Feedback(ActionEvent event) throws IOException {
    	Parent CalenderView = FXMLLoader.load(getClass().getResource("Give_Feedback.fxml"));
		Scene CalenderScene=  new Scene(CalenderView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(CalenderScene);
		window.setTitle("");
		window.show();
    }
    
    @FXML
    private void Enter_Feedback(ActionEvent event) throws IOException {
    	String feedbackk=feedback.getText();
    	if(feedback.getText().isEmpty())
    	{
    		prompt.setText("*Feedback is empty");
    	}
    	else
    	{
    		Parent CalenderView = FXMLLoader.load(getClass().getResource("FeedbackSuccessful.fxml"));
    		Scene CalenderScene=  new Scene(CalenderView);
    		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		window.setScene(CalenderScene);
    		window.setTitle("");
    		window.show();
    		clinic.setFeedback(feedbackk);
    	}
    }
    
    @FXML
    private void Make_Payment(ActionEvent event) throws IOException {
    	Parent CalenderView = FXMLLoader.load(getClass().getResource("PaymentDetails.fxml"));
		Scene CalenderScene=  new Scene(CalenderView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(CalenderScene);
		window.setTitle("");
		window.show();
    }
    
    @FXML
    private void home(ActionEvent event) throws IOException {
    	Parent HomeView = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));
		Scene HomeScene=  new Scene(HomeView);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(HomeScene);
		window.setTitle("Main Menu");
		window.show();
    }

}