Feature: Login Functionality

  @Login @Test
  Scenario: User is able to access Login page by accessing home url
    Given User access Home Page by URL
    Then User is navigated to Login Page

  @Login @WrongCredential
  Scenario: User is not able to log in when user input wrong credentials
    Given User is on Landing Page
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<password>"
    And User click Login button
    Then Error message about Wrong Credential shown

  @Login @WrongEmailFormat
  Scenario: User is not able to log in when user input wrong email address format
    Given User is on Landing Page
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<password>"
    And User click Login button
    Then Error message about Wrong Email Format shown

  @Login @EmptyValue
  Scenario: User is not able to log in when user input empty value
    Given User is on Landing Page
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<pasword>"
    And User click Login button
    Then Error message about Empty Value shown