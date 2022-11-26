import constants.BallStatus;
import constants.BallsResultConstants;

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
            countStrike();
        }

        if (ballStatus.ball()) {
            countBall();
        }

        if (ballStatus.nothing()) {
            countNothing();
        }
    }

    public void countStrike() {
        strike += BallsResultConstants.addCount;
    }

    public void countBall() {
        ball += BallsResultConstants.addCount;
    }

    public void countNothing() {
        nothing += BallsResultConstants.addCount;
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
