Feature: Edit Appointment
Actor: User

Scenario: Edit appointment date
	Given the user type "client" with id "1000"
	When the status is "true" for login
	And there is existing appointments
	And the appointment id is "100"
	And the new date is "03-11-2022"
	Then the appointment will be edited successfully
	
Scenario: Edit appointment time
	Given the user type "client" with id "1000"
	When the status is "true" for login
	And there is existing appointments
	And the appointment id is "100"
	And the new time is "12:00-13:00"
	Then the appointment will be edited successfully
	
Scenario: Delete appointment 
	Given the user type "client" with id "1000"
	When the status is "true" for login
	And there is existing appointments
	And the appointment id is "100"
	Then the appointment will be deleted successfully
	
Scenario: Client not logged in
	Given the user type "client" with id "1000"
	When the status is "false" for login
	Then the appointment will not be edited
	
Scenario: Cannot edit appointment date
	Given the user type "client" with id "1000"
	When the status is "true" for login
	And there is existing appointments
	And the appointment id is "100"
	And the new date is ""
	Then the appointment will not be edited
	
Scenario: Cannot edit appointment time
	Given the user type "client" with id "1000"
	When the status is "true" for login
	And there is existing appointments
	And the appointment id is "100"
	And the new time is ""
	Then the appointment will not be edited