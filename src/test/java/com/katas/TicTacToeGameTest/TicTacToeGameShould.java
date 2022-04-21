package com.katas.TicTacToeGameTest;

import com.katas.ticTacToeGame.TicTacToeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeGameShould {

    private TicTacToeGame ticTacToeGame;

    @BeforeEach
    void setUp() {
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    void finish_with_draw_with_all_cells_taken() throws Exception {
        ticTacToeGame.moveUserToPosition("O",1);
        ticTacToeGame.moveUserToPosition("O",2);
        ticTacToeGame.moveUserToPosition("X",3);
        ticTacToeGame.moveUserToPosition("X",4);
        ticTacToeGame.moveUserToPosition("X",5);
        ticTacToeGame.moveUserToPosition("O",6);
        ticTacToeGame.moveUserToPosition("O",7);
        ticTacToeGame.moveUserToPosition("X",8);
        ticTacToeGame.moveUserToPosition("X",9);

        boolean resultIsFinished = ticTacToeGame.isFinished();
        String resultWinner = ticTacToeGame.getWinner();

        assertThat(resultIsFinished).isTrue();
        assertThat(resultWinner).isEqualTo("NONE");

    }

    @Test
    void finish_if_player_gets_column() throws Exception {
        ticTacToeGame.moveUserToPosition("X", 1);
        ticTacToeGame.moveUserToPosition("X", 4);
        ticTacToeGame.moveUserToPosition("X", 7);

        boolean resultIsFinished = ticTacToeGame.isFinished();
        String resultWinner = ticTacToeGame.getWinner();

        assertThat(resultIsFinished).isTrue();
        assertThat(resultWinner).isEqualTo("X");

    }
}
