package baseball;

import baseball.constants.BallConstants;
import baseball.constants.BallStatus;
import baseball.messages.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
    private final List<Ball> balls;
    private final HashSet<Integer> duplicateChecker = new HashSet<>();

    public Balls(List<Integer> inputs) {
        checkValidSize(inputs.size());

        this.balls = createBalls(inputs);
    }

    private List<Ball> createBalls(List<Integer> inputs) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            Ball ball = new Ball(inputs.get(i), i);
            checkDuplicateBall(ball);
            balls.add(ball);
        }

        return balls;
    }

    private void checkDuplicateBall(Ball ball) {
        if (duplicateChecker.contains(ball.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.duplicateBallException);
        }

        duplicateChecker.add(ball.getNumber());
    }

    private void checkValidSize(int size) {
        if (size != BallConstants.COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ballCountException);
        }
    }

    public BallStatus getBallStatus(Ball inputBall) {
        if (!duplicateChecker.contains(inputBall.getNumber())) {
            return BallStatus.NOTHING;
        }

        if (balls.get(inputBall.getPosition()).strike(inputBall)) {
            return BallStatus.STRIKE;
        }

        return BallStatus.BALL;
    }

    public BallsResult play(Balls userBalls) {
        BallsResult ballsResult = new BallsResult();

        for (Ball userBall : userBalls.getBalls()) {
            BallStatus ballStatus = getBallStatus(userBall);
            ballsResult.count(ballStatus);
        }

        return ballsResult;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}