Feature: Login Functionality

  @Login @Test
  Scenario: User is able to access Login page by accessing home url
    Given User access Home Page by URL
    Then User is navigated to Login Page

  @Login @ForgotPassword
  Scenario: User is able to access Forgot Password page by clicking on link
    Given User access Home Page by URL
    Then User is navigated to Login Page
    When User click on Forgot Password link
    Then User is navigated to Forgot Password page

  @Login @WrongCredential
  Scenario Outline: User is not able to log in when user input wrong credentials
    Given User access Home Page by URL
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<password>"
    And User click Login button
    Then Error message about Wrong Credential shown

    Examples:
      | email                         | password        |
      | maycellineselvyanti@gmail.com | mariamaycelline |

  @Login @WrongEmailFormat
  Scenario Outline: User is not able to log in when user input wrong email address format
    Given User access Home Page by URL
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<password>"
    Then Error message about Wrong Email Format shown

    Examples:
      | email                         | password        |
      | maycellineselvyant            | mariamaycelline |

  @Login @EmptyValue
  Scenario Outline: User is not able to log in when user input empty value
    Given User access Home Page by URL
    Then User is navigated to Login Page
    When User enter email field with value "<email>"
    And User enter password field with value "<password>"
    Then Error message about Empty Value shown

    Examples:
      | email                         | password        |
      |                               | mariamaycelline |
      | maycellineselvyanti@gmail.com |                 |