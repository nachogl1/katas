package com.katas.treeKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TreeTests {

    private MyTree<String> tree;

    @BeforeEach
    void setUp() {
        tree = new MyTree();
    }

    @Test
    void givenNewEntryAdded_WhenSearchingThatEntryKey_ThenTheValueCorrespondsToTheCorrectKey() {
        String element0 = "0";
        int key0 = 0;

        tree.add(key0, element0);
        String expectedValue = tree.getValueByKey(key0);

        assertEquals(element0, expectedValue);
    }

    @Test
    void givenThreeNewEntriesAdded_WhenSearchingEntriesByKey_ThenTheValueCorrespondsToTheCorrectKey() {
        int key0 = 0;
        int key1 = 7;
        int key2 = 3;
        String element0 = "0";
        String element1 = "7";
        String element2 = "3";
        List<String> expectedResults = Arrays.asList(element0, element1, element2);
        List<String> resultList = new ArrayList<>();

        tree.add(key0, element0);
        tree.add(key1, element1);
        tree.add(key2, element2);
        resultList.add(tree.getValueByKey(key0));
        resultList.add(tree.getValueByKey(key1));
        resultList.add(tree.getValueByKey(key2));

        assertEquals(expectedResults, resultList);
    }

    @Test
    void givenSearchingForAKey_WhenItDoesNotExist_ThenCorrectExceptionThrown() {
        assertThrows(NodeNotFound.class, () -> {
            tree.getValueByKey(100);
        });

    }


}
