package baseball;

import baseball.constants.BallStatus;
import baseball.messages.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    @Test
    void create_balls() {
        List<Integer> inputs = Arrays.asList(1, 2, 3);
        Balls balls = new Balls(inputs);
    }

    @Test
    void create_balls_duplicateBallNumber() {
        List<Integer> inputs = Arrays.asList(1, 1, 3);
        assertThatThrownBy(() -> {
            Balls balls = new Balls(inputs);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.duplicateBallException);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,10,3", "1,0,3"})
    void create_balls_includeNotAllowedBallNumber(String inputs) {
        List<Integer> ballNumbers = Arrays.stream(inputs.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        assertThatThrownBy(() -> {
            Balls balls = new Balls(ballNumbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.ballNumberException);
    }

    @Test
    void strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 0);

        BallStatus result = computerBalls.getBallStatus(userBall);

        assertThat(result.strike()).isTrue();
    }

    @Test
    void ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(2, 0);

        BallStatus result = computerBalls.getBallStatus(userBall);

        assertThat(result.ball()).isTrue();
    }

    @Test
    void nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(4, 0);

        BallStatus result = computerBalls.getBallStatus(userBall);

        assertThat(result.nothing()).isTrue();
    }

    @Test
    void twoStrike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 4, 3));

        BallsResult result = computerBalls.play(userBalls);

        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    void threeStrike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        BallsResult result = computerBalls.play(userBalls);

        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    void oneStrike_twoBall() {
        Balls computerBalls = new Balls(Arrays.asList(1, 4, 3));
        Balls userBalls = new Balls(Arrays.asList(4, 1, 3));

        BallsResult result = computerBalls.play(userBalls);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void threeNothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 4, 3));
        Balls userBalls = new Balls(Arrays.asList(5, 6, 8));

        BallsResult result = computerBalls.play(userBalls);

        assertThat(result.getNothing()).isEqualTo(3);
    }
}
