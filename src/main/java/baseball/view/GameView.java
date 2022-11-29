package baseball.view;

import baseball.messages.GameMessage;

public class GameView {

    public static void PrintCongratulation() {
        System.out.print(GameMessage.gameWin);
    }

    public static void printGameEnd() {
        System.out.println(GameMessage.gameEnd);
    }

    public static void printMessageInterval() {
        System.out.print(GameMessage.messageInterval);
    }
}
