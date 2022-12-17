package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLogin {
	Patient u = new Patient();
	String pass = "";
	String name = "";
	String t = "";
	
	ArrayList<Patient> patients = new ArrayList<Patient>();

	public UserLogin(Patient u) {
		u = this.u;
	}
	

	@Given("these are the users")
	public void these_are_the_users(DataTable dataTable) {

		String name, pass;
		for (int i = 0; i < 3; i++) {
			name = dataTable.cell(i, 0);
			pass = dataTable.cell(i, 1);
			
			u.setName(name);
			u.setPassword(pass);
			u.setStatus(false);
			u.setType("client");
			patients.add(u);

		}
	}

	@Given("that the client {string} is not logged in")
	public void that_the_client_is_not_logged_in(String string) {
		for (Patient e : patients) {
			
			if (e.getName().equals(string))
				assertTrue(e.getStatus());
		}
	}

	@When("type is client")
	public void type_is_client() {
		for (Patient e : patients) {
			
			t = e.getType();

			assertEquals(t, "client");
		}

	}

	@When("user name is {string} and the password is {string}")
	public void user_name_is_and_the_password_is(String string, String string2) {
		
		for (Patient k : patients) {
			if (k.getName().equalsIgnoreCase(string)) {
				pass = k.getPassword();
				if (pass.equals(string2))
					assertEquals(pass, string2);
				else
					assertNotEquals(pass, string2);

				u = k;
			}
		}

	}

	@Then("the client log in succeeds")
	public void the_client_log_in_succeeds() {
		u.setStatus(true);
		assertTrue(u.getStatus());

	}

	@Then("the client is logged in")
	public void the_client_is_logged_in() {
		assertTrue(u.getStatus());
	}

	@Then("the client log in fails")
	public void the_client_log_in_fails() {
		assertFalse(u.getStatus());
	}

	@Then("the client is not logged in")
	public void the_client_is_not_logged_in() {
		assertFalse(u.getStatus());
	}

}
