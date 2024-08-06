package leetcode.java.challenges.medium.longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Tests and their inputs with expected outputs:
        LinkedHashMap<String, TestData<Integer>> tests = new LinkedHashMap<String, TestData<Integer>>();
        LinkedHashMap<Input, Integer> inputs = new LinkedHashMap<Input, Integer>();
        inputs.put(new Input("abcabcbb"), 3);
        inputs.put(new Input("bbbbb"), 1);
        inputs.put(new Input("pwwkew"), 3);
        inputs.put(new Input(" "), 1);
        inputs.put(new Input("dvdf"), 3);
        inputs.put(new Input("aabaab!bb"), 3);

        // Tests:
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1(),
                    new TestData<Integer>(lengthOfLongestSubstring(input.getInput1()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
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
