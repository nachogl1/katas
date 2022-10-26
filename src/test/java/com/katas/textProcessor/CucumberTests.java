package com.katas.textProcessor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:TextProcessorWordSummary.feature"},
        glue = {"com.katas.textProcessor"})
public class CucumberTests {
}
