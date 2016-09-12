Feature: Login feature
  As a admin
  I want to see login page
  So that I can login successfully
@smoke
Scenario: Admin can login successfully
Given Admin is on login page
  When Admin enters username as"Admin" and password as "aediMNjU"
  And Andmin select login
  Then Admin should see welcome message as "Welcome Admin"
  