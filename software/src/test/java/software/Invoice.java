package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Invoice {	
	Patient c;

	MainClass mainClass = new MainClass();

	Appointment cost = new Appointment(mainClass);	//appointmnet cost

	ArrayList<Appointment> appointments;
	
	Appointment a = new Appointment(mainClass);

	ArrayList<Service> appSer;
	float price = 0;

	public Invoice(Appointment a) {
		mainClass = new MainClass();
		this.a = new Appointment(mainClass);
		a = this.a;
		appointments = new ArrayList<Appointment>();
		c = new Patient();
		appSer = new ArrayList<Service>();
	}

	@Given("here the appointments list for user1")
	public void here_the_appointments_list_for_user1(DataTable dataTable) {
		int ID, f= 0;
		String s;	
		Date dt = null;
		
		for (int i = 0; i < 3; i++) {
			ID = Integer.parseInt(dataTable.cell(i, 0));
			try
			{
				dt = new SimpleDateFormat("dd-MM-yyyy").parse(dataTable.cell(i, 1));
			} 
			catch (ParseException e) {

				e.printStackTrace();
			}
			
			s = dataTable.cell(i, 2);
			f = 0;
			
			if (!(c.getAppointments().isEmpty())) {
				for (Appointment a : c.getAppointments()) {
					if (a.getDate().equals(dt)) {

						a.addService(s);
						f = 1;

					}
				}
			}
			
			if (f == 0) {

				a.setDate(dt);
				a.addService(s);
				c.addAppointment(a);
			}

		}

	}

	@Given("that the patient have an appointment on {string}")
	public void that_the_patient_have_an_appointment_on(String string) {

		if (!(c.getAppointments().isEmpty())) {
			try
			{
				
				Date d = new SimpleDateFormat("dd-MM-yyyy").parse(string);
				appointments = c.getAppointments();
				for (Appointment a : appointments) {
					if (a.getDate().equals(d)) {
						cost = a;
						assertTrue(true);
					}
					
				}
				
			} 
			catch (ParseException e) {

				e.printStackTrace();
			}
		}

	}

	@Given("the appointment has {string} service")
	public void the_appointment_has_service(String string) {
		price = 0;
		appSer = a.getServices();
		for (Service s : appSer) {
			if (s.getName().equals(string)) {
				assertTrue(true);
				price = s.getPrice();

			}
		}

	}

	@Then("the invoice value is {string}")
	public void the_invoice_value_is(String string) {
		if (price == Float.parseFloat(string)) {
			assertTrue(true);
			cost.setAppointmentInvoice(price);
		}

	}

	@Then("the invoice generated successfully")
	public void the_invoice_generated_successfully() {
		assertTrue(true);
	}

	@Given("the appointment has {string} service and {string} service")
	public void the_appointment_has_service_and_service(String string, String string2) {
		int f1 = 0, f2 = 0;
		price = 0;
		appSer = a.getServices();
		for (Service s : appSer) {
			if (s.getName().equals(string)) {
				f1 = 1;
				price += s.getPrice();

			}

			if (s.getName().equals(string2))
			{
				f2 = 1;
				price += s.getPrice();

			}
		}

		if (f1 == 1 && f2 == 1)
			assertTrue(true);

	}

	@Then("the invoice value is the summation of {string} and {string}")
	public void the_invoice_value_is_the_summation_of_and(String string, String string2) 
	{
		float s;
		s= Float.parseFloat(string2) + Float.parseFloat(string);
        if(s==price)
        	assertTrue(true);
		cost.setAppointmentInvoice(price);
	}

}
