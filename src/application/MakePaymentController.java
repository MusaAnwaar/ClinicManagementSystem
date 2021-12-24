package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MakePaymentController {
	
	 private static Clinic clinic = null; 
	  public MakePaymentController() {
			clinic = clinic.getInstance();
			
		}
	  public int getFee(int appID,String name,int cnic)
	  {
		  int Fee=0;
		  List<Appointment> AppSchedule=new ArrayList<Appointment>();
		  AppSchedule=clinic.getAppointmentSchedule();
		  for(int i=0;i<AppSchedule.size();i++)
		  {
			  if(AppSchedule.get(i).getAppointmentID()==appID)
			  {
				  if(name.compareTo(AppSchedule.get(i).getBooking().getPatient().getName())==0)
				  {
					  if(AppSchedule.get(i).getBooking().getPatient().getCnic()==cnic)
					  {
						  Fee=AppSchedule.get(i).getPayment().getAmount();
					  }
				  }
			  }
				  
		  }
		  return Fee;  
	  }
	  public  int MakePayment(int appID)
	  {
		  int check =0;
		  List<Appointment> AppSchedule=new ArrayList<Appointment>();
		  AppSchedule=clinic.getAppointmentSchedule();
		  for(int i=0;i<AppSchedule.size();i++)
		  {
			  if(AppSchedule.get(i).getAppointmentID()==appID)
			  {
				  check=1;
				  AppSchedule.get(i).getPayment().setPaidStatus(1);
				  //System.out.println("I come here");
				  DBHandler ins = new DBHandler();
				  ins.updatePaymentDBHandler(AppSchedule.get(i).payment.PaymentID);
				  AppSchedule.get(i).getPayment().setPaidStatus(1);
				  AppSchedule.get(i).getPayment().setDatePaid(new Date());;
				  //System.out.println("I come here");	
			  }
		  }
		  return check;

	  }
				  
}
