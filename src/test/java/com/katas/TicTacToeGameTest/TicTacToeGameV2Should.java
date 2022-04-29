package com.katas.TicTacToeGameTest;

import com.katas.ticTacToeGame.SpaceAlreadyUsedException;
import com.katas.ticTacToeGame.TicTacToeGameV2;
import com.katas.ticTacToeGame.TicTacToeV2Status;
import com.katas.ticTacToeGame.TicTacToeV2Symbology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.katas.ticTacToeGame.TicTacToeV2Status.*;
import static com.katas.ticTacToeGame.TicTacToeV2Symbology.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeGameV2Should {

    private TicTacToeGameV2 ticTacToeGameV2;

    @BeforeEach
    void setUp() {
        ticTacToeGameV2 = new TicTacToeGameV2();
    }

    @Test
    void publishNotStartedIfNoMoves() {

        TicTacToeV2Status status = ticTacToeGameV2.publishCurrentResult();

        assertThat(status).isEqualTo(NOT_STARTED);
    }

    @Test
    void publishOngoingStatusIfPlayersStartedToPlay() {

        ticTacToeGameV2.makeMove(0, 0);
        TicTacToeV2Status status = ticTacToeGameV2.publishCurrentResult();

        assertThat(status).isEqualTo(ONGOING);
    }

    @Test
    void returnCorrectGridForPlayerOneToBeInCell0_0() {

        TicTacToeV2Symbology[][] gameGrid = ticTacToeGameV2.makeMove(0, 0);

        assertThat(gameGrid).contains(new TicTacToeV2Symbology[]{PLAYER_ONE, EMPTY, EMPTY}, atIndex(0));

    }

    @Test
    void returnCorrectGridForPlayerTwoToBeInCell0_1() {

        ticTacToeGameV2.makeMove(0, 0);
        TicTacToeV2Symbology[][] gameGrid = ticTacToeGameV2.makeMove(0, 1);

        assertThat(gameGrid).contains(new TicTacToeV2Symbology[]{PLAYER_ONE, PLAYER_TWO, EMPTY}, atIndex(0));

    }

    @Test
    void returnCorrectWinnerForPlayerOneCompletingFirstRow() {

        ticTacToeGameV2.makeMove(0, 0);
        ticTacToeGameV2.makeMove(1, 0);
        ticTacToeGameV2.makeMove(0, 1);
        ticTacToeGameV2.makeMove(1, 1);
        ticTacToeGameV2.makeMove(0, 2);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(PLAYER_ONE_WIN);

    }

    @Test
    void returnCorrectWinnerForPlayerTwoCompletingFirstRow() {

        ticTacToeGameV2.makeMove(1, 0);
        ticTacToeGameV2.makeMove(0, 0);
        ticTacToeGameV2.makeMove(1, 2);
        ticTacToeGameV2.makeMove(0, 1);
        ticTacToeGameV2.makeMove(2, 0);
        ticTacToeGameV2.makeMove(0, 2);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(PLAYER_TWO_WIN);

    }

    @Test
    void returnCorrectWinnerForPlayerTwoCompletingFirstColumn() {

        ticTacToeGameV2.makeMove(1, 0);
        ticTacToeGameV2.makeMove(0, 0);
        ticTacToeGameV2.makeMove(1, 2);
        ticTacToeGameV2.makeMove(0, 1);
        ticTacToeGameV2.makeMove(2, 2);
        ticTacToeGameV2.makeMove(0, 2);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(PLAYER_TWO_WIN);

    }

    @Test
    void returnCorrectWinnerForPlayerTwoCompletingRightDiagonal() {

        ticTacToeGameV2.makeMove(1, 0);
        ticTacToeGameV2.makeMove(0, 0);
        ticTacToeGameV2.makeMove(1, 2);
        ticTacToeGameV2.makeMove(1, 1);
        ticTacToeGameV2.makeMove(2, 0);
        ticTacToeGameV2.makeMove(2, 2);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(PLAYER_TWO_WIN);

    }

    @Test
    void returnCorrectWinnerForPlayerOneCompletingLeftDiagonal() {

        ticTacToeGameV2.makeMove(0, 2);
        ticTacToeGameV2.makeMove(0, 1);
        ticTacToeGameV2.makeMove(1, 1);
        ticTacToeGameV2.makeMove(2, 1);
        ticTacToeGameV2.makeMove(2, 0);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(PLAYER_ONE_WIN);

    }

    @Test
    void returnErrorWhenRepeatingCell() {

        ticTacToeGameV2.makeMove(0, 2);
        assertThrows(SpaceAlreadyUsedException.class, () -> ticTacToeGameV2.makeMove(0, 2));


    }

    @Test
    void returnDrawnIfNotWinner() {

        ticTacToeGameV2.makeMove(0, 0);
        ticTacToeGameV2.makeMove(0, 2);
        ticTacToeGameV2.makeMove(1, 0);
        ticTacToeGameV2.makeMove(1, 2);
        ticTacToeGameV2.makeMove(0, 1);
        ticTacToeGameV2.makeMove(2, 0);
        ticTacToeGameV2.makeMove(1, 1);
        ticTacToeGameV2.makeMove(2, 1);
        ticTacToeGameV2.makeMove(2, 2);

        assertThat(ticTacToeGameV2.publishCurrentResult()).isEqualTo(DRAWN);


    }

}
