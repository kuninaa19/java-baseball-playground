package baseball.input;

import baseball.constants.GameConstants;
import baseball.constants.ProgressStatus;
import baseball.messages.ErrorMessage;

public class InputGameProgress extends Input<ProgressStatus> {
    @Override
    public ProgressStatus read() {
        String console = console();
        int read = convertStringToInt(console);

        return getProgressStatus(read);
    }

    private ProgressStatus getProgressStatus(int read) {
        if (read == GameConstants.gameRetry) {
            return ProgressStatus.Y;
        }

        if (read == GameConstants.gameEnd) {
            return ProgressStatus.N;
        }

        throw new IllegalArgumentException(ErrorMessage.gameEndSelectionException);
    }

    private int convertStringToInt(String read) {
        return Integer.parseInt(read);
    }
}
