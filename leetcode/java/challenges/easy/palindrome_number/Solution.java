package leetcode.java.challenges.easy.palindrome_number;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // String Conversion tests:
        tests.put("String Conversion test 1 (number: 121): ",
                new TestData(isPalindromeStringConversion(121), true));
        tests.put("String Conversion test 2 (number: 1221): ",
                new TestData(isPalindromeStringConversion(1221), true));
        tests.put("String Conversion test 3 (number: 0): ",
                new TestData(isPalindromeStringConversion(0), true));
        tests.put("String Conversion test 4 (number: -121): ",
                new TestData(isPalindromeStringConversion(-121), false));
        tests.put("String Conversion test 5 (number: 10): ",
                new TestData(isPalindromeStringConversion(10), false));
        tests.put("String Conversion test 6 (number: 100): ",
                new TestData(isPalindromeStringConversion(100), false));
        tests.put("String Conversion test 7 (number: 123): ",
                new TestData(isPalindromeStringConversion(123), false));

        // No Conversion tests:
        tests.put("No Conversion test 1 (number: 121): ",
                new TestData(isPalindromeNoConversion(121), true));
        tests.put("No Conversion test 2 (number: 1221): ",
                new TestData(isPalindromeNoConversion(1221), true));
        tests.put("No Conversion test 3 (number: 0): ",
                new TestData(isPalindromeNoConversion(0), true));
        tests.put("No Conversion test 4 (number: -121): ",
                new TestData(isPalindromeNoConversion(-121), false));
        tests.put("No Conversion test 5 (number: 10): ",
                new TestData(isPalindromeNoConversion(10), false));
        tests.put("No Conversion test 6 (number: 100): ",
                new TestData(isPalindromeNoConversion(100), false));
        tests.put("No Conversion test 7 (number: 123): ",
                new TestData(isPalindromeNoConversion(123), false));

        // Reverse tests:
        tests.put("Reverse test 1 (number: 121): ",
                new TestData(isPalindromeReverse(121), true));
        tests.put("Reverse test 2 (number: 1221): ",
                new TestData(isPalindromeReverse(1221), true));
        tests.put("Reverse test 3 (number: 0): ",
                new TestData(isPalindromeReverse(0), true));
        tests.put("Reverse test 4 (number: -121): ",
                new TestData(isPalindromeReverse(-121), false));
        tests.put("Reverse test 5 (number: 10): ",
                new TestData(isPalindromeReverse(10), false));
        tests.put("Reverse test 6 (number: 100): ",
                new TestData(isPalindromeReverse(100), false));
        tests.put("Reverse test 7 (number: 123): ",
                new TestData(isPalindromeReverse(123), false));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // String conversion solution.
    // Time complexity: O(d). d - number of digits in the integer.
    private static boolean isPalindromeStringConversion(int x) {
        // Treat the integer like a string palindrome.
        String number = Integer.toString(x);

        // Compare left half of the integer with right half.
        // If the number of digits is odd, then the middle digit
        // has no effect on the conclusion of the algorithm.
        for (int i = 0; i < Math.floorDiv(number.length(), 2); i++) {
            Character leftChar = number.charAt(i);
            Character rightChar = number.charAt(number.length() - i - 1);
            if (leftChar != rightChar) {
                return false;
            }
        }
        return true;
    }

    // No conversion solution.
    // Time complexity: O(d). d - number of digits in the integer.
    private static boolean isPalindromeNoConversion(int x) {
        // Negative integers are not palindromes due to assymetrical
        // negation symbol: -.
        // Single positive digits are atuomatically palindromes.
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        // Dissassemble the integer into an array of digits and
        // process it similarly to the string conversion method.
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (x > 0) {
            digits.add(x % 10);
            x = Math.floorDiv(x, 10);
        }

        for (int i = 0; i < Math.floorDiv(digits.size(), 2); i++) {
            Integer leftInt = digits.get(i);
            Integer rightInt = digits.get(digits.size() - i - 1);
            if (leftInt != rightInt) {
                return false;
            }
        }
        return true;
    }

    // Reverse solution.
    // Time complexity: O(d). d - number of digits in the integer.
    private static boolean isPalindromeReverse(int x) {
        // Negative integers are not palindromes due to assymetrical
        // negation symbol: -.
        // Integers divisible by 10 are not palindromes either, since
        // no number starts with a 0.
        // Single positive digits are atuomatically palindromes.
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }

        // Dissassemble the integer into an array of digits.
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int temp = x;
        while (temp > 0) {
            digits.add(temp % 10);
            temp = Math.floorDiv(temp, 10);
        }

        // Construct the reverse of the integer from the
        // dissassembled digits.
        int reverseNumber = 0;
        int multiplier = (int) Math.pow((double) 10, (double) digits.size() - 1);
        for (int i = 0; i < digits.size(); i++) {
            reverseNumber += digits.get(i) * multiplier;
            multiplier /= 10;
        }

        // If the reverse integer and the original integer are
        // the same, then they are a palindrome.
        if (reverseNumber == x) {
            return true;
        } else {
            return false;
        }
    }
}
