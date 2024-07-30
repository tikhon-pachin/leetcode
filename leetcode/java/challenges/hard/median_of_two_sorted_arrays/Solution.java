package leetcode.java.challenges.hard.median_of_two_sorted_arrays;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Tests:
        tests.put("Test 1 (nums1: [1,3], nums2: [2]): ",
                new TestData(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }), 2.0));
        tests.put("Test 2 (nums1: [1,2], nums2: [3,4]): ",
                new TestData(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }), 2.5));
        tests.put("Test 3 (nums1: [3], nums2: [-2,-1]): ",
                new TestData(findMedianSortedArrays(new int[] { 3 }, new int[] { -2, -1 }), -1.0));
        tests.put("Test 4 (nums1: [0], nums2: [0]): ",
                new TestData(findMedianSortedArrays(new int[] { 0 }, new int[] { 0 }), 0.0));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Solution.
    // Time complexity: O(n + m). n, m - lengths of input arrays.
    private static int n;
    private static int m;

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Initialize indices for each array.
        n = 0;
        m = 0;

        // Setup the merged lower half of the sorted arrays. The top one or two
        // value will determine the median.
        int mergedHalfSize = Math.floorDiv(nums1.length + nums2.length, 2) + 1;
        int[] mergedHalf = new int[mergedHalfSize];

        // Merge the arrays into a complete half.
        for (int i = 0; i < mergedHalfSize; i++) {
            mergedHalf[i] = findMin(nums1, nums2);
        }

        // Determine whether to return the middle value or the avergae of middle two
        // values.
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (mergedHalf[mergedHalf.length - 1] + mergedHalf[mergedHalf.length - 2]) / 2.0;
        } else {
            return (double) mergedHalf[mergedHalf.length - 1];
        }
    }

    // Determine which is the next entry in the merged array.
    private static int findMin(int[] nums1, int[] nums2) {
        if (n < nums1.length && m < nums2.length) {
            return nums1[n] < nums2[m] ? nums1[n++] : nums2[m++];
        } else if (n < nums1.length) {
            return nums1[n++];
        } else if (m < nums2.length) {
            return nums2[m++];
        }
        return -1;
    }
}
