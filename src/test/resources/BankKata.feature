Feature: Bank Kata requested feature by the Kata Statement at https://www.codurance.com/katalyst/bank

  Scenario: User perform different actions and the correct bank statement is printed
    Given Pre-defined trail of user actions
    When Using a Personal Account on ATM Machine
    Then The system prints the correct bank statement