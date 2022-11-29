package com.katas.whoLikesItKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LikeDetectorShould {

    private LikeDetector detector;

    @BeforeEach
    void setUp() {
        detector = new LikeDetector();
    }

    @Test
    void returnNoOneLikesThisIfNoLikes(){
        String[] names = {};

        String result = detector. getMessageForLikes(names);

        assertEquals("No one likes this", result);
    }

    @Test
    void returnPeterLikesThisIfPeterLikedIt(){
        String[] names = {"Peter"};

        String result = detector. getMessageForLikes(names);

        assertEquals("Peter likes this", result);
    }

    @Test
    void returnJacobAndPeterLikesThisIfJacobAndPeterLikedIt(){
        String[] names = {"Jacob","Peter"};

        String result = detector. getMessageForLikes(names);

        assertEquals("Jacob and Peter like this", result);
    }

    @Test
    void returnMarcJacobAndPeterLikesThisIfMarcJacobAndPeterLikedIt(){
        String[] names = {"Marc","Jacob","Peter"};

        String result = detector. getMessageForLikes(names);

        assertEquals("Marc, Jacob and Peter like this", result);
    }

    @Test
    void returnMarcJacob2OthersLikesThisIfMarcJacobAnd1MoreLikeIt(){
        String[] names = {"Marc","Jacob","Peter", "Pepe"};

        String result = detector. getMessageForLikes(names);

        assertEquals("Marc, Jacob and 2 others like this", result);
    }

    @Test
    void returnMarcJacobAnd3OthersLikesThisIfMarcJacobAnd3MoreLikeIt(){
        String[] names = {"Marc","Jacob","Peter", "Pepe", "Jose"};

        String result = detector. getMessageForLikes(names);

        assertEquals("Marc, Jacob and 3 others like this", result);
    }
}
