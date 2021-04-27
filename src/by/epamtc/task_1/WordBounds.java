package by.epamtc.task_1;

public class WordBounds {
    public WordBounds(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean isCorrect() {
        return this.first >= 0 && this.first <= this.second;

    }

    public int wordSize() {
        return this.second - this.first + 1;
    }

    public int first;
    public int second;
}
