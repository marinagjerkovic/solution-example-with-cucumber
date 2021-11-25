@Api
Feature: Manipulating countries

  Scenario Outline: Check that language is correct for country
    Given send request for getting country with code <code>
    Then country in response has language <language>
    And country in response has phone <phone>

    Examples:
      | code | language  | phone |
      | "RS" | "Serbian" | "381"   |
      | "US" | "English" | "1" |