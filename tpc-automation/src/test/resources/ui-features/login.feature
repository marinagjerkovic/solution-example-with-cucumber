@UI @Login
Feature: Login

  Scenario Outline: Check that my account page is shown when login is successful
    Given user is on authentication page
    When user logs in with email <email> and password <password>
    Then user is navigated to my account page

    Examples:
      | email                   | password  |
      | "marina@marina.com"     | "test111" |
      | "petric@petric.com"     | "test111" |
      | "  marina@marina.com  " | "test111" |

  Scenario Outline: Check that authentication failed message is shown
  when user is not registered with given email
  or when password is incorrect for given email

    Given user is on authentication page
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Authentication failed."

    Examples:
      | email                         | password             |
      | "notregisteredemail@test.com" | "test111"            |
      | "marina@marina.com"           | "incorrect_password" |

  Scenario Outline: Check that invalid email message is shown when email has incorrect format
    Given user is on authentication page
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Invalid email address."

    Examples:
      | email           | password  |
      | "marina@marina" | ""        |
      | "marina@marina" | "test"    |
      | "marina@marina" | "test111" |

  Scenario Outline: Check that email required message is shown when email field is empty
    Given user is on authentication page
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "An email address required."

    Examples:
      | email | password  |
      | ""    | ""        |
      | ""    | "test"    |
      | ""    | "test123" |

  Scenario Outline: Check that invalid password message is shown when password has invalid format
    Given user is on authentication page
    When user logs in with email <email> and password <password>
    Then first error message is shown with text "Invalid password."

    Examples:
      | email                         | password |
      | "marina@marina.com"           | "1234"   |
      | "notregisteredemail@test.com" | "1234"   |

  @Tag
  Scenario: Check that password required message is shown when password field is empty
    Given user is on authentication page
    When user logs in with email "marina@marina.com" and password ""
    Then first error message is shown with text "Password is required."

