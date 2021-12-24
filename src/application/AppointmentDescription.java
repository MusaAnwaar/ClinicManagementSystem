package application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppointmentDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServiceID;//p.key
	
	private static Clinic clinic = null; 
	  public AppointmentDescription() {
			clinic = clinic.getInstance();
		}
	
    private String Name;
    private int Fee;
	
	public AppointmentDescription(int serviceID, String name, int fee) {
		super();
	
		ServiceID = serviceID;
		Name = name;
		Fee = fee;
	}
	public int getServiceID() {
		return ServiceID;
	}
	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getFee() {
		return Fee;
	}
	public void setFee(int fee) {
		Fee = fee;
	}

	public void SearchCatalogue(String service)
	  {
		  AppointmentDescription b= new AppointmentDescription();
		  List<AppointmentDescription> AppointmentCatalogue=new ArrayList<AppointmentDescription>();
		  AppointmentCatalogue=clinic.getAppointmentCatalogue();
		  for(int i=0;i<AppointmentCatalogue.size();i++)
		  {
			  b=AppointmentCatalogue.get(i);
			  if(b.Name.compareTo(service)==0)
			  {
				  this.setFee(b.getFee());
				  this.setName(b.getName());
			  }
		  }
		  DBHandler ins = new DBHandler();
		  ins.DescriptionDBHandler(this);
	  }
}
