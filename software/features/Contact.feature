Feature:  Contact
Actor: admin

Scenario: patient has contact number 
Given that the user is defined as "client"
And the patient has a contact number on the record 
Then the contact number exists 

Scenario: patient has no contact number 
Given that the user is defined as "client"
And the patient has no contact number 
Then set new number "3333"
