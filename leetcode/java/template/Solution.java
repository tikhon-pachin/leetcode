package leetcode.java.template;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Method tests:
        tests.put("Method test x (input1: x, input2: x): ",
                new TestData(functionName(), new type expected);

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Method solution.
    // Time complexity: O(?).
    private static void functionName() {
        throw new UnsupportedOperationException("The solution is not available yet");
    }
}
