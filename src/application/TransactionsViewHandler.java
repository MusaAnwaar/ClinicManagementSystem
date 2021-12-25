package application;

import javafx.beans.property.SimpleStringProperty;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransactionsViewHandler implements Initializable{

    @FXML
    private TableColumn<Ledger, Integer> RecordNo;

    @FXML
    private TableColumn<Ledger,String> DateRecorded;

    @FXML
    private TableView<Ledger> TransactionsView;

    @FXML
    private TableColumn<Ledger, Integer> paymentfee;
    
    @FXML
    private TableView<String> AppNamesView;
    
     @FXML
    private TableColumn<String, String> AppName;
     
     @FXML
     private TableView<String> PatNameView;

    @FXML
    private TableColumn<String,String> PatientName;

    @FXML
    private Label titleLabel;
    DBHandler db=new DBHandler();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		
		List<Appointment> list3=db.FetchAppointments(); 
		List<Ledger> list=db.FetchLedger(); 
		List<String> list1=new ArrayList();
		List<String> list2=new ArrayList();
		int paymentID;
		for(int i=0;i<list.size();i++)
		{
			paymentID=list.get(i).getPayment().getPaymentID();
			for(int j=0;j<list3.size();j++)
			{
				if(paymentID==list3.get(j).getPayment().getPaymentID())
				{
					list2.add(list3.get(j).getBooking().getPatient().getName());
					list1.add(list3.get(j).getDescription().getName());
				}
			}
		}
		
		ObservableList<Ledger> trans = FXCollections.observableArrayList(list);
		ObservableList<String> anames = FXCollections.observableArrayList(list1);
		ObservableList<String> pnames = FXCollections.observableArrayList(list2);


		RecordNo.setCellValueFactory(new PropertyValueFactory<>("RecordNo"));
		DateRecorded.setCellValueFactory(new PropertyValueFactory<>("DateRecorded"));
		paymentfee.setCellValueFactory(new PropertyValueFactory<>("paymentfee"));
		AppName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		PatientName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        TransactionsView.setItems(trans);
        AppNamesView.setItems(anames);
        PatNameView.setItems(pnames);
        
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
