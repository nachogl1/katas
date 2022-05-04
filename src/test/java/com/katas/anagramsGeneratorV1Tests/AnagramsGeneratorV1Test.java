package com.katas.anagramsGeneratorV1Tests;

import com.katas.AnagramsGeneratorV1.AnagramsGeneratorV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramsGeneratorV1Test {

    private AnagramsGeneratorV1 anagramsGenerator;

    @BeforeEach
    void setUp() {
        anagramsGenerator = new AnagramsGeneratorV1();
    }

    @Test
    public void return_cab_when_rotating_1_in_miau() {

        String result = anagramsGenerator.rotateString("miau", 1);

        assertThat(result).isEqualTo("umia");

    }

    @Test
    public void return_bca_when_rotating_2_in_abc() {

        String result = anagramsGenerator.rotateString("abc", 2);

        assertThat(result).isEqualTo("bca");

    }

    @Test
    public void return_cdefab_when_rotating_minus_2_in_abcdef() {

        String result = anagramsGenerator.rotateString("miau", -2);

        assertThat(result).isEqualTo("aumi");

    }

    @Test
    public void return_all_possible_rotations_for_given_string() {

        String str = "bio";
        List<String> resultAllRotatedPossibilitiesList = anagramsGenerator.getAllPossibleRotationsForString(str);
        String[] expectedAllRotatedPossibilitiesArray = {"bio", "obi", "iob"};
        List<String> expectedAllRotatedPossibilitiesList = Arrays.asList(expectedAllRotatedPossibilitiesArray);

        assertThat(resultAllRotatedPossibilitiesList).containsExactlyElementsOf(expectedAllRotatedPossibilitiesList);
    }

    @Test
    public void return_correct_anagrams_for_word_bio() throws Exception {

        List<String> resultListOfAngrams = anagramsGenerator.getAnagramsListFromString("bio");
        String[] expectedArrayOfAngrams = {"bio", "boi", "oib", "obi", "iob", "ibo"};
        List<String> expectedListOfAnagrams = Arrays.asList(expectedArrayOfAngrams);

        assertThat(resultListOfAngrams).containsExactlyInAnyOrderElementsOf(expectedListOfAnagrams);
    }

}
