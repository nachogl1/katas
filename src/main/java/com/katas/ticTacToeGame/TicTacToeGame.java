package com.katas.ticTacToeGame;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeGame {

    public static final String MOVES_SEPARATOR = "\\|";
    public static final String PLAYER_SEPARATOR = ":";
    public static final String PLAYER_X = "x";
    public static final String PLAYER_O = "o";
    public static final String NO_PLAYER = "NONE";

    private String[] gameElements;
    private String firstPlayer;
    private String movesCsv;
    private String[] moves;
    private String winner;


    public void initGame(String game) {
        this.gameElements = splitPlayersFromMoves(game);
        this.firstPlayer = getFirstPlayer(gameElements);
        this.movesCsv = getMoves(gameElements);
        this.moves = splitMovesCsv(movesCsv);
        this.winner = NO_PLAYER;
    }

    public String checkWinner() throws NotSupportedException {
        if (isPlayerGetsColumn()) {
            return winner;
        }

        return NO_PLAYER;
    }

    private boolean isPlayerGetsColumn() throws NotSupportedException {
        for (int i = 0; i < moves.length; i++) {
            //i was here checking columns
        }
        throw new NotSupportedException();
    }

    public boolean isValid() {

        if (!isPlayerValid(firstPlayer)) {
            return false;
        }

        if (!isValidMoves(movesCsv)) {
            return false;
        }

        return true;
    }

    private String getMoves(String[] gameElements) {
        return gameElements[1];
    }

    private String getFirstPlayer(String[] gameElements) {
        return gameElements[0];
    }

    private String[] splitPlayersFromMoves(String game) {
        return game.split(PLAYER_SEPARATOR);
    }

    private boolean isPlayerValid(String firstPlayer) {
        return firstPlayer.equalsIgnoreCase(PLAYER_X) || firstPlayer.equalsIgnoreCase(PLAYER_O);
    }

    private boolean isValidMoves(String movesCsv) {
        if (!isMovesCorrespondToAcceptanceListOfMoves(moves)) return false;

        return true;
    }

    private boolean isMovesCorrespondToAcceptanceListOfMoves(String[] moves) {
        List<String> acceptance_list = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        List movesTickList = new ArrayList(Arrays.asList(moves));
        int deleitionCount = 0;

//        try? wtf am i doinghere?
        while (acceptance_list.size() != 0) {
            String itemToRemove = acceptance_list.get(0);
            acceptance_list.remove(itemToRemove);
            deleitionCount += movesTickList.remove(itemToRemove) ? 1 : 0;
        }

        return movesTickList.size() == 0 && deleitionCount == 9;
    }

    private String[] splitMovesCsv(String movesCsv) {
        String[] moves = movesCsv.split(MOVES_SEPARATOR);
        return moves;
    }


}
