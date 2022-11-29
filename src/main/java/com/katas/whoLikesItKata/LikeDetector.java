package com.katas.whoLikesItKata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LikeDetector {
    public String getMessageForLikes(String[] names) {
        String peopleWhoLikesIt =  processNamesTogether(names);
        String likeWord = processLikeWord(names);
        String resultMessage = String.format("%s %s this", peopleWhoLikesIt, likeWord);
        return resultMessage;
    }

    private String processLikeWord(String[] names) {
        return names.length > 1 ? "like":"likes";
    }

    private String processNamesTogether(String[] names) {
        String firstName = "";
        String restOfNames = "";
        if(names.length == 0){
            return "No one";
        }
        if(names.length == 3){
            firstName = names[0] + ", ";
            restOfNames = Arrays.stream(names).skip(1).collect(Collectors.joining(" and "));
            return firstName + restOfNames;
        }
        if (names.length > 3){
            firstName = names[0] + ", "+ names[1] ;
            restOfNames =  " and "+ String.format("%d others",(names.length - 2));
            return firstName + restOfNames;
        }
        return Arrays.stream(names).collect(Collectors.joining(" and "));
    }
}
