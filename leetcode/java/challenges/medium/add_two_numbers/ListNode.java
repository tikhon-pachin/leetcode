package leetcode.java.challenges.medium.add_two_numbers;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        String constructed = "[";
        if (next != null) {
            constructed += Integer.toString(val) + ",";
            return next.toString(constructed);
        } else {
            return constructed + Integer.toString(val) + "]";
        }
    }

    public String toString(String constructed) {
        if (next != null) {
            constructed += Integer.toString(val) + ",";
            return next.toString(constructed);
        } else {
            return constructed + Integer.toString(val) + "]";
        }
    }
}
