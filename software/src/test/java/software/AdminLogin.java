package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLogin {
	
	Admin user;
	String pass = "", type = "";
	boolean status = false;
	
	public AdminLogin(Admin user) {

		this.user = new Admin();
		user = this.user;

	}

	@Given("that the admin is not logged in")
	public void that_the_admin_is_not_logged_in() {

		assertFalse(user.getStatus());
	}

	@When("user is {string}")
	public void user_is(String string) {
		type = user.getType();
		assertEquals(type, "admin");

	}

	@When("the password is {string}")
	public void the_password_is(String string) {
		pass = user.getPassword();
		if (pass.equals(string))
			assertEquals(pass, string);
		else
			assertNotEquals(pass, string);

	}

	@Then("the admin log in succeeds")
	public void the_admin_log_in_succeeds() {
		user.setStatus(true);
		assertTrue(user.getStatus());
	}

	@Then("the admin is logged in")
	public void the_admin_is_logged_in() {

		assertTrue(user.getStatus());
	}

	@Then("the admin log in fails")
	public void the_admin_log_in_fails() {

		assertFalse(user.getStatus());

	}

	@Then("the admin is not logged in")
	public void the_admin_is_not_logged_in() {

		assertFalse(user.getStatus());
	}

}
