Feature: BookBazzar Application Demo

  Background: 
    Given user click on the login link
@sanity
  Scenario: Login should be Success
    And user enter the userName as "8667864738"
    And user enter the Password as "Yogesh123"
    When user click on the login btn
    Then user name will be updated
@smoke @sanity
  Scenario: Login should be Fail
    And user enter the userName as "1236985471"
    And user enter the Password as "Yogesh"
    When user click on the login btn
    Then login should be fail
