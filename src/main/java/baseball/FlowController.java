package baseball;

import baseball.constants.ProgressStatus;
import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameReport;
import baseball.domain.RandomBallsGenerator;
import baseball.input.InputBallNumbers;
import baseball.input.InputGameProgress;
import baseball.view.ErrorView;
import baseball.view.GameView;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class FlowController {
    private ProgressStatus progressStatus;

    public FlowController() {
        progressStatus = ProgressStatus.Y;
    }

    public void run() {
        while (progressStatus.progress()) {
            Balls randomBalls = RandomBallsGenerator.createRandomBalls();
            Game game = new Game(randomBalls);
            gameProgress(game);
            progressStatus = gameEnd();
        }
    }

    private void gameProgress(Game game) {
        while (game.checkProgress()) {
            Balls userBalls = getUserBalls();

            GameReport gameReport = game.process(userBalls);

            ResultView.printGameResult(gameReport);
        }
    }

    private Balls getUserBalls() {
        InputView.numbersInputForm();
        InputBallNumbers inputBallNumbers = new InputBallNumbers();

        try {
            List<Integer> ballNumbers = inputBallNumbers.read();
            return new Balls(new ArrayList<>(ballNumbers));
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return getUserBalls();
        }
    }

    private ProgressStatus gameEnd() {
        GameView.PrintCongratulation();
        GameView.printMessageInterval();
        GameView.printGameEnd();

        return getGameEndSelection();
    }

    private ProgressStatus getGameEndSelection() {
        InputView.gameSelectionInputForm();
        InputGameProgress inputGameProgress = new InputGameProgress();

        try {
            return inputGameProgress.read();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return getGameEndSelection();
        }
    }
}
