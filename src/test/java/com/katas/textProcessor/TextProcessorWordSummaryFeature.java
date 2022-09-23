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
        testInputText = "Hello, this is an example for you to practice. You should grab this text and make it as your test case.";
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
                                
                1. you
                2. this
                3. your
                4. to
                5. text
                6. test
                7. should
                8. practice
                9. make
                10. it
                                
                The text has in total 21 words
                """;
    }
}
