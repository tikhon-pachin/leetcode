package leetcode.java.challenges.easy.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Tests and their inputs with expected outputs:
        LinkedHashMap<String, TestData<int[]>> tests = new LinkedHashMap<String, TestData<int[]>>();
        LinkedHashMap<Input, int[]> inputs = new LinkedHashMap<Input, int[]>();
        inputs.put(new Input(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
        inputs.put(new Input(new int[] { 3, 2, 4 }, 6), new int[] { 1, 2 });
        inputs.put(new Input(new int[] { 3, 3 }, 6), new int[] { 0, 1 });

        // Hash table tests:
        method = "Hash Table";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + Arrays.toString(input.getInput1()) + ", " + input.getInput2(),
                    new TestData<int[]>(twoSumHashTable(input.getInput1(), input.getInput2()), expectedOutput));
        });

        // Brute force tests:
        method = "Brute Force";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + Arrays.toString(input.getInput1()) + ", " + input.getInput2(),
                    new TestData<int[]>(twoSumBruteForce(input.getInput1(), input.getInput2()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
    }

    // Hash table solution.
    // Time complexity: O(n).
    private static int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> lookupTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (lookupTable.get(complement) != null) {
                return new int[] { lookupTable.get(complement), i };
            }
            lookupTable.put(nums[i], i);
        }
        throw new IllegalStateException(
                "No solution was found. Leetcode notes: \"You may assume that each input would have exactly one solution.\"");
    }

    // Brute force solution.
    // Time complexity: O(n^2)
    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalStateException(
                "No solution was found. Leetcode notes: \"You may assume that each input would have exactly one solution.\"");
    }
}
