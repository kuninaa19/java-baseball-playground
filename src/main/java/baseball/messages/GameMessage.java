package baseball.messages;

import baseball.constants.GameConstants;

public class GameMessage {
    public static final String inputBallNumber = "숫자를 입력해 주세요 : ";
    public static final String gameReTrySelection = "게임을 새로 시작하려면 " + GameConstants.gameRetry + ",";
    public static final String gameEndSelection = "종료하려면 " + GameConstants.gameEnd + "를 입력하세요.";
    public static final String gameEnd = "게임 종료";
    public static final String gameWin = GameConstants.endCondition + "개의 숫자를 모두 맞히셨습니다!";
    public static final String messageInterval = " ";
}
