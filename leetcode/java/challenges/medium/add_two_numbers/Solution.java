package leetcode.java.challenges.medium.add_two_numbers;

import java.util.LinkedHashMap;

import leetcode.java.utils.TestUtil;

public class Solution {
    public static void main(String[] args) {
        // Test suite collection:
        LinkedHashMap<String, TestData> tests = new LinkedHashMap<String, TestData>();
        ListNode test1Input1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode test1Input2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode test2Input1 = new ListNode(0);
        ListNode test2Input2 = new ListNode(0);
        ListNode test3Input1 = new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode test3Input2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode test4Input1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode test4Input2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));

        // Tests:
        tests.put("Test 1 (input1: [2,4,3], input2: [5,6,4]): ",
                new TestData(addTwoNumbers(test1Input1, test1Input2),
                        new ListNode(7, new ListNode(0, new ListNode(8)))));
        tests.put("Test 2 (input1: [0], input2: [0]): ",
                new TestData(addTwoNumbers(test2Input1, test2Input2),
                        new ListNode(0)));
        tests.put("Test 3 (input1: [9,9,9,9,9,9,9], input2: [9,9,9,9]): ",
                new TestData(addTwoNumbers(test3Input1, test3Input2),
                        new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))))));
        tests.put("Test 4 (input1: [2,4,9], input2: [5,6,4,9]): ",
                new TestData(addTwoNumbers(test4Input1, test4Input2),
                        new ListNode(7, new ListNode(0, new ListNode(4, new ListNode(0, new ListNode(1)))))));

        // Compare all output results with expected ones.
        tests.forEach((testName, testData) -> {
            TestUtil.test(testName, TestUtil.areEqual(testData.getActualOutput(), testData.getExpectedOutput()));
        });
    }

    // Solution.
    // Time complexity: O(l). l - number of nodes in the larger linked list.
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Add a flag to show that a sum of digits is above 10.
        boolean hasCarry = false;
        // Setup cursors to go through each linked list.
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        // Setup the output with its cursor.
        ListNode sum = null;
        ListNode cursor3 = sum;

        // Perform addition going through each digit until one or both numbers run out
        // of digits.
        while (cursor1 != null && cursor2 != null) {
            // Create either a new linked list or move to a new node for each addition.
            if (sum == null) {
                sum = new ListNode();
                cursor3 = sum;
            } else {
                cursor3 = moveResultCursor(cursor3);
            }

            // Add the respective digits and a possible carry from the previous addition.
            cursor3.val = cursor1.val + cursor2.val + (hasCarry ? 1 : 0);

            // Determine if the carry is necessary on the next addition.
            hasCarry = extractedCarry(cursor3);

            // Move the number cursors.
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }

        // In case one number runs out of digits before the other, we need
        // to complete addition based on the longer number.
        // In other case we only check for remaining carry.
        if (cursor1 != null) {
            cursor3 = finishLargerNumber(cursor3, cursor1, hasCarry);
        } else if (cursor2 != null) {
            cursor3 = finishLargerNumber(cursor3, cursor2, hasCarry);
        } else if (hasCarry) {
            cursor3.next = new ListNode(1);
        }

        return sum;
    }

    // Determine carry necessity.
    private static boolean extractedCarry(ListNode cursor) {
        // If the result is larger than 9, this means that there will be a carry
        // to the next digit and the current digit only gets the mod of the total
        // sum.
        if (cursor.val >= 10) {
            cursor.val = cursor.val % 10;
            return true;
        } else {
            return false;
        }
    }

    // The result is technically null until we create a new node.
    // We will only create nodes a necessary when moving to the next node.
    private static ListNode moveResultCursor(ListNode cursor) {
        if (cursor.next == null) {
            cursor.next = new ListNode();
            return cursor.next;
        }
        return cursor.next;
    }

    // In many cases, one number in the addition will have more digits than the
    // other.
    // During addition, we have to add digits with one another in a respective
    // order, but
    // the carry may traverse as far as the last digit of the longer number, so we
    // have to
    // finish parsing it to rem
    private static ListNode finishLargerNumber(ListNode resultCursor, ListNode largerNumberCursor, boolean hasCarry) {
        while (largerNumberCursor != null) {
            // Create a new node for the result.
            resultCursor = moveResultCursor(resultCursor);

            // Complete addition.
            resultCursor.val = largerNumberCursor.val + (hasCarry ? 1 : 0);

            // Determine if a carry is necessary for the next addition.
            hasCarry = extractedCarry(resultCursor);

            // Move the cursor of the larger number.
            largerNumberCursor = largerNumberCursor.next;
        }

        // Add remaining carry as a new digit of the resulting number.
        if (hasCarry) {
            resultCursor.next = new ListNode(1);
        }

        return resultCursor;
    }
}
