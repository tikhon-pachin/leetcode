# Notes

Leetcode link: [Two Sum](https://leetcode.com/problems/two-sum/)

## Solutions

### Solution 1

Method: hash table lookup.\
Time complexity: `O(n)`

```java
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
```

### Solution 2

Method: brute force.\
Time complexity: `O(n^2)`

```java
private static int[] twoSum(int[] nums, int target) {
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
```
