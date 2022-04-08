package com.katas.anagramsGeneratorTests;

import com.katas.AnagramsGenerator.AnagramsGeneratorV1;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
 class AnagramsGeneratorV1Should {

    @Test
    public void return_cab_when_rotating_1_in_abc() {
        AnagramsGeneratorV1 anagramsGenerator = new AnagramsGeneratorV1();

        String result = anagramsGenerator.rotateString("abc", 1);

        assertThat(result).isEqualTo("cab");

    }

    @Test
    public void return_bca_when_rotating_2_in_abc() {
        AnagramsGeneratorV1 anagramsGenerator = new AnagramsGeneratorV1();

        String result = anagramsGenerator.rotateString("abc", 2);

        assertThat(result).isEqualTo("bca");

    }

    @Test
    public void return_cdefab_when_rotating_minus_2_in_abcdef() {
        AnagramsGeneratorV1 anagramsGenerator = new AnagramsGeneratorV1();

        String result = anagramsGenerator.rotateString("abcdef", -2);

        assertThat(result).isEqualTo("cdefab");

    }

    @Test
    public void return_all_possible_rotations_for_given_string() {
        AnagramsGeneratorV1 anagramsGenerator = new AnagramsGeneratorV1();

        String str = "bio";
        List<String> resultAllRotatedPossibilitiesList = anagramsGenerator.getAllPossibleRotationsForString(str);
        String[] expectedAllRotatedPossibilitiesArray = {"bio", "obi", "iob"};
        List<String> expectedAllRotatedPossibilitiesList = Arrays.asList(expectedAllRotatedPossibilitiesArray);

        assertThat(resultAllRotatedPossibilitiesList).containsExactlyElementsOf(expectedAllRotatedPossibilitiesList);
    }

    @Test
    public void return_correct_anagrams_for_word_bio() throws Exception {
        AnagramsGeneratorV1 anagramsGenerator = new AnagramsGeneratorV1();

        List<String> resultListOfAngrams = anagramsGenerator.getAnagramsListFromString("bio");
        String[] expectedArrayOfAngrams = {"bio", "boi", "oib", "obi", "iob", "ibo"};
        List<String> expectedListOfAnagrams = Arrays.asList(expectedArrayOfAngrams);

        assertThat(resultListOfAngrams).containsExactlyInAnyOrderElementsOf(expectedListOfAnagrams);
    }

}
