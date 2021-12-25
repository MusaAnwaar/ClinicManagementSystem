package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clinic {
    String Adress;
    String Name;
    int PhoneNo;
    int ClinicID;
    Ledger ledger1;
    List<Appointment> AppointmentSchedule=new ArrayList<Appointment>();
    List<AppointmentDescription> AppointmentCatalogue=new ArrayList<AppointmentDescription>();
    List<Feedback> Feedbacks=new ArrayList<Feedback>();

    private static Clinic clinic = null; 
    private Clinic() {
	}
	public synchronized static Clinic getInstance()
    {
        if (clinic == null) {
        	clinic = new Clinic();
        	clinic.loadAppointmentCatalogue();
        }
        return clinic;
    }

	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}
	public int getClinicID() {
		return ClinicID;
	}
	public void setClinicID(int clinicID) {
		ClinicID = clinicID;
	}
	public Ledger getLedger1() {
		return ledger1;
	}
	public void setLedger1(Ledger ledger1) {
		this.ledger1 = ledger1;
	}
	public List<Appointment> getAppointmentSchedule() {
		return AppointmentSchedule;
	}
	public void setAppointmentSchedule(List<Appointment> appointmentSchedule) {
		AppointmentSchedule = appointmentSchedule;
	}
	public List<AppointmentDescription> getAppointmentCatalogue() {
		return AppointmentCatalogue;
	}
	public void setAppointmentCatalogue(List<AppointmentDescription> appointmentCatalogue) {
		AppointmentCatalogue = appointmentCatalogue;
	}
	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}
	public void loadAppointmentCatalogue()
	{
		List<AppointmentDescription> AC=new ArrayList<AppointmentDescription>();
		AppointmentDescription a = new AppointmentDescription(1,"Regular Check-up",1000);
		AppointmentDescription b = new AppointmentDescription(2,"Teeth whitening",1500);
		AppointmentDescription c = new AppointmentDescription(3,"Crowning",7000);
		AppointmentDescription d = new AppointmentDescription(4,"Denture",25000);
		AppointmentDescription e = new AppointmentDescription(5,"Scaling",1000);
		AppointmentDescription f = new AppointmentDescription(6,"Invisible braces",50000);
		AppointmentDescription g = new AppointmentDescription(7,"Polishing",3500);
		AppointmentDescription h = new AppointmentDescription(8,"Root Canal",4000);
		AppointmentDescription i = new AppointmentDescription(9,"Implant",9000);
		AppointmentDescription j = new AppointmentDescription(10,"Tooth Extraction",1500);
		AC.add(a);
		AC.add(b);
		AC.add(c);
		AC.add(d);
		AC.add(e);
		AC.add(f);
		AC.add(g);
		AC.add(h);
		AC.add(i);
		AC.add(j);
		clinic.setAppointmentCatalogue(AC);
	}
	
	public void setFeedback(String str)
	{
			Feedback f = new Feedback();
			f.setFeedback(str);
			f.setDateAdded(new Date());
			DBHandler ins = new DBHandler();
			ins.FeedbackDBHandler(f);
			Feedbacks.add(f);

	}
}
