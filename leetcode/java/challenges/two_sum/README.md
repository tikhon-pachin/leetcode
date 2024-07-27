# Notes

Leetcode link: [Two Sum](https://leetcode.com/problems/two-sum/)

## Solution

### Solution 1

Method: hash table lookup.\
Time complexity: `O(n)`

```java
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
```
