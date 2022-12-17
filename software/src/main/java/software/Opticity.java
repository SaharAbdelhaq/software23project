package software;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.*;


public class Opticity {
	Admin a;
	Person p;
	Scanner input;
	
	static MainClass mainClass;
	static ArrayList<Patient> patients = new ArrayList<Patient>();
	static ArrayList<Service> services = new ArrayList<Service>();
	static ArrayList<Patient> patientsWithApp = new ArrayList<Patient>();
	
	//for connecting database
	//Connection conic;
    
	public Opticity(MainClass mainClass)
	{
		
		
		this.a = new Admin();
		Opticity.mainClass = mainClass;
		//conic = MainClass.conic;
		input = new Scanner(System.in);
		

	}

	ArrayList<Service> retServices() 
	{
		return services;
	}

	
	public static boolean showAllPatients() {
		System.out.println("Patient Name \t Number");
		if (!(patients.isEmpty())) {
			for (Patient p1 : patients) {
				System.out.println(p1.getName() + "\t" + p1.getNumber());

			}
		}
		return true;
	}

	

	public ArrayList<Patient> getAllPatients() {
		return patients;
	}

	public boolean showAllPattientsAndTheirAppointments() {
		System.out.println("Patient Name \t Appointments \tVisited or Not \t Services ");

		String s = "";
		if (!(patientsWithApp.isEmpty())) {
			for (Patient p1 : patientsWithApp) {
				s += p1.getName() + "\t";
				for (Appointment app : p1.getAppointments()) {
					s += app.getDate() + "\t";
					if(app.getVisited()==true) {
						s+="Visited\t";
					}
					else s+="Not Visited\t";
					for (Service ser : app.getServices()) {
						if(ser.getIfChosen()==true) s += ser.getName() + "\t \t";
					}
					s += "\n";
				}
				s += "\n";

			}
			System.out.println(s);
		}

		return true;
	}

	public Patient getPatient(int id) {
		Patient p = new Patient();
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getPid() == id) {
				p = patients.get(i);
				break;
			}
		}
		return p;
	}

	public void addService() {
		
		Service newService = new Service();

		int exists = 0;

		System.out.println("Service Name:");
		String ServiceName = input.nextLine();
		System.out.println("Service Cost:");
		float ServiceCost = Float.valueOf(input.nextLine());
		if (!(ServiceName.equals("")))
			newService.setName(ServiceName);
		if (ServiceCost != 0)
			newService.setPrice(ServiceCost);
		for (Service s1 : services) {
			if (s1.getName().equalsIgnoreCase(ServiceName))
				exists = 1;
		}
		if (exists == 1)
			System.out.println("Service already exists.");



	}

	public void setPatientsInfo() {
	
		int ID = 0,status = 0;
		
		String Name = null,Pass = null, num = null;
		String isPatient = null;
		Patient p = new Patient();
		
				if (isPatient.equals("client"))
				{
					p = new Patient();
					p.setPid(ID);
					p.setNumber(num);
					p.setName(Name);
					p.setPassword(Pass);
					
					if (status == 0)
						p.setStatus(false);
					else
						p.setStatus(true);
					patients.add(p);

				} else 
					
				{
					a.setName(Name);
					a.setPassword(Pass);
					a.setPid(ID);
					if (status == 0)
						a.setStatus(false);
					else
						a.setStatus(true);
				}

			}
			



	public void improve() {
		
		ArrayList<Integer> accept=new ArrayList<Integer>();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


		
		int apppintment_ID;
		String name,services;
		
		System.out.println("Appointment ID\t Patient Name \t Date \t Time \t Services");
		


		System.out.println("Enter IDs for the appointments you want to accept (Enter q to stop):");
			
			while (input.hasNextInt()) {
			    accept.add(input.nextInt());		    
			}
			
			for(Integer f:accept) {
				
			
	    	System.out.println("Appointment "+f+" is accepted");
				for(Patient T:patientsWithApp) {
					Appointment p1=T.getAppointment(f);
					if(p1!=null) {
						p1.setAccepted(true);
						
					}
				
				}
			}
	}

			
	public void setPatientsAppo() {
	
		Patient p = new Patient();
		Service mySer = new Service();

		int ID = 0,status = 0,appID;
		boolean visited,accepted;
		String Name = null,Pass = null,number = null;

		Appointment app = null;
		String isPatient = null;

		String[] xs = null;
		String Pservices = "";
		
			int SiD;
		
			
				if (isPatient.equals("client")) {
					p = new Patient();
					p.setPid(ID);
					p.setNumber(number);
					p.setName(Name);
					p.setPassword(Pass);
					if (status == 0)
						p.setStatus(false);
					else
						p.setStatus(true);
					for (String x : xs)
					{
						SiD = Integer.parseInt(x);
						for (Service n : services) {
							if (n.getServID() == SiD) {
								app.addService(n.getName());
								Pservices += n.getName() + "\t";
							}
						}
					}
					p.addAppointment(app);
					patientsWithApp.add(p);

				}

	}

	
	void PrintService() {
		String s = "Service \t \t Price\n";
		System.out.println(s);
		for (Service y : services) {
			System.out.println(y);

		}

	}
	
 ArrayList<Service> AllServices() 
	{				
		
		int SID;	
		String name = "";
		float price;
		
		Service ser = new Service();

		return services;

	}

}
