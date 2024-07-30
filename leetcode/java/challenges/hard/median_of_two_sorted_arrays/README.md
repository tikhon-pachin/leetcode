# Notes

Leetcode link: [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

## Solution

Method: Brute Force iteration over lower half of the merged array.\
Time complexity: `O(n + m)`. `n`, `m` - lengths of the input arrays.

```java
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
```
