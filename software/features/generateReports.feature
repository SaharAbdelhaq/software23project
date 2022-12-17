Feature: Admin generates reports
 Actor: Administrator
 Description: The admin can generate needed reports
 
 @test1
 Scenario: Admin wants to generate patients' names report
 Given that the admin is logged in is "true" now
 And he generated all patients' names
 Then the report generated successfully
 
 @test2
  Scenario: Admin wants to generate patients' names report with their appointments details
 Given that the admin is logged in is "true" now
 And he generated all patients' names and their appointments details
 Then the report generated successfully
 
  Scenario: Admin wants to generate report
 Given that the admin is not logged in is "false" now
 Then the report cannot be generated successfully