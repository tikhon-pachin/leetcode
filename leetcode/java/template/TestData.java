package leetcode.java.template;

public class TestData {
    private type actualOutput;
    private type expectedOutput;

    public TestData(type actualOutput, type expectedOutput) {
        this.actualOutput = actualOutput;
        this.expectedOutput = expectedOutput;
    }

    public type getActualOutput() {
        return actualOutput;
    }

    public type getExpectedOutput() {
        return expectedOutput;
    }
}
