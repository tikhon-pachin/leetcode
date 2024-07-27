package leetcode.java.challenges.two_sum;

public class TestData {
    private int[] array;
    private int target;
    private int[] expectedOutput;

    public TestData(int[] array, int target, int[] expectedOutput) {
        this.array = array;
        this.target = target;
        this.expectedOutput = expectedOutput;
    }

    public int[] getArray() {
        return array;
    }

    public int getTarget() {
        return target;
    }

    public int[] getExpectedOutput() {
        return expectedOutput;
    }
}
