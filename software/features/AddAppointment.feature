Feature: Add Appointment
Actor: User

@test1
Scenario: User can add an appointment
	Given the user is "client"
	When the login status is "true" for the client
	And the date is "2022-11-01"
	And the time is "13:30-14:30"
	Then the appointment added successfully
	
@test2	
Scenario: User is not logged in
	Given the user is "client"
	When the login status is "false" for the client
	Then the appointment cannot be added successfully
	
 	
@test3	
Scenario: Time is null
 	Given the user is "client"
	When the login status is "true" for the client
 	And the date is "2022-11-01"
 	And the time is ""
 	Then the appointment cannot be added successfully
 	
@test4
Scenario: Date is null
 	Given the user is "client"
	When the login status is "true" for the client
 	And the date is ""
 	And the time is "13:30-14:30"
 	Then the appointment cannot be added successfully	