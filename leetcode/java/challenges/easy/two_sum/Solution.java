package leetcode.java.challenges.two_sum;

import java.util.HashMap;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Hash table tests:
        tests.put("Hash Table test 1 (array: [2, 7, 11, 15], target: 9): ",
                new TestData(twoSumHashTable(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 }));
        tests.put("Hash Table test 2 (array: [3, 2, 4], target: 6): ",
                new TestData(twoSumHashTable(new int[] { 3, 2, 4 }, 6), new int[] { 1, 2 }));
        tests.put("Hash Table test 3 (array: [3, 3], target: 6): ",
                new TestData(twoSumHashTable(new int[] { 3, 3 }, 6), new int[] { 0, 1 }));

        // Brute force tests:
        tests.put("Brute Force test 1 (array: [2, 7, 11, 15], target: 9): ",
                new TestData(twoSumBruteForce(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 }));
        tests.put("Brute Force test 2 (array: [3, 2, 4], target: 6): ",
                new TestData(twoSumBruteForce(new int[] { 3, 2, 4 }, 6), new int[] { 1, 2 }));
        tests.put("Brute Force test 3 (array: [3, 3], target: 6): ",
                new TestData(twoSumBruteForce(new int[] { 3, 3 }, 6), new int[] { 0, 1 }));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
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
