package software;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person {
	ArrayList<Appointment> appointments;
	int f; // to detect how is in the system now
	String n;

	public Patient() 
	{
		super(mainClass);
		appointments=new ArrayList<Appointment>();
		f = 0;
		status = false; 
		type = "client";
		pass = "";
		name = "";
		n ="";		
	}
	
	public String getNumber() 
	{
		return n;
	}

	public void setNumber(String s) 
	{
		n=s;
	}

	
	public void setType(String s) 
	{
		type = "client";
	}
	
	@Override
	String getType()
	{
		return type;
	}

	public void setPassword(String pass)
	{
		pass = pass;
	}
	
	@Override
	String getPassword()
	{
		return pass;
	}
	
	public void setName(String na)
	{
		name = na;
	}

	@Override
	String getName()
	{
		return name;
	}
	
	public void addAppointment(Appointment appo)
	{
		appointments.add(appo);
	}
	
	public Appointment bookAnAppointment(Date d, Date t) 
	{
		Appointment app = new Appointment(mainClass);
		app.setDate(d);
		app.setTime(t);
		
		return app;
	}
	
	public void removeAppointment (Appointment appo)
	{
		for (int i = 0 ; i < appointments.size() ; i++) 
		{
			if (appointments.get(i) == appo)
			{
				appointments.remove(i);
			}
		}
	}
	
	public Appointment getAppointment (int ID)
	{
		Appointment appo = new Appointment(mainClass);
		for (int i = 0 ; i < appointments.size() ; i++) 
		{
			if (appointments.get(i).getAid() == ID)
			{
				appo = appointments.get(i);
				return appo;
				
			}
		}
		return null;
	}
	
	public ArrayList<Appointment> getAppointments()
	{
		return appointments;
	}
	
}
