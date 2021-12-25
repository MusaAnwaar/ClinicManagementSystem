package application;

import java.util.ArrayList;
import java.util.List;

public class CancelAppointmentController {
	 private static Clinic clinic = null; 
	  public CancelAppointmentController() {
			clinic = clinic.getInstance();
		}
	  public int CancelAppointment(int appID,String name,int cnic)
	  {
		  int check=0;
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
						 
						  if(AppSchedule.get(i).getBooking().getBookingStatus()==0)
						  {
							  check=-1;
						  }
						  else
						  {
							  DBHandler ins = new DBHandler();
							  ins.cancelUpdateDBHandler(AppSchedule.get(i).getBooking().getPatient().getId());
							  AppSchedule.get(i).getBooking().setBookingStatus(0);
							  check=1;
						  }
					  }
				  }
			  }  
		  }
		  return check;	  
	  }

}
