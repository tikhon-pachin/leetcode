package leetcode.java.challenges.medium.zigzag_conversion;

import java.util.HashMap;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();

        // Hash Table tests:
        tests.put("Hash Table test 1 (s: \"PAYPALISHIRING\", numRows: 3): ",
                new TestData(convertHashTable("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR"));
        tests.put("Hash Table test 2 (s: \"PAYPALISHIRING\", numRows: 4): ",
                new TestData(convertHashTable("PAYPALISHIRING", 4), "PINALSIGYAHRPI"));
        tests.put("Hash Table test 3 (s: \"A\", numRows: 1): ",
                new TestData(convertHashTable("A", 1), "A"));
        tests.put("Hash Table test 4 (s: \"AB\", numRows: 1): ",
                new TestData(convertHashTable("AB", 1), "AB"));
        tests.put("Hash Table test 5 (s: \"ABC\", numRows: 1): ",
                new TestData(convertHashTable("ABC", 1), "ABC"));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Hash Table solution.
    // Time complexity: O(s + n). n, s - number of rows and string length
    // respectively.
    private static String convertHashTable(String s, int numRows) {
        // If the number of rows is 1, then there are is no zigzag.
        if (numRows == 1) {
            return s;
        }

        // Create a O(1) access matrix.
        HashMap<Integer, String> stringMap = new HashMap<Integer, String>();

        // Setup row traversal.
        int row = 0;
        int rowIterator = 1;

        // For each character, put it in the correct row/column.
        // Each subsequent letter goes in the next row until the number
        // of row is reached and then it goes back, moving on to the next
        // column to avoid overwriting existing row string.
        for (int i = 0; i < s.length(); i++) {
            // Create a new row substring or add to an existing row.
            if (!stringMap.containsKey(row)) {
                stringMap.put(row, Character.toString(s.charAt(i)));
            } else {
                stringMap.put(row, stringMap.get(row) + s.charAt(i));
            }

            // Move on to the next row in the current order.
            row += rowIterator;

            // Reverse the direction of row traversal.
            if (row + rowIterator == numRows || row + rowIterator < 0) {
                rowIterator *= -1;
            }
        }

        // Resonctruct the final string.
        String resultString = "";
        for (int i = 0; i < numRows; i++) {
            if (stringMap.get(i) != null) {
                resultString += stringMap.get(i);
            }
        }

        return resultString;
    }
}
