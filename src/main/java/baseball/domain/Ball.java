package baseball.domain;

import baseball.constants.BallConstants;
import baseball.messages.ErrorMessage;

public class Ball {
    private final int number;
    private final int position;

    public Ball(int input, int position) {
        checkValidBallNumber(input);

        this.number = input;
        this.position = position;
    }

    private void checkValidBallNumber(int input) {
        if (input < BallConstants.MIN || input > BallConstants.MAX) {
            throw new IllegalArgumentException(ErrorMessage.ballNumberException);
        }
    }

    public boolean strike(Ball inputBall) {
        return this.equals(inputBall);
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }
}
