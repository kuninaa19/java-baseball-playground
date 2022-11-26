import constants.BallConstants;
import constants.ErrorMessage;

public class Ball {
    private final Integer number;
    private final Integer position;

    public Ball(Integer input, Integer position) {
        checkValidBallNumber(input);

        this.number = input;
        this.position = position;

    }

    private void checkValidBallNumber(Integer input) {
        if (input < BallConstants.MIN || input > BallConstants.MAX) {
            throw new IllegalArgumentException(ErrorMessage.ballNumberException);
        }
    }

    public boolean strike(Ball inputBall) {
        return number == inputBall.getNumber() && position == inputBall.getPosition();
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getPosition() {
        return position;
    }

}
