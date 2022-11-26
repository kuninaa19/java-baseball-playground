import constants.BallConstants;
import constants.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Balls {
    private final List<Ball> balls;
    private final HashMap<Integer, Integer> duplicateChecker = new HashMap<>();

    public Balls(List<Integer> inputs) {
        checkValidSize(inputs.size());

        this.balls = createBalls(inputs);
    }

    private List<Ball> createBalls(List<Integer> inputs) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < inputs.size(); i++) {
            Ball ball = new Ball(inputs.get(i));
            checkDuplicateBall(ball);
            duplicateChecker.put(ball.getNumber(), i);
            balls.add(ball);
        }

        return balls;
    }

    private void checkDuplicateBall(Ball ball) {
        if (duplicateChecker.containsKey(ball.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.duplicateBallException);
        }
    }

    private void checkValidSize(int size) {
        if (size != BallConstants.COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ballCountException);
        }
    }
}