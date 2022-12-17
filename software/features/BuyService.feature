Feature: Paiteint buy a Service
 Actor: Client

 Background: The clinic has services and each service has a price
 And here the service/price list

 |glasses for Astigmatism|200|
 |glasses for Myopia|300|
 |Drops for dry eyes|250|
 |glasses for sun|180|
 |glasses for Farsightedness|90|
 
 
 Scenario: Patient can add service
 Given that the user is "client"
When the client login status is "true"
And the service is "Myopia glasses"  and its status "false"
Then the service is chosen successfully

 Scenario: Patient isn't logged in
 Given that the user is "client"
When the client login status is "false"
Then the service cannot be chosen successfully

 Scenario: Patient has chosen the service already
 Given that the user is "client"
When the client login status is "true"
And the service is "Myopia glasses"  and its status was "true"
Then the service is already chosen successfully

 Scenario: Patient chose more than 1 service
 Given that the user is "client"
When the client login status is "true"
And the services are "glasses for sun" and "Farsightedness glasses"  and there statuses were "true"
Then the services are chosen successfully