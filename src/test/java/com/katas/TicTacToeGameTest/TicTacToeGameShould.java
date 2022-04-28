package com.katas.TicTacToeGameTest;

import com.katas.ticTacToeGame.TicTacToeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class TicTacToeGameShould {

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    private TicTacToeGame ticTacToeGame;

    @BeforeEach
    void setUp() {
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    void return_player_X_as_the_winner_of_the_first_column() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 4);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);

        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_O_as_the_winner_of_the_first_column() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 4);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 7);

        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_O_as_the_winner_of_the_second_column() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);

        ticTacToeGame.checkRules();


        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }


    @Test
    void return_player_X_as_the_winner_of_the_third_column() {
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 6);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 9);

        ticTacToeGame.checkRules();


        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_X_as_the_winner_of_the_first_row() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 4);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);

        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_player_O_as_the_winner_of_the_third_row() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 7);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 9);

        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_O_as_the_winner_of_top_left_to_right_diagonal() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 9);
        ticTacToeGame.checkRules();


        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("O");
    }

    @Test
    void return_player_X_as_the_winner_of_top_right_to_left_diagonal() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);
        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("X");
    }

    @Test
    void return_none_if_no_winner() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 1);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 4);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 3);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 5);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 6);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 7);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 8);
        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 9);
        ticTacToeGame.checkRules();

        boolean isGameDone = ticTacToeGame.isGameDone();
        String winner = ticTacToeGame.getWinner();

        assertThat(isGameDone).isTrue();
        assertThat(winner).isEqualTo("NONE");
    }

    @Test()
    void return_exception_if_cell_taken() {

        ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_X, 2);

        assertThatIllegalStateException().isThrownBy(() -> {
            ticTacToeGame.makeMoveFor(TicTacToeGameShould.PLAYER_O, 2);
        });

    }


}
