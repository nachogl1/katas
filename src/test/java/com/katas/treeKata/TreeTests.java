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
    void givenATree_WhenRunInOrderTraversalAlgorithm_ThenItReturnsElementsInIncreasingOrder() {
        List<Integer> elements = getTestElementsToBeAddedToTestTree();

        elements.forEach(newElement -> tree.add(newElement, newElement.toString()));
        List<String> resultElements = tree.inOrderTraversal();
        List<String> expectedElementsForInOrderTraversal = getExpectedElementsForInOrderTraversal(elements);

        assertEquals(expectedElementsForInOrderTraversal, resultElements);
    }

    @Test
    void givenATree_WhenRunInPreOrderTraversalAlgorithm_ThenItReturnsPreorderOrder() {
        List<Integer> elements = getTestElementsToBeAddedToTestTree();

        elements.forEach(newElement -> tree.add(newElement, newElement.toString()));
        List<String> resultElements = tree.preOrderTraversal();
        List<String> expectedElementsForPreOrderTraversal = getExpectedElementsForPreOrderTraversal();

        assertEquals(expectedElementsForPreOrderTraversal, resultElements);
    }

    @Test
    void givenATree_WhenRunInPostOrderTraversalAlgorithm_ThenItReturnsPostorderOrder() {
        List<Integer> elements = getTestElementsToBeAddedToTestTree();

        elements.forEach(newElement -> tree.add(newElement, newElement.toString()));
        List<String> resultElements = tree.postOrderTraversal();
        List<String> expectedElementsForPreOrderTraversal = getExpectedElementsForPostOrderTraversal();

        assertEquals(expectedElementsForPreOrderTraversal, resultElements);
    }

    @Test
    void givenSearchingForAKey_WhenItDoesNotExist_ThenNodeNotFoundExceptionThrown() {
        assertThrows(NodeNotFound.class, () -> {
            tree.getValueByKey(100);
        });

    }

    @Test
    void givenSearchingForAKey_WhenItExists_ThenRepeatedElementNotAllowedExceptionIsThrown() {
        tree.add(100, "100");
        assertThrows(RepeatedElementNotAllowed.class, () -> {
            tree.add(100, "100");
        });

    }

    private List<Integer> getTestElementsToBeAddedToTestTree() {
        return Arrays.asList(1, 12, 4, 65, 7, 43, 45, 34, 656, 233, 435, 2, 5, 5657);
    }

    private List<String> getExpectedElementsForPostOrderTraversal() {
        //https://yongdanielliang.github.io/animation/web/BST.html
        return Arrays.asList("2", "5", "7", "4", "34", "45", "43", "435", "233", "5657", "656", "65", "12", "1");
    }

    private List<String> getExpectedElementsForPreOrderTraversal() {
        //https://yongdanielliang.github.io/animation/web/BST.html
        return Arrays.asList("1", "12", "4", "2", "7", "5", "65", "43", "34", "45", "656", "233", "435", "5657");
    }

    private List<String> getExpectedElementsForInOrderTraversal(List<Integer> elements) {
        //https://yongdanielliang.github.io/animation/web/BST.html
        return Arrays.asList("1", "2", "4", "5", "7", "12", "34", "43", "45", "65", "233", "435", "656", "5657");
    }


}
