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
import java.util.ResourceBundle;

public class ProfileViewController implements Initializable{

    @FXML
    private TableColumn<Person, Integer> PhoneColumn;

    @FXML
    private TableColumn<Person,String> EmailColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Person> PersonView;

    @FXML
    private Button modifyButton;

    @FXML
    private TableColumn<Person, Integer> PatientIDColumn;

    @FXML
    private TableColumn<Person,String> NameColumn;

    @FXML
    private TableColumn<Person, Integer> AgeColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label titleLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Person> person = FXCollections.observableArrayList(
        new Person(1,"Moosa", 12345678,"moosa@gmail.com", 900),
                new Person(2,"Zainab", 45565556, "zainab@gmail.com",988),
                new Person(3,"Rafia", 57543535, "rafia@gmail.com",3333)
            );


        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        PatientIDColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<>("CNIC"));
        PhoneColumn.setCellValueFactory(new PropertyValueFactory<>("EmailAddress"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        //add your data to the table here.
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
    
    @FXML
    void handleDeleteButton(ActionEvent event) {

    }

    @FXML
    void handleModifyButton(ActionEvent event) {

    }

    @FXML
    void handleSearchButton(ActionEvent event) {
    }
}
