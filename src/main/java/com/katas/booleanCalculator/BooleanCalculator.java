package com.katas.booleanCalculator;

import static java.lang.String.format;

public class BooleanCalculator {

    public static final String OR = "OR";
    public static final String AND = "AND";
    public static final String NOT = "NOT";
    public static final String RIGHT_PARENTHESIS = "(";
    public static final String LEFT_PARENTHESIS = ")";

    public boolean process(String input) {

        //Temporal coupling
        //Too many ifs everywhere
        if (input.contains(RIGHT_PARENTHESIS)) {
            return extractContentOfParenthesis(input);
        }

        if (input.contains(OR)) {
            return processOperand(input, OR);
        }

        if (input.contains(AND)) {
            return processOperand(input, AND);
        }

        if (input.contains(NOT)) {
            return processNOTs(input);
        }

        return computeAnswer(input);

    }

    private boolean extractContentOfParenthesis(String input) {
        int rightParenthesisIndex = input.indexOf(RIGHT_PARENTHESIS);//(
        var leftParenthesisIndex = 0;//)
        var numberOfProcessedRightParenthesis = 0;

        for (int i = rightParenthesisIndex; i < input.length(); i++) {
            String characterUnderAnalysis = String.valueOf(input.charAt(i));

            if (characterUnderAnalysis.equals(RIGHT_PARENTHESIS)) {
                numberOfProcessedRightParenthesis++;
            }

            if (characterUnderAnalysis.equals(LEFT_PARENTHESIS)) {
                numberOfProcessedRightParenthesis--;
            }

            if (numberOfProcessedRightParenthesis == 0) {
                leftParenthesisIndex = i;
                break;
            }

        }

        var resultString = input.substring(rightParenthesisIndex + 1, leftParenthesisIndex);
        var finalString = input.replace(format("(%s)", resultString), Boolean.toString(this.process(resultString)));
        return this.process(finalString);
    }

    private boolean computeAnswer(String input) {
        boolean boolResult;
        boolResult = Boolean.valueOf(input.trim());
        return boolResult;
    }

    private boolean processNOTs(String input) {
        String targetString = extractPartAfterNOTWord(input);
        boolean boolResult1 = this.process(targetString);

        return !boolResult1;
    }

    private String extractPartAfterNOTWord(String input) {
        return input.split(NOT, 2)[1];
    }

    private boolean processOperand(String input, String operand) {
        String[] inputParts = input.split(operand, 2);

        boolean beforeOperand = this.process(inputParts[0]);
        boolean afterOperand = this.process(inputParts[1]);

        return operand.equals(OR) ? beforeOperand || afterOperand : beforeOperand && afterOperand;
    }
}
