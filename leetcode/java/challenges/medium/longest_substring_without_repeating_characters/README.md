# Notes

Leetcode link: [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## Solution

Method: Brute Force Array List Iteration.\
Time complexity: `O(n^2)`

```java
private static int lengthOfLongestSubstring(String s) {
    // Setup the count and characters trackers.
    ArrayList<Character> individualCharacters = new ArrayList<Character>();
    int highestCount = 0;
    int tempCount = 0;

    // For each of the characters in the string check if the character
    // was found earlier. If not, keep iterating through the string.
    // If so, remove all the characters from the beginning until the
    // already found character is removed.
    for (int i = 0; i < s.length(); i++) {
        Character currentLetter = s.charAt(i);

        // Check if the letter was already found.
        if (individualCharacters.contains(currentLetter)) {
            // Remove the substring that contains the already found letter.
            int arrayIndexOfLetter = individualCharacters.indexOf(currentLetter);
            individualCharacters.subList(0, arrayIndexOfLetter + 1).clear();
            tempCount -= arrayIndexOfLetter;
        } else {
            // Continue iterating and add to the count.
            tempCount++;
        }

        // Add the letter into the individual letter list.
        individualCharacters.add(currentLetter);

        // If the current count is higher than the total count, then
        // the current sequence is the longest sequence.
        if (highestCount < tempCount) {
            highestCount = tempCount;
        }
    }

    return highestCount;
}
```
