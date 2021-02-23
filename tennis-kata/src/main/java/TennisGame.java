public class TennisGame {

    public String score(int scoreOne, int scoreTwo) {
        if (scoreOne == scoreTwo) {
            return tie(scoreOne);
        } else if (isAdvantage(scoreOne, scoreTwo)) {
            return revealAdvantage(scoreOne, scoreTwo);
        } else if (isGameOver(scoreOne, scoreTwo)) {
            return revealWinner(scoreOne, scoreTwo);
        }
        return translate(scoreOne) + "-" + translate(scoreTwo);
    }

    private boolean isAdvantage(int scoreOne, int scoreTwo) {
        return (scoreOne > 3 || scoreTwo > 3) && (Math.abs(scoreOne - scoreTwo) == 1);
    }

    private boolean isGameOver(int scoreOne, int scoreTwo) {
        return hasFirstScoreOne(scoreOne, scoreTwo) ||
                hasFirstScoreOne(scoreTwo, scoreOne);
    }

    private boolean hasFirstScoreOne(int playerOne, int playerTwo) {
        return playerOne > 3 && Math.abs(playerOne - playerTwo) >= 2;
    }

    private String tie(int score) {
        if (score < 3) {
            return translate(score) + "-" + "ALL";
        }
        return "DEUCE";
    }

    private String translate(int score) {
        switch (score) {
            case 0:
                return "LOVE";
            case 1:
                return "FIFTEEN";
            case 2:
                return "THIRTY";
        }
        return "FOURTY";
    }

    private String revealWinner(int playerOne, int playerTwo) {
        if (playerOne > playerTwo) {
            return "PLAYER 1 WINS";
        } else {
            return "PLAYER 2 WINS";
        }
    }

    private String revealAdvantage(int scoreOne, int scoreTwo) {
        if (scoreOne > scoreTwo) {
            return "ADVANTAGE PLAYER 1";
        }
        return "ADVANTAGE PLAYER 2";
    }
}
