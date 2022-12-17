Feature: Client login
 Actor: Client
 Description: The client login to the system
 Background: The clinic has clients
 And these are the users
 |user1|pass1|
 |user2|pass2|
 |user3|pass3|
  
Scenario: client can login
Given that the client "user1" is not logged in
When type is client
And user name is "user1" and the password is "pass1"
Then the client log in succeeds
And the client is logged in

Scenario: client cannot login
Given that the client "user1" is not logged in
When type is client
And user name is "user1" and the password is "wrongpass"
Then the client log in fails
And the client is not logged in