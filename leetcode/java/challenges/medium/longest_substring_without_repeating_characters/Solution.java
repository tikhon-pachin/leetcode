package leetcode.java.challenges.medium.longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Tests:
        tests.put("Test 1 (input: \"abcabcbb\"): ",
                new TestData(lengthOfLongestSubstring("abcabcbb"), 3));
        tests.put("Test 2 (input: \"bbbbb\"): ",
                new TestData(lengthOfLongestSubstring("bbbbb"), 1));
        tests.put("Test 3 (input: \"pwwkew\"): ",
                new TestData(lengthOfLongestSubstring("pwwkew"), 3));
        tests.put("Test 4 (input: \" \"): ",
                new TestData(lengthOfLongestSubstring(" "), 1));
        tests.put("Test 5 (input: \"dvdf\"): ",
                new TestData(lengthOfLongestSubstring("dvdf"), 3));
        tests.put("Test 6 (input: \"aabaab!bb\"): ",
                new TestData(lengthOfLongestSubstring("aabaab!bb"), 3));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Solution.
    // Time complexity: O(n^2).
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
}
