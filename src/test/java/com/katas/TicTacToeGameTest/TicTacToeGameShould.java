package com.katas.TicTacToeGameTest;

import com.katas.ticTacToeGame.TTTGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class TicTacToeGameShould {

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    private TTTGame tttGame;

    @BeforeEach
    void setUp() {
        tttGame = new TTTGame();
    }

    @Test
    void return_player_X_as_the_winner_of_the_first_column() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 4);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);

        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_O_as_the_winner_of_the_first_column() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 4);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 7);

        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_O_as_the_winner_of_the_second_column() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);

        tttGame.checkRules();


        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }


    @Test
    void return_player_X_as_the_winner_of_the_third_column() {
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 6);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 9);

        tttGame.checkRules();


        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_X_as_the_winner_of_the_first_row() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 4);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);

        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_O_as_the_winner_of_the_third_row() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 7);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 9);

        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_O_as_the_winner_of_top_left_to_right_diagonal() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 9);
        tttGame.checkRules();


        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_X_as_the_winner_of_top_right_to_left_diagonal() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);
        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_none_if_no_winner() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 4);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 3);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 5);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 6);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);
        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 9);
        tttGame.checkRules();

        boolean isGameDone = tttGame.isGameDone();
        String winner = tttGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("NONE");
    }

    @Test()
    void return_exception_if_cell_taken() {

        tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);

        assertThatIllegalStateException().isThrownBy(() -> {
            tttGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        });

    }


}
