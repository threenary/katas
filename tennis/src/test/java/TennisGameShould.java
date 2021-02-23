import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameShould {

    private TennisGame game = new TennisGame();

    @ParameterizedTest
    @CsvSource({
            "0,0,LOVE-ALL",
            "1,1,FIFTEEN-ALL",
            "2,2,THIRTY-ALL",
            "3,3,DEUCE",

            "1,0,FIFTEEN-LOVE",
            "2,0,THIRTY-LOVE",
            "3,0,FOURTY-LOVE",
            "4,0,PLAYER 1 WINS",

            "0,1,LOVE-FIFTEEN",
            "0,2,LOVE-THIRTY",
            "0,3,LOVE-FOURTY",
            "0,4,PLAYER 2 WINS",

            "4,1,PLAYER 1 WINS",
            "4,2,PLAYER 1 WINS",
            "5,3,PLAYER 1 WINS",
            "6,4,PLAYER 1 WINS",

            "1,4,PLAYER 2 WINS",
            "2,4,PLAYER 2 WINS",
            "3,5,PLAYER 2 WINS",
            "6,8,PLAYER 2 WINS",

            "4,3, ADVANTAGE PLAYER 1",
            "16,15, ADVANTAGE PLAYER 1",
            "4,5, ADVANTAGE PLAYER 2",
            "56,57, ADVANTAGE PLAYER 2",
    })
    void
    start_with_two_plRayers_in_love(int score1, int score2, String expected) {
        assertEquals(expected, game.score(score1, score2));
    }
}
