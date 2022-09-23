package com.katas.textProcessor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTests {

    @Test
    void givenLowercaseHelloAsInputText_WhenAnalysingTheText_ThenReturnsCorrectSummaryABoutTheText() {

        TextProcessor processor = new TextProcessor();
        String testInput = "hello";
        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. hello
                                
                The text has in total 1 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }

    @Test
    void givenHelloAsInputText_WhenAnalysingTheText_ThenReturnsCorrectSummaryABoutTheText() {

        TextProcessor processor = new TextProcessor();
        String testInput = "Hello";
        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. hello
                                
                The text has in total 1 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }

    @Test
    void givenHelloHellohelloAsInputText_WhenAnalysingTheText_ThenReturnsCorrectSummaryABoutTheText() {

        TextProcessor processor = new TextProcessor();
        String testInput = "Hello Hello hello";
        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. hello
                                
                The text has in total 3 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }


    @Test
    void givenHelloHellohelloByebyeHeyAsInputText_WhenAnalysingTheText_ThenReturnsCorrectOrderedSummaryABoutTheText() {

        TextProcessor processor = new TextProcessor();
        String testInput = "Hello Hello hello Bye bye Hey";
        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. hello
                2. bye
                3. hey
                                
                The text has in total 6 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }

    @Test
    void givenInputText_WhenAnalysingTheText_ThenReturnsCorrectOrderedSummaryABoutTheTextSelectFirstTenWords() {
        TextProcessor processor = new TextProcessor();
        String testInput = "";
        testInput =
                "11 11 11 11 11 11 11 11 11 11 11 11 " +
                        "0 0 0 0 0 0 0 0 0 0 0 " +
                        "1 1 1 1 1 1 1 1 1 1 " +
                        "2 2 2 2 2 2 2 2 2 " +
                        "3 3 3 3 3 3 3 3 " +
                        "4 4 4 4 4 4 4 " +
                        "5 5 5 5 5 5 " +
                        "6 6 6 6 6 " +
                        "7 7 7 7 " +
                        "8 8 8 " +
                        "9 9 " +
                        "10 " +
                        "";

        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. 11
                2. 0
                3. 1  
                4. 2
                5. 3
                6. 4
                7. 5
                8. 6
                9. 7
                10. 8
                                
                The text has in total 78 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }


    @Test
    void givenInputTextWithSymbols_WhenAnalysingTheText_ThenReturnsCorrectOrderedSummaryABoutTheTextSelectFirstTenWords() {
        TextProcessor processor = new TextProcessor();
        String testInput = "";
        testInput =
                "11 11 11 11 11 11. 11 11 11 11 11 11 " +
                        "0 0 0 0 0 0 0 0 0 0 0 " +
                        "1 1 1 1 1 1 1 1 1 1 " +
                        "2 2 2 2 2 2 2 2 2 " +
                        "3 3 3 3 3 3 3 3 " +
                        "4 4 4 4 4 4 4 " +
                        "5 5 5 5 5 5 " +
                        "6 6 6 6 6 " +
                        "7 7 7 7 " +
                        "8 8 8 " +
                        "9 9 " +
                        "10 " +
                        "";

        String expectedSummary = """
                Those are the top 10 words used:
                                
                1. 11
                2. 0
                3. 1  
                4. 2
                5. 3
                6. 4
                7. 5
                8. 6
                9. 7
                10. 8
                                
                The text has in total 78 words
                """;

        String resultSummary = processor.analyse(testInput);

        assertEquals(expectedSummary, resultSummary);


    }

}
