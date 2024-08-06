package leetcode.java.utils;

public class TestData<T> {
    private T actualOutput;
    private T expectedOutput;

    public TestData(T actualOutput, T expectedOutput) {
        this.actualOutput = actualOutput;
        this.expectedOutput = expectedOutput;
    }

    public T getActualOutput() {
        return actualOutput;
    }

    public T getExpectedOutput() {
        return expectedOutput;
    }
}
