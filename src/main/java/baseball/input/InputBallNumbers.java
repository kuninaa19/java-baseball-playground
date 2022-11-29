package baseball.input;

import baseball.messages.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputBallNumbers extends Input<List<Integer>> {
    @Override
    public List<Integer> read() {
        String console = console();
        try {
            return convertStringToList(console);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.SpecialCharactersException);
        }
    }

    private List<Integer> convertStringToList(String read) {
        return Arrays.stream(read.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}

