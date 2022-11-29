package baseball.view;

import baseball.messages.GameMessage;

public class InputView {

    public static void numbersInputForm() {
        System.out.print(GameMessage.inputBallNumber);
    }

    public static void gameSelectionInputForm() {
        System.out.println(GameMessage.gameReTrySelection + GameMessage.messageInterval + GameMessage.gameEndSelection);
    }
}
