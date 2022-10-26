package com.katas.bank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:BankKata.feature"},
        glue = {"com.katas.bank"})
public class CucumberTests {
}
