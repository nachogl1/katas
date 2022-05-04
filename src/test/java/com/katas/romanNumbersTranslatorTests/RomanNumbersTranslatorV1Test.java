package com.katas.romanNumbersTranslatorTests;

import com.katas.RomanNumberParserV1.RomanNumberParserV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(OrderAnnotation.class)
public class RomanNumbersTranslatorV1Test {

    RomanNumberParserV1 romanNumberParser;

    @BeforeEach
    void setUp() {
        romanNumberParser = new RomanNumberParserV1();
    }

    @Test
    @Order(1)
    void return_I_for_1() {
        String result = romanNumberParser.convert(1);

        assertThat(result).isEqualTo("I");
    }

    @Test
    @Order(2)
    void return_II_for_2() {
        String result = romanNumberParser.convert(2);

        assertThat(result).isEqualTo("II");
    }

    @Test
    @Order(3)
    void return_IV_for_4() {
        String result = romanNumberParser.convert(4);

        assertThat(result).isEqualTo("IV");
    }
    @Test
    @Order(4)
    void return_V_for_5() {
        String result = romanNumberParser.convert(5);

        assertThat(result).isEqualTo("V");
    }
    @Test
    @Order(5)
    void return_VI_for_6() {
        String result = romanNumberParser.convert(6);

        assertThat(result).isEqualTo("VI");
    }
    @Test
    @Order(6)
    void return_VII_for_7() {
        String result = romanNumberParser.convert(7);

        assertThat(result).isEqualTo("VII");
    }
    @Test
    @Order(7)
    void return_VIII_for_8() {
        String result = romanNumberParser.convert(8);

        assertThat(result).isEqualTo("VIII");
    }
    @Test
    @Order(8)
    void return_IX_for_9() {
        String result = romanNumberParser.convert(9);

        assertThat(result).isEqualTo("IX");
    }
    @Test
    @Order(9)
    void return_X_for_10() {
        String result = romanNumberParser.convert(10);

        assertThat(result).isEqualTo("X");
    }
    @Test
    @Order(10)
    void return_XI_for_11() {
        String result = romanNumberParser.convert(11);

        assertThat(result).isEqualTo("XI");
    }
    @Test
    @Order(11)
    void return_XV_for_15() {
        String result = romanNumberParser.convert(15);

        assertThat(result).isEqualTo("XV");
    }
    @Test
    @Order(12)
    void return_XVI_for_16() {
        String result = romanNumberParser.convert(16);

        assertThat(result).isEqualTo("XVI");
    }
    @Test
    @Order(13)
    void return_XIV_for_14() {
        String result = romanNumberParser.convert(14);

        assertThat(result).isEqualTo("XIV");
    }
    @Test
    @Order(14)
    void return_XL_for_40() {
        String result = romanNumberParser.convert(40);

        assertThat(result).isEqualTo("XL");
    }
    @Test
    @Order(15)
    void return_XC_for_90() {
        String result = romanNumberParser.convert(90);

        assertThat(result).isEqualTo("XC");
    }

    @Test
    @Order(16)
    void return_MMDCLXXXVII_for_2687() {
        String result = romanNumberParser.convert(2687);

        assertThat(result).isEqualTo("MMDCLXXXVII");
    }
    @Test
    @Order(16)
    void return_MMMCDXCIX_for_3499() {
        String result = romanNumberParser.convert(3499);

        assertThat(result).isEqualTo("MMMCDXCIX");
    }
}
