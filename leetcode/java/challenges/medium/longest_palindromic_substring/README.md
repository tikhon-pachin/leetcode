# Notes

Leetcode link: [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

## Solution

Method: Brute Force using precomputed palindromes.\
Time complexity: `O(n^2)`

```java
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
```
