package java.leetcode.partition;

public class solution {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            this.val = x;
        }

        public ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    // Partition List
    /*
     * Input: head = [1,4,3,2,5,2], x = 3
     * Output: [1,2,2,4,3,5]
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode lTail = left;
        ListNode rTail = right;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = lTail.next;
            } else {
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }
        // spajanje 2 povezane liste
        lTail.next = right.next;
        rTail.next = null;
        return left.next;
    }
}
