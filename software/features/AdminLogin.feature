Feature: Admin login
 Actor: Admin
 
 
 @test1
Scenario: Admin can login
Given that the admin is not logged in
When user is "admin"
And the password is "admin123"
Then the admin log in succeeds
And the admin is logged in


@test2
Scenario: Admin cannot login
Given that the admin is not logged in
When user is "admin"
And the password is "wrong"
Then the admin log in fails
And the admin is not logged in

