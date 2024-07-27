package leetcode.java.challenges.two_sum;

import java.util.HashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, TestData> tests = new HashMap<String, TestData>();
        tests.put("Test 1 (array: [2, 7, 11, 15], target: 9): ",
                new TestData(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }));
        tests.put("Test 2 (array: [3, 2, 4], target: 6): ",
                new TestData(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }));
        tests.put("Test 3 (array: [3, 3], target: 6): ",
                new TestData(new int[] { 3, 3 }, 6, new int[] { 0, 1 }));

        tests.forEach((testName, testData) -> {
            TestUtil.test(testName,
                    TestUtil.areEqual(twoSum(testData.getArray(), testData.getTarget()), testData.getExpectedOutput()));
        });
    }

    private static int[] twoSum(int[] nums, int target) {
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
}
