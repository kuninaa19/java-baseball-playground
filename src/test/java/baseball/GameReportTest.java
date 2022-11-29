package baseball;

import baseball.constants.BallStatus;
import baseball.domain.BallsResult;
import baseball.domain.GameReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameReportTest {

    private BallsResult ballsResult;

    @BeforeEach
    void setUp() {
        ballsResult = new BallsResult();
    }

    @Test
    void 메시지_1볼_2스트라이크() {
        ballsResult.count(BallStatus.STRIKE);
        ballsResult.count(BallStatus.STRIKE);
        ballsResult.count(BallStatus.BALL);

        GameReport gameReport = new GameReport(ballsResult);
        assertThat(gameReport.toString()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 메시지_2스트라이크() {
        ballsResult.count(BallStatus.STRIKE);
        ballsResult.count(BallStatus.STRIKE);

        GameReport gameReport = new GameReport(ballsResult);
        assertThat(gameReport.toString()).isEqualTo("2스트라이크");
    }

    @Test
    void 메시지_1볼() {
        ballsResult.count(BallStatus.BALL);

        GameReport gameReport = new GameReport(ballsResult);
        assertThat(gameReport.toString()).isEqualTo("1볼");
    }

    @Test
    void 메시지_낫싱() {
        ballsResult.count(BallStatus.NOTHING);
        ballsResult.count(BallStatus.NOTHING);
        ballsResult.count(BallStatus.NOTHING);

        GameReport gameReport = new GameReport(ballsResult);
        assertThat(gameReport.toString()).isEqualTo("낫싱");
    }
}
