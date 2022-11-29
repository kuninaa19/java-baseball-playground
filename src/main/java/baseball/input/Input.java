package baseball.input;

import java.util.Scanner;

public abstract class Input<T> {
    protected static String console() {
        return new Scanner(System.in).nextLine();
    }

    protected abstract T read();
}
