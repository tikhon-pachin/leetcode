package leetcode.java.template;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData<type>> tests = new LinkedHashMap<String, TestData<type>>();
        LinkedHashMap<Input, type> inputs = new LinkedHashMap<Input, type>();
        inputs.put(new Input(input1, input2), expectedOutput);

        // Method tests:
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1() + ", " + input.getInput2(),
                    new TestData<type>(functionName(input.getInput1(), input.getInput2()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
    }

    // Method solution.
    // Time complexity: O(?).
    private static void functionName() {
        throw new UnsupportedOperationException("The solution is not available yet");
    }
}
