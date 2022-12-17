package software;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;

public class Appointment {    
	ArrayList<Service> allservices;
    ArrayList<Service> myServices;	
    MainClass mainClass=null;
   public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    Opticity clinic;
	Date date, time; 
	boolean accepted, addOrNot, visited; 
    int adminID = 0;
    float invoice=0;
    String notes;

 
   public Appointment(MainClass mainClass){
    	mainClass=Opticity.mainClass;   
    	 allservices=new ArrayList<Service>(); 
    	 myServices=new ArrayList<Service>();
    	 allservices=mainClass.o.AllServices();
    	accepted= false;
    	visited= false;
    	addOrNot= false;  	
    	notes="";
    	
    	 try
    	 {
			date=new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-02");
			time = new SimpleDateFormat("hh:mm-hh:mm").parse("13:30-14:30");
		} catch (ParseException e) 
    	 {
			e.printStackTrace();
		} 
    	  	 
    	 for(Service s:allservices) 
    	 {
    		 myServices.add(s);
    		
    	 }
    	
    }
   
   // setters and getters 
   
   public void setVisited(boolean r) 
	{
		visited=r;
	}


	public void setNotes(String string) 
	{
		notes=string;
	}

	public void setAid (int adminID)
	{
		this.adminID = adminID;
	}
      public void setAddAppointment(boolean b)
    {
		addOrNot = b;

	}
      
      public void setAccepted(boolean a) 
    {
    	accepted = a;
    }
      public void setDate(Date d) 
	{
		date=d;
	}
	
      public void setTime(Date d)
	{
		time=d;
	}
    
    public boolean getAddAppointment()
    {
		return !(addOrNot); 
	}
    
   
    public boolean getAccepted()
    {
    	return accepted;
    }
    
	public Date getDate()
	{	
		return date;
	}
	
	public Date getTime() 
	{	
		return time;
	}
	
	public ArrayList<Service> getServices()
	{
		return myServices;
	}
	public void setAppointmentInvoice(float price) 
	{
		invoice=price;	
	}
	
	public float getAppointmentInvoice(int price)
	{
		return invoice;
		
	}

	public int getAid ()
	{
		return adminID;

	}
	public boolean getVisited()
	{
		return visited;
	}
	
	public String getNotes() 
	{
		return notes;
	}
	
	// adding a service
	
	public void addService(String appointService)
	{		
		for(Service s:myServices)
		{			
			if(s.getName().equalsIgnoreCase(appointService))
			{
				if(s.getIfChosen()==false) 
				{
					s.selectedbyCli(true);		
				}
			}
		}		
		
	}
	
	
}
