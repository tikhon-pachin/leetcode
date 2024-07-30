package leetcode.java.challenges.medium.longest_palindromic_substring;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Tests:
        tests.put("Test 1 (input: \"babad\"): ",
                new TestData(longestPalindrome("babad"), "bab"));
        tests.put("Test 2 (input: \"cbbd\"): ",
                new TestData(longestPalindrome("cbbd"), "bb"));
        tests.put("Test 3 (input: \"abb\"): ",
                new TestData(longestPalindrome("abb"), "bb"));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Solution.
    // Time complexity: O(n^2).
    private static String longestPalindrome(String s) {
        // Setup the return value.
        String largestPalindrome = "";

        // Evaluate all possible palindromes that are of an odd length.
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            largestPalindrome = evaluatePalindrome(s, l, r, largestPalindrome);
        }

        // Evaluate all possible palindromes that are of an even length.
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i;
            int r = i + 1;
            // If the starter substring is not a palindrome, we don't need to evaluate
            // further.
            if (s.charAt(l) != s.charAt(r)) {
                continue;
            }
            largestPalindrome = evaluatePalindrome(s, l, r, largestPalindrome);
        }

        return largestPalindrome;
    }

    private static String evaluatePalindrome(String s, int l, int r, String largestPalindrome) {
        // The current substring is either a two letter palindrome or a one letter
        // string, which is a palindrome by default.
        String currentPalindrome = s.substring(l, r + 1);

        // Check either side of the palindrome if we can add surrounding letters,
        // to the current palindrome.
        while (l >= 0 && r < s.length()) {
            // If the letters are not the same, this is no longer a palindrome.
            // Otherwise check the next letters on either side.
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                currentPalindrome = s.substring(l, r + 1);
                l--;
                r++;
            }
        }

        // If the current palindrome is larger than the largest before, reassign the
        // largest palindrome.
        if (currentPalindrome.length() > largestPalindrome.length()) {
            largestPalindrome = currentPalindrome;
        }

        return largestPalindrome;
    }
}
