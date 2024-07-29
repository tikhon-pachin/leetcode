package leetcode.java.challenges.medium.add_two_numbers;

public class TestData {
    private ListNode actualOutput;
    private ListNode expectedOutput;

    public TestData(ListNode actualOutput, ListNode expectedOutput) {
        this.actualOutput = actualOutput;
        this.expectedOutput = expectedOutput;
    }

    public ListNode getActualOutput() {
        return actualOutput;
    }

    public ListNode getExpectedOutput() {
        return expectedOutput;
    }
}
