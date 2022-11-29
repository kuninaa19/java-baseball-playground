package baseball;

import baseball.domain.Balls;
import baseball.domain.RandomBallsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    void 중복되지않는_랜덤_볼_생성() {
        Balls balls = RandomBallsGenerator.createRandomBalls();
        assertThat(balls).isNotNull();
    }
}