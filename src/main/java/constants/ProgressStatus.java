package constants;

public enum ProgressStatus {
    Y, N;

    public boolean progress() {
        return this == Y;
    }

    public boolean end() {
        return this == N;
    }
}