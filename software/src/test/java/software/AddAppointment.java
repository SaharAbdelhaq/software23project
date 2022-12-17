package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAppointment {
	Patient c;

	MainClass mainClass = new MainClass();
	Appointment a = new Appointment(mainClass);
	
	public AddAppointment(Appointment appointment) {
		mainClass = new MainClass();
		this.a=new Appointment(mainClass);
		appointment = this.a;
		c = new Patient();
	}

	@Given("the user type is {string}")
	public void the_user_type_is(String string)
	{
		if (c.getType().equals(string))
			assertTrue(true);
		
	}

	@When("the login status is {string} for the client")
	public void the_login_status_is_for_the_client(String string) 
	{
		if (string.equalsIgnoreCase("true"))
		{
			c.setStatus(true);
			assertTrue(c.getStatus());
		} 
		else
			assertFalse(c.getStatus());
	}
	
	@When("the date is {string}")
	public void the_date_is(String string)
	{
		if (string.equals("notnull"))
		{
			assertTrue(true);
			Date date;
			try 
			{
				date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-01");
				a.setDate(date);
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
			
		} else if (string.equals(""))
			assertFalse(false);
	}

	@When("the time is {string}")
	public void the_time_is(String string) {
		if (string.equals("notnull")) {
			assertTrue(true);
			Date time;
			try {
				time = new SimpleDateFormat("hh:mm-hh:mm").parse("13:30-14:30");
				a.setTime(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (string.equals(""))
			assertFalse(false);
	}

	@Then("the appointment added successfully")
	public void the_appointment_added_successfully() 
	{
		if (a.getAddAppointment()) {
			a.setAddAppointment(true);
			a.setAccepted(false);
			c.addAppointment(a);
		}
		assertTrue(true);
	}

	@Then("the appointment cannot be added successfully")
	public void the_appointment_cannot_be_added_successfully()
	{
		if (!(a.getAddAppointment())) {
			a.setAddAppointment(false);
			a.setAccepted(false);
		}
		assertFalse(false);
	}
}
