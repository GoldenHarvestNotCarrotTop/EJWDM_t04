package by.epamtc.task_1;

public class WordBounds {
    public WordBounds(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public boolean isCorrect() {
        return this.left >= 0 && this.left <= this.right;

    }

    public int wordSize() {
        return this.right - this.left + 1;
    }

    public int left;
    public int right;
}
