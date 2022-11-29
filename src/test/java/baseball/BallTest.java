package baseball;

import baseball.domain.Ball;
import baseball.messages.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "9:9"}, delimiter = ':')
    void create_ball_allowBallNumber(Integer input, Integer expected) {
        Ball ball = new Ball(input, 0);

        assertThat(ball.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void create_ball_notAllowedBallNumber(Integer input) {

        assertThatThrownBy(() -> {
            Ball ball = new Ball(input, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessage.ballNumberException);
    }
}
