import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        List<Integer> inputs = Arrays.asList(1, 2, 3);
        Balls balls = new Balls(inputs);
        game = new Game(balls);
    }

    @Test
    void 게임결과_3스트라이크_게임종료() {
        List<Integer> inputs = Arrays.asList(1, 2, 3);
        Balls balls = new Balls(inputs);

        GameReport gameReport = game.process(balls);
        assertThat(game.checkProgress()).isFalse();
    }
}