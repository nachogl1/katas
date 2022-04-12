package com.katas.shorcutGolfTests;

import com.katas.RomanNumberParserV1.RomanNumberParserSG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberParserSGShould {

    private RomanNumberParserSG romanNumberParser;

    @BeforeEach
    void setUp() {
        romanNumberParser = new RomanNumberParserSG();
    }

    @Test
    void return_II_when_parsing_2() {
        String result = romanNumberParser.parse(2);
        assertThat(result).isEqualTo("II");
    }


    @ParameterizedTest
    @CsvSource({ "1,I", "2,II", "4,IV","5,V","9,IX","10,X","11,XI","15,XV","2687,MMDCLXXXVII", "3499,MMMCDXCIX" })
    void return_target_from_source( int source, String target) {
        String result = romanNumberParser.parse(source);
        assertThat(result).isEqualTo(target);
    }
}
