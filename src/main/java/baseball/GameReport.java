package baseball;

import baseball.constants.BallsResultConstants;
import baseball.messages.GameResultMessage;

import java.util.Objects;

public class GameReport {
    private final String strike;
    private final String ball;

    public GameReport(BallsResult ballsResult) {
        this.ball = createMessage(ballsResult.getBall(), GameResultMessage.ball);
        this.strike = createMessage(ballsResult.getStrike(), GameResultMessage.strike);
    }

    private String createMessage(int ballCount, String resultMessage) {
        if (ballCount != BallsResultConstants.initial) {
            return ballCount + resultMessage;
        }

        return GameResultMessage.nothing;
    }

    @Override
    public String toString() {
        if (!Objects.equals(ball, GameResultMessage.nothing) && !Objects.equals(strike, GameResultMessage.nothing)) {
            return ball + GameResultMessage.messageInterval + strike;
        }

        return ball + strike;
    }
}
