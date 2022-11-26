import constants.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
