Feature: Register.

Background:
  Given I have cleared the database

Scenario: Register
  Given I've moved to the register page
  When I fill the registration form with username "user" and password "password" and "password",name "Jan" and adress "ul. Kolorowa" and I submit it
  Then I should see the login page