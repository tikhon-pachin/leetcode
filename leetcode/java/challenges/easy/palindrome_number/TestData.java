package leetcode.java.challenges.easy.palindrome_number;

public class TestData {
    private boolean actualOutput;
    private boolean expectedOutput;

    public TestData(boolean actualOutput, boolean expectedOutput) {
        this.actualOutput = actualOutput;
        this.expectedOutput = expectedOutput;
    }

    public boolean getActualOutput() {
        return actualOutput;
    }

    public boolean getExpectedOutput() {
        return expectedOutput;
    }
}
