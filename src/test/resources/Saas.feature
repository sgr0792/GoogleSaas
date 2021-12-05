Feature: test
  @SS1
  Scenario: Tests
    Given Launch the browser
    And I Launch MYSQLDB

  @SS2
  Scenario Outline: Verify the number of users and emails
    Given I Print the <username> and <email>
    Examples:
      |username  | email |
      |"Sri"       |  "Sr@g.com"  |
      |"Sri2"      |  "Sr2@h.com"  |
      |"Sri2"      |  "Sr3@h.com"  |