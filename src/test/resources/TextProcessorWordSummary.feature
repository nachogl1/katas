Feature: As a developer that writes blog posts I want a tool that helps me to understand better the text I am writing. For that I need a way to know the following:

  What are the most common words used in the text?
  How many characters does the text have?

  Scenario: Text analysis return the correct summary about the text itself
    Given the pre-defined test input text
    When the system analyses the text
    Then The system should output the correct summary about that text