Feature: Invoice
 Actor: Client
 
  Background: The client has appointment list
 And here the appointments list for user1
 |1|2-11-2022|glasses for Astigmatism|
 |2|3-11-2022|glasses for Astigmatism|
 |2|3-11-2022|glasses for sun|

 @test1
 Scenario: Patient can generate an invoice for single service
 Given that the patient have an appointment on "2-11-2022"
 And the appointment has "glasses for Astigmatism" service 
 Then the invoice value is "200"
 And the invoice generated successfully
 
  @test2
 Scenario: Patient can generate an invoice for multiple services
 Given that the patient have an appointment on "3-11-2022"
 And the appointment has "glasses for Astigmatism" service and "glasses for sun" service
 Then the invoice value is the summation of "200" and "180"
 And the invoice generated successfully
 
 