package application;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.collections.ObservableList;

public class DBHandler 
{	

	 private static Clinic clinic = null; 

	  public DBHandler() 
	  {
			clinic = clinic.getInstance();
	  }
	  public void Intialize()
	  {
		    SessionFactory factory = new Configuration().configure().buildSessionFactory();
		  	Session session = factory.openSession();
			String query = "from Appointment";
			Query q=session.createQuery(query);
			List<Appointment> list=q.list(); 
			clinic.AppointmentSchedule=q.list();
	  }
	  
	  
	  
	  /*public List paymentlist() //sends lists of apps for makepayment
	  {
		  	/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
		  	Session session = factory.openSession();
			String query = "from Appointment";
			Query q=session.createQuery(query);
			List<Appointment> list=q.list(); 
			
			return list;
			//System.out.println(p.getAppointmentID());
			
			//System.out.println(p.getPayment().Amount);
			//clinic.AppointmentSchedule.add(p);
	  }*/
	
	public void FeedbackDBHandler(Feedback obj)
	{
		//Saving Feedback Object to DB
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void PatientDBHandler(Patient obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
	
		
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void BookingDBHandler(Booking obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
	
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void AppointmentDBHandler(Appointment obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
	
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void DescriptionDBHandler(AppointmentDescription obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
	
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void PaymentDBHandler(Payment obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
	
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void LedgerDBHandler(Ledger obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
	
		
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void cancelUpdateDBHandler(int id)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		
		session.beginTransaction();
		Query q = session.createQuery("update Booking set BookingStatus=:newStatus where pid=:p");
		q.setParameter("newStatus", 0);
		q.setParameter("p", id);
		int r = q.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
	public void updatePaymentDBHandler(int id)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		
		session.beginTransaction();
		Query q = session.createQuery("update Payment set PaidStatus=:newStatus where PaymentID=:p");
		q.setParameter("newStatus", 1);
		q.setParameter("p", id);
		int r = q.executeUpdate();
		
		Query q2 = session.createQuery("update Payment set DatePaid=:newDate where PaymentID=:p2");
		q2.setParameter("newDate", new Date());
		q2.setParameter("p2", id);
		int r2 = q2.executeUpdate();
		session.getTransaction().commit();		
	
		session.close();
		
		factory.close();
	}
	public List FetchAppointments()
	  {
		    Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			//Put in DB handler
			Session session = factory.openSession();
			String query = "from Appointment";
			Query q=session.createQuery(query);
			return q.list();
	  }

	public List FetchPatientProfiles()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//Put in DB handler
		Session session = factory.openSession();
		String query = "from Patient";
		Query q=session.createQuery(query);
		List<Patient> list=q.list(); 
		return q.list();
	}
	public List FetchLedger()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//Put in DB handler
		Session session = factory.openSession();
		String query = "from Ledger";
		Query q=session.createQuery(query);
		List<Patient> list=q.list(); 
		return q.list();
	}
	

}
