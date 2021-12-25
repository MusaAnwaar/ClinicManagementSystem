package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookAppointmentController {

	private static Clinic clinic = null;

	public BookAppointmentController() {
		clinic = clinic.getInstance();

		clinic.loadAppointmentCatalogue();

	}

	public int BookAppointment(String service, int timem, int timeh, String date, String name, int age, int cnic,
			String email) {
		int valID = 0;
		List<Appointment> AppSchedule = new ArrayList<Appointment>();
		AppSchedule = clinic.getAppointmentSchedule();
		for (int i = 0; i < AppSchedule.size(); i++) {
			if ((date.compareTo(AppSchedule.get(i).getAppDate()) == 0 && AppSchedule.get(i).getTimem() == timem
					&& AppSchedule.get(i).getTimeh() == timeh)) {
				valID = -1;
			} else {
				valID=0;
			}
		}
		if(valID==0)
		{
			System.out.println("I come here");
			Appointment a = new Appointment();
			a.getBooking().setPatientDetails(age, name, cnic, email);
			a.booking.setBookingDetails(1, new Date());
			a.Description.SearchCatalogue(service);

			a.payment.setPaymentDetails(a.Description.getFee(), 0);

			a.setAppointmentDetails(a.Description, a.payment, a.booking, timem, timeh, date, 0);
			clinic.AppointmentSchedule.add(a);

			Ledger l = new Ledger();
			l.setLedgerDetails(a.payment, new Date(), a.payment.Amount);
			valID = a.getAppointmentID();
		}
		return valID;
	}
	/*
	 * public AppointmentDescription SearchCatalogue(String service) {
	 * AppointmentDescription a= new AppointmentDescription();
	 * AppointmentDescription b= new AppointmentDescription();
	 * ArrayList<AppointmentDescription> AppointmentCatalogue=new
	 * ArrayList<AppointmentDescription>();
	 * AppointmentCatalogue=clinic.getAppointmentCatalogue(); for(int
	 * i=0;i<AppointmentCatalogue.size();i++) { a=AppointmentCatalogue.get(i);
	 * if(a.getName().compareTo(service)==0) { b=a; } } return b; }
	 */

}
