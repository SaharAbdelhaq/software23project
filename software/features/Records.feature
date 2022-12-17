Feature: Patient Records 
Actor: patient 


 
 Scenario: new patient 
 Given that the user type is "client"
 When the user has no previous visits 
 And has no record
 Then add new appointment
 
 Scenario: patient already has a record 
 Given that the user is "client"
 When the user already has a previous visits
 Then add new appointment 
 
 
 
 