package leetcode.java.challenges.medium.longest_palindromic_substring;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Tests and their inputs with expected outputs:
        LinkedHashMap<String, TestData<String>> tests = new LinkedHashMap<String, TestData<String>>();
        LinkedHashMap<Input, String> inputs = new LinkedHashMap<Input, String>();
        inputs.put(new Input("babad"), "bab");
        inputs.put(new Input("cbbd"), "bb");
        inputs.put(new Input("abb"), "bb");

        // Tests:
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1(),
                    new TestData<String>(longestPalindrome(input.getInput1()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
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
