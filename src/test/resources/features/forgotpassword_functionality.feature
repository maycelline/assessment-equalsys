Feature: Forgot Password Functionality

  @ForgotPassword
  Scenario: User is able to access Forgot Password page by Url
    Given User access Forgot Password page by URL
    Then User is navigated to Forgot Password page

  @ForgotPassword @EmptyEmail
  Scenario: User is not able to reset password if the email is empty
    Given User access Forgot Password page by URL
    Then User is navigated to Forgot Password page
    When User enter email field with value "" in Forgot Password page
    Then Error message about Empty Value in Forgot Password page shown

  @ForgotPassword @WrongEmailFormat
  Scenario: User is not able to reset password with wrong email format
    Given User access Forgot Password page by URL
    Then User is navigated to Forgot Password page
    When User enter email field with value "maycellineselvyantii" in Forgot Password page
    Then Error message about Empty Value in Forgot Password page shown

  @ForgotPassword @Valid
  Scenario: User is able to reset password with valid value
    Given User access Forgot Password page by URL
    Then User is navigated to Forgot Password page
    When User enter email field with value "maycellineselvyanti@gmail.com" in Forgot Password page
    And User check captcha box
    And User click Submit button
#    Note: it is because i dont have any access to the website.
    Then Error message shown that email is not registered
