package baseball.constants;

public enum ProgressStatus {
    Y, N;

    public boolean progress() {
        return this == Y;
    }
}