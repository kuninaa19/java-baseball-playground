package baseball;

import baseball.constants.BallStatus;
import baseball.constants.BallsResultConstants;

public class BallsResult {
    private Integer strike;
    private Integer ball;
    private Integer nothing;

    public BallsResult() {
        this.strike = BallsResultConstants.initial;
        this.ball = BallsResultConstants.initial;
        this.nothing = BallsResultConstants.initial;
    }

    public void count(BallStatus ballStatus) {
        if (ballStatus.strike()) {
            strike += BallsResultConstants.addCount;
        }

        if (ballStatus.ball()) {
            ball += BallsResultConstants.addCount;
        }

        if (ballStatus.nothing()) {
            nothing += BallsResultConstants.addCount;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public Integer getNothing() {
        return nothing;
    }
}
