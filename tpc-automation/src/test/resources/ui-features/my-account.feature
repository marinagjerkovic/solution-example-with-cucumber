@UI @MyAccount
Feature: My account

  Background: User is logged in and on my account page
    Given user is on authentication page
    When user logs in with email "marina@marina.com" and password "test111"
    Then user should be navigated to my account page

  Scenario: Check that users's name and lastname are shown in header menu
    Then user's name "Marina" and lastname "Petrovic" are shown in header

  Scenario: Check that page title is correct
    Then page title has text "My account - My Store"