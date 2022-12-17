Feature: Visiting log 
Actor: patient 

Scenario: patient has notes
Given that the user entered is "client"
When the patient has an appointment
And arrives to the clinic
Then mark this appointment as visit
And store the patients "notes" about the visit



