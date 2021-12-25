package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PatientViewHandler implements Initializable{

    @FXML
    private TableColumn<Patient, Integer> CNICColumn;

    @FXML
    private TableColumn<Patient,String> EmailColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Patient> PersonView;

    @FXML
    private Button modifyButton;

    @FXML
    private TableColumn<Patient, Integer> PatientIDColumn;

    @FXML
    private TableColumn<Patient,String> NameColumn;

    @FXML
    private TableColumn<Patient, Integer> AgeColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label titleLabel;
    
    DBHandler db=new DBHandler();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
		ObservableList<Patient> person = FXCollections.observableArrayList(db.FetchPatientProfiles());
        PatientIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        CNICColumn.setCellValueFactory(new PropertyValueFactory<>("cnic"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        PersonView.setItems(person);
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
