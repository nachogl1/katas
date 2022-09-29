package com.katas.textProcessor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorWordSummaryFeature {

    TextProcessor processor;
    String testInputText;
    String resultSummary;
    String expectedSummary;

    @Given("the pre-defined test input text")
    public void thePreDefinedTestInputText() {
        processor = new TextProcessor();
        testInputText = "Hello, hello, hello, Bye bye, Example";
    }

    @When("the system analyses the text")
    public void theSystemAnalysesTheText() {
        this.resultSummary = this.processor.analyse(this.testInputText);

    }

    @Then("The system should output the correct summary about that text")
    public void theSystemShouldOutputTheCorrectSummaryAboutThatText() {
        this.expectedSummary = getExpectedSummary();
        assertEquals(this.expectedSummary, resultSummary);
    }

    private String getExpectedSummary() {
        return """
                Those are the top 10 words used:
                                
                1. hello
                2. bye
                3. example
                                
                The text has in total 6 words
                """;
    }
}
