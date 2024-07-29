# Notes

Leetcode link: [Palindrome Number](https://leetcode.com/problems/palindrome-number/)

## Solutions

### Solution 1

Method: String Conversion.\
Time complexity: `O(d)`. `d` - number of digits in the given integer.

```java
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
```

### Solution 2

Method: No Conversion.\
Time complexity: `O(d)`. `d` - number of digits in the given integer.

```java
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
```

### Solution 3

Method: Reverse Integer.\
Time complexity: `O(d)`. `d` - number of digits in the given integer.

```java
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
```
