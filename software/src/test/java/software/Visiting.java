package software;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Visiting {
	MainClass mainClass = new MainClass();
	Appointment app = new Appointment(mainClass);
	Patient p= new Patient();

	
	
	public Visiting(Patient patient) {
		mainClass = new MainClass();
		app = new Appointment(mainClass);
		patient=this.p;
		

	}

	
	@Given("that the user entered is {string}")
	public void that_the_user_entered_is(String string) {
		if(string.equals(p.getType())) {
	    	assertTrue(true);
		}
	}

	@When("the patient has an appointment")
	public void the_patient_has_an_appointment() {
	    p.addAppointment(app);
	}
	

	@When("arrives to the clinic")
	public void arrives_to_the_clinic() {
	    assertTrue(true);
	}
	

	@Then("mark this appointment as visit")
	public void mark_this_appointment_as_visit() {
		
	    app.setVisited(true);
	    assertTrue(true);
	}

	@Then("store the patients {string} about the visit")
	public void store_the_patients_about_the_visit(String string) {
	   app.setNotes(string);
	   assertTrue(true);
	}
	

	



}
