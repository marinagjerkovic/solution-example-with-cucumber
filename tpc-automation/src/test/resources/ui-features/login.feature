@UI @Login
Feature: Login
  # This is example of a login feature file

  Background:
    Given user is on authentication page

  Scenario: Password required message is shown when password field is empty
    And user logs in with email "marina@marina.com" and password ""
    Then first error message is shown with text "Password is required."

  Scenario Outline: Email required message is shown when email field is empty
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "An email address required."

    Examples:
      | email  | password  |
      | ""     | ""        |
      | ""     | "test"    |
      | ""     | "test123" |
      | "    " | "test123" |

  Scenario Outline: My account page is shown when login is successful
    When user logs in with email <email> and password <password>
    Then user should be navigated to my account page

    Examples:
      | email                     | password        |
      | "marina@marina.com"       | "test111"       |
      | "   petric@petric.com   " | "test111"       |
      | "marina@marina.com"       | "   test111   " |

  Scenario Outline: Authentication failed message is shown
  when user is not registered with given email
  or when password is incorrect for given email

    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Authentication failed."

    Examples:
      | email                         | password             |
      | "notregisteredemail@test.com" | "test111"            |
      | "marina@marina.com"           | "incorrect_password" |

  Scenario Outline: Invalid email message is shown when email has incorrect format
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Invalid email address."

    Examples:
      | email           | password  |
      | "marina@marina" | ""        |
      | "marina@marina" | "test"    |
      | "marina@marina" | "test111" |

  Scenario Outline: Invalid password message is shown when password has invalid format
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Invalid password."

    Examples:
      | email                         | password |
      | "marina@marina.com"           | "1234"   |
      | "notregisteredemail@test.com" | "1234"   |

