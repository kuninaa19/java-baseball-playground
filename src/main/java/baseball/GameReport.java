package baseball;

import baseball.constants.BallConstants;
import baseball.constants.BallsResultConstants;
import baseball.messages.GameResultMessage;

import java.util.Objects;

public class GameReport {
    private final String strike;
    private final String ball;

    private final String nothing;

    public GameReport(BallsResult ballsResult) {
        this.ball = createMessage(ballsResult.getBall(), GameResultMessage.ball);
        this.strike = createMessage(ballsResult.getStrike(), GameResultMessage.strike);
        this.nothing = createMessage(ballsResult.getNothing(), GameResultMessage.nothing);
    }

    private String createMessage(int ballCount, String resultMessage) {
        if (Objects.equals(resultMessage, GameResultMessage.nothing) && ballCount == BallConstants.COUNT) {
            return GameResultMessage.nothing;
        }

        if (ballCount != BallsResultConstants.initial && !Objects.equals(resultMessage, GameResultMessage.nothing)) {
            return ballCount + resultMessage;
        }

        return GameResultMessage.blank;
    }

    @Override
    public String toString() {
        if (!Objects.equals(ball, GameResultMessage.blank) && !Objects.equals(strike, GameResultMessage.blank)) {
            return ball + GameResultMessage.messageInterval + strike;
        }

        return ball + strike + nothing;
    }
}
