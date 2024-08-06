package leetcode.java.challenges.easy.palindrome_number;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Tests and their inputs with expected outputs:
        LinkedHashMap<String, TestData<Boolean>> tests = new LinkedHashMap<String, TestData<Boolean>>();
        LinkedHashMap<Input, Boolean> inputs = new LinkedHashMap<Input, Boolean>();
        inputs.put(new Input(121), true);
        inputs.put(new Input(1221), true);
        inputs.put(new Input(0), true);
        inputs.put(new Input(-121), false);
        inputs.put(new Input(10), false);
        inputs.put(new Input(100), false);
        inputs.put(new Input(123), false);

        // String Conversion tests:
        method = "String Conversion";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1(),
                    new TestData<Boolean>(isPalindromeStringConversion(input.getInput1()), expectedOutput));
        });

        // No Conversion tests:
        method = "No Conversion";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1(),
                    new TestData<Boolean>(isPalindromeNoConversion(input.getInput1()), expectedOutput));
        });

        // Reverse tests:
        method = "Reverse";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1(),
                    new TestData<Boolean>(isPalindromeReverse(input.getInput1()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
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
