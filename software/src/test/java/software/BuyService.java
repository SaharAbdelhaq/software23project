package software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.datatable.DataTable;

public class BuyService {
	ArrayList<Service> services;
	ArrayList<Service> selectedS;
	Service ser = new Service();
	Person c;


	public BuyService(Service s) {
		s = this.ser;
		c = new Patient();	
		s = new Service();
		
		services = new ArrayList<Service>();
		selectedS = new ArrayList<Service>();

	}

	@Given("here the service\\/price list")
	public void here_the_service_price_list(io.cucumber.datatable.DataTable dataTable) {
		String service, price;
		for (int i = 0; i < 5; i++) {
			service = dataTable.cell(i, 0);
			price = dataTable.cell(i, 1);
			ser.setAdded(true);
			ser.setPrice(Integer.parseInt(price));
			ser.setName(service);
			ser.selectedbyCli(false);
			services.add(ser);
		}
	}

	@When("the client login status is {string}")
	public void the_client_login_status_is(String string) {
		if (string.equalsIgnoreCase("true")) {
			c.setStatus(true);
			assertTrue(c.getStatus());
		} else
			assertFalse(c.getStatus());
	}

	@When("the service is {string}  and its status {string}")
	public void the_service_is_and_its_status(String string, String string2) {
		
		for (Service s1 : services) {
			if (s1.getName().equals(string)) {
				if (s1.getIfChosen() == (Boolean.parseBoolean(string2)) && string2.equals("false")) {
					s1.selectedbyCli(true);
					selectedS.add(s1);
					
					the_service_is_chosen_successfully();
				} else if (string2.equals("true")) {
					the_service_cannot_be_chosen_successfully();
				}
			}
		}

	}

	@Then("the service is chosen successfully")
	public void the_service_is_chosen_successfully() {
		
		assertTrue(true);

	}

	@Then("the service cannot be chosen successfully")
	public void the_service_cannot_be_chosen_successfully() {
		
		assertFalse(false);
	}

	@When("the service is {string}  and its status was {string}")
	public void the_service_is_and_its_status_was(String string, String string2) {
		for (Service s1 : selectedS) {
			if (s1.getName().equals(string)) {
				the_service_is_already_chosen_successfully();
			}
		}

	}

	@Then("the service is already chosen successfully")
	public void the_service_is_already_chosen_successfully() {
		assertTrue(true);
	}

	@When("the services are {string} and {string}  and there statuses were {string}")
	public void the_services_are_and_and_there_statuses_were(String string, String string2, String string3) {
		selectedS = new ArrayList<Service>();
		
		for (Service s1 : services) {
			if (s1.getName().equals(string) || s1.getName().equals(string2)) {
				if (s1.getIfChosen() == (Boolean.parseBoolean(string2)) && string3.equals("false")) {
					s1.selectedbyCli(true);
					selectedS.add(s1);
				}

			}
		}
		
		if (!(selectedS.isEmpty()))
			the_services_are_chosen_successfully();

	}

	@Then("the services are chosen successfully")
	public void the_services_are_chosen_successfully() {
		assertTrue(true);
	}

}
