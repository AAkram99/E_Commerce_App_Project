@smoke
  Feature: F02_Login | users could use login functionality to use their accounts
    Scenario: user could login with valid email and password
      Given user go to login page
      When user login with "valid" "testtt@example.com" and "P@ssworddd" as email and password
      And user press on login button
      Then user login to the system successfully


    Scenario: user could not login with invalid email and password
      Given user go to login page
      When user login with "invalid" "wrong@example.com" and "P@ssworddd" as email and password
      And user press on login button
      Then user could not login to the system