import constants.BallConstants;
import constants.ErrorMessage;

public class Ball {
    private final Integer number;

    public Ball(Integer input) {
        checkValidBallNumber(input);

        this.number = input;
    }

    private void checkValidBallNumber(Integer input) {
        if (input < BallConstants.MIN || input > BallConstants.MAX) {
            throw new IllegalArgumentException(ErrorMessage.ballNumberException);
        }
    }

    public Integer getNumber() {
        return number;
    }
}
