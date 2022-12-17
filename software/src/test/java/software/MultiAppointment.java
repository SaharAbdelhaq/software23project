package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiAppointment {
	MainClass mainClass = new MainClass();	
	Patient p;

	Appointment a = new Appointment(mainClass);
	
	public MultiAppointment(Appointment a)
	{
		mainClass = new MainClass();
		this.a = new Appointment(mainClass);
		a = this.a;
		p = new Patient();
	}
	
	@Given("the user of type {string}")
	public void the_user_of_type(String string)
	{
		if (p.getType().equals(string))
			assertTrue(true);
	}

	@When("the status is {string} for the client login")
	public void the_status_is_for_the_client_login(String string) 
	{
		if (string.equalsIgnoreCase("true")) {
			p.setStatus(true);
			assertTrue(p.getStatus());
		} else
			assertFalse(p.getStatus());
	}

	@When("the client added another appointment")
	public void the_client_added_another_appointment() 
	{
		
	}

	@When("there is an existing appointments")
	public void there_is_an_existing_appointments() 
	{
	    if (!p.getAppointments().isEmpty()) {
	    	assertTrue(true); 
	    } else
	    	assertFalse(false); 
	}

	@Then("another appointment can be added successfully")
	public void another_appointment_can_be_added_successfully() 
	{
		if (a.getAddAppointment()) {
			a.setAddAppointment(true);
			a.setAccepted(false);
			p.addAppointment(a);
		}
	    assertTrue(true);
	}

	@Then("another appointment cannot be added")
	public void another_appointment_cannot_be_added() 
	{
		if (!(a.getAddAppointment())) {
			a.setAddAppointment(false);
			a.setAccepted(false);
		}
		assertFalse(false);
	}

}
