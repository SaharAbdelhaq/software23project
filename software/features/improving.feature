Feature: improving appointment
Actor: Admin

Scenario: Admin can accept the appointment
	Given the user type is "admin"
	When the login status is "true" for the admin
	And the "client" added a new appointment
	Then the admin book the appointment for the client
	
Scenario: Admin is not logged in
	Given the user type is "admin"
	When the login status is "false" for the admin
	Then the admin cannot book the appointment for the client
	
Scenario: Admin do not want to accept the appointment
	Given the user type is "admin"
	When the login status is "true" for the admin
	And the "client" added a new appointment
	Then the admin cannot book the appointment for the client