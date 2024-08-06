package leetcode.java.challenges.medium.zigzag_conversion;

import java.util.HashMap;
import java.util.LinkedHashMap;

import leetcode.java.utils.TestData;
import leetcode.java.utils.TestUtil;

public class Solution {
    private static String method = "Solution";

    public static void main(String[] args) {
        // Tests and their inputs with expected outputs:
        LinkedHashMap<String, TestData<String>> tests = new LinkedHashMap<String, TestData<String>>();
        LinkedHashMap<Input, String> inputs = new LinkedHashMap<Input, String>();
        inputs.put(new Input("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        inputs.put(new Input("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
        inputs.put(new Input("A", 1), "A");
        inputs.put(new Input("AB", 1), "AB");
        inputs.put(new Input("ABC", 1), "ABC");

        // Hash Table tests:
        method = "Hash Table";
        inputs.forEach((input, expectedOutput) -> {
            tests.put(method + " - " + input.getInput1() + ", " + input.getInput2(),
                    new TestData<String>(convertHashTable(input.getInput1(), input.getInput2()), expectedOutput));
        });

        // Compare all output results with expected ones.
        TestUtil.run(tests);
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
