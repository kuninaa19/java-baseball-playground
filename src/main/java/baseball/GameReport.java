package baseball;

public class GameReport {
    private final int strike;
    private final int ball;
    private final int nothing;

    public GameReport(BallsResult ballsResult) {
        this.strike = ballsResult.getStrike();
        this.ball = ballsResult.getBall();
        this.nothing = ballsResult.getNothing();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }
}
