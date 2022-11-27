package baseball;

import baseball.constants.GameConstants;
import baseball.constants.ProgressStatus;

public class Game {
    private final Balls balls;
    private ProgressStatus progressStatus;

    public Game(Balls balls) {
        this.balls = balls;
        this.progressStatus = ProgressStatus.Y;
    }

    public GameReport process(Balls userBalls) {
        BallsResult ballsResult = balls.play(userBalls);
        GameReport gameReport = new GameReport(ballsResult);

        checkGameEnd(gameReport);

        return gameReport;
    }

    private void checkGameEnd(GameReport gameReport) {
        if (gameReport.getStrike() == GameConstants.endCondition) {
            this.progressStatus = ProgressStatus.N;
        }
    }

    public boolean checkProgress() {
        return progressStatus.progress();
    }
}
