package com.katas.camelCaseParser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserShould {

    @Test
    void returnMiauWhenMiauIsInput() {
        CamelCaseParser parser = new CamelCaseParser();
        Assertions.assertEquals("Miau", parser.parse("Miau"));
    }


    @Test
    void returnmiauWhenmiauIsInput() {
        CamelCaseParser parser = new CamelCaseParser();
        Assertions.assertEquals("miau", parser.parse("miau"));
    }


    @Test
    void returntheStealthWarriorWhenthe_stealth_warriorIsInput() {
        CamelCaseParser parser = new CamelCaseParser();
        Assertions.assertEquals("theStealthWarrior", parser.parse("the_stealth_warrior"));
    }

    @Test
    void returnTheStealthWarriorWhenThe_stealth_warriorIsInput() {
        CamelCaseParser parser = new CamelCaseParser();
        Assertions.assertEquals("TheStealthWarrior", parser.parse("The_stealth_warrior"));
    }
}

