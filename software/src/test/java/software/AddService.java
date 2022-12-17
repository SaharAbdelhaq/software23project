package software;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class AddService {
	Service s = new Service();
	Person a;

	public AddService(Service s) {
		s = this.s;
		a = new Admin();

	}

	@Given("that the user is {string}")
	public void that_the_user_is(String string) {
		if (a.getType().equals(string))
			assertTrue(true);
	}

	@When("the admin login status is {string}")
	public void the_admin_login_status_is(String string) {
		if (string.equalsIgnoreCase("true")) {
			a.setStatus(true);
			assertTrue(a.getStatus());
		} else
			assertFalse(a.getStatus());
	}

	@When("the service existence {string}")
	public void the_service_existence(String string) {
		if (string.equalsIgnoreCase("false")) {
			assertTrue(s.getAdded());
		} else
			assertFalse(false);

	}

	@When("the price is {string} and name of service is {string}")
	public void the_price_is_and_name_of_service_is(String string, String string2) {
		if (string.equals("notnull")) 
		{
			
			assertTrue(true);
			s.setPrice(Integer.parseInt(string));
			
			s.setName(string2);

		} else if (string.equals(""))
			assertFalse(false);

	}

	@Then("the service added successfully")
	public void the_service_added_successfully()
	{
		if (s.getAdded())
			s.setAdded(true);
		assertTrue(true);
	}

	@Then("the service cannot be added successfully")
	public void the_service_cannot_be_added_successfully() 
	{
		if (!(s.getAdded()))
			s.setAdded(false);
		assertFalse(false);

	}

}
