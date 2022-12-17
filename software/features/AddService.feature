Feature: Add Service
 Actor: Admin

 @test1
Scenario: Admin can add a service
Given that the user is "admin"
When the admin login status is "true"
And the service existence "false"
And the price is "90" and name of service is "service"
Then the service added successfully

@test2
Scenario: Admin is not logged in
Given that the user is "admin"
When the admin login status is "false"
Then the service cannot be added successfully

@test3
Scenario: The service already exists
Given that the user is "admin"
When the admin login status is "true"
And the service existence "true"
Then the service cannot be added successfully

@test4
Scenario: The price is null
Given that the user is "admin"
When the admin login status is "true"
And the service existence "false"
And the price is "" and name of service is "service"
Then the service cannot be added successfully
