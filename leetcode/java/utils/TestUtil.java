package leetcode.java.utils;

import java.util.Arrays;

import leetcode.java.challenges.medium.add_two_numbers.ListNode;

public class TestUtil {
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";

    private TestUtil() {
        throw new UnsupportedOperationException("TestUtil class should not be instantiated.");
    }

    public static String formatGreen(String output) {
        return GREEN + output + RESET;
    }

    public static String formatRed(String output) {
        return RED + output + RESET;
    }

    public static void test(String prefix, Boolean condition) {
        System.out.println(prefix + (condition ? formatGreen("PASS") : formatRed("FAIL")));
    }

    public static Boolean areEqual(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static Boolean areEqual(boolean bool1, boolean bool2) {
        return bool1 == bool2;
    }

    public static Boolean areEqual(ListNode linkedList1, ListNode linkedList2) {
        ListNode cursor1 = linkedList1;
        ListNode cursor2 = linkedList2;
        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val != cursor2.val) {
                return false;
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        if (cursor1 != null || cursor2 != null) {
            return false;
        }
        return true;
    }

    public static Boolean areEqual(int integer1, int integer2) {
        return integer1 == integer2;
    }

    public static Boolean areEqual(double double1, double double2) {
        return double1 == double2;
    }
}
