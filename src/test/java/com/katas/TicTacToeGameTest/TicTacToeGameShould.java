package com.katas.TicTacToeGameTest;

import com.katas.ticTacToeGame.TicTacToeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.transaction.NotSupportedException;

import static org.assertj.core.api.Assertions.assertThat;

//OLD
public class TicTacToeGameShould {
//quick win not detected..
    //too many elemtns in my class
    public static final String SEPARATOR = ":";
    public static final String NO_PLAYER = "NONE";
    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    private TicTacToeGame ticTacToeGame;

    @BeforeEach
    void setUp() {
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    void return_true_if_game_valid() {

        String moves = "1|2|3|4|5|6|7|8|9";

        String game = PLAYER_X + SEPARATOR + moves;
        ticTacToeGame.initGame(game);
        boolean result = ticTacToeGame.isValid();

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"X,1|2|3|4|5|6|7|8|9|1", "X,1|2|3|4|5|6|7|8", "M,1|2|3|4|5|6|7|8|9", "X,1|2|3|4|5|6|7|8|P", "X,1|2|3|4|5|6|7|.|9", "X,1|2|3|4|5|6|7|8|8"})
    void return_false_if_game_not_valid(String firstPlayerToMove, String moves) {

        String game = firstPlayerToMove + SEPARATOR + moves;

        ticTacToeGame.initGame(game);
        boolean result = ticTacToeGame.isValid();

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"O,1|2|4|3|7|5|8|6|9"})
    void be_valid_and_return_winner_if_column_completed(String firstPlayerToMove, String moves) throws NotSupportedException {
        String game = firstPlayerToMove + SEPARATOR + moves;

        ticTacToeGame.initGame(game);
        boolean result = ticTacToeGame.isValid();
        String winner = ticTacToeGame.checkWinner();

        assertThat(result).isTrue();
        assertThat(winner).isEqualTo(PLAYER_X);


    }
}
