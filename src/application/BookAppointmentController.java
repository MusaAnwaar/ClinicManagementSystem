package application;

import java.util.ArrayList;
import java.util.Date;

public class BookAppointmentController {
	
	  private static Clinic clinic = null; 
	  public BookAppointmentController() {
			clinic = clinic.getInstance();
		}
	  public void BookAppointment(String service,int timem,int timeh,String date,String name,int age,int cnic,String email)
	  {
		 Appointment a= new Appointment();
		 a.getBooking().setPatientDetails(age, name, cnic, email);
		  a.booking.setBookingDetails(1, new Date());
		 a.Description = this.SearchCatalogue(service);
		 DBHandler ins = new DBHandler();
		  ins.DescriptionDBHandler(a.Description);
		 
		 a.payment.setPaymentDetails(a.Description.getFee(), 0);
		 
		 a.setAppointmentDetails(a.Description,a.payment,a.booking, timem, timeh, date, 1);
		 
	  }
	  public AppointmentDescription SearchCatalogue(String service)
	  {
		  AppointmentDescription a= new AppointmentDescription();
		  AppointmentDescription b= new AppointmentDescription();
		  ArrayList<AppointmentDescription> AppointmentCatalogue=new ArrayList<AppointmentDescription>();
		  AppointmentCatalogue=clinic.getAppointmentCatalogue();
		  for(int i=0;i<AppointmentCatalogue.size();i++)
		  {
			  a=AppointmentCatalogue.get(i);
			  if(a.getName().compareTo(service)==0)
			  {
				  b=a;
			  }
		  }
		  return b;
	  }

}
