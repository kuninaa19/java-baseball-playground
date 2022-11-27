package baseball.constants;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean strike() {
        return this == STRIKE;
    }

    public boolean ball() {
        return this == BALL;
    }

    public boolean nothing() {
        return this == NOTHING;
    }
}
