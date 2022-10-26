package com.katas.smartFridge;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:SmartFridgeWithoutClosingOpenFeature.feature"},
        glue = {"com.katas.smartFridge"})
public class CucumberTests {
}
