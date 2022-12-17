Feature: Multiple Appointment 
Actor: User

Scenario: User have existing appointments
	Given the user of type "client"
	When the status is "true" for the client login
	And the client added another appointment 
	And there is an existing appointments
	Then another appointment can be added successfully
	
Scenario: User is not logged in
	Given the user of type "client"
	When the status is "false" for the client login
	Then another appointment cannot be added