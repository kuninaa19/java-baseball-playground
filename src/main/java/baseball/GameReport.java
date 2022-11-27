package baseball;

import baseball.constants.BallsResultConstants;
import baseball.constants.printMessage;

import java.util.Objects;

public class GameReport {
    private final String strike;
    private final String ball;

    public GameReport(BallsResult ballsResult) {
        this.ball = createMessage(ballsResult.getBall(), printMessage.ball);
        this.strike = createMessage(ballsResult.getStrike(), printMessage.strike);
    }

    private String createMessage(int ballCount, String resultMessage) {
        if (ballCount != BallsResultConstants.initial) {
            return ballCount + resultMessage;
        }

        return printMessage.nothing;
    }

    @Override
    public String toString() {
        if (!Objects.equals(ball, printMessage.nothing) && !Objects.equals(strike, printMessage.nothing)) {
            return ball + printMessage.messageInterval + strike;
        }

        return ball + strike;
    }
}
