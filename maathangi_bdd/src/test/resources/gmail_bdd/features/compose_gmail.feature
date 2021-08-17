Feature: Compose and send an email to Incubyte
  Scenario: Login to Gmail with valid credentials, Compose and Send an email
    Given user visits gmail webpage
    And enters username "maathu.qa@gmail.com" and password as "abcd1@34" to login successfully
    When email is composed and sent to abc@incubyte.com with subject 'Incubyte' and body 'Automation QA test for Incubyte'
    Then last sent email appears in the sent box with subject 'Incubyte'