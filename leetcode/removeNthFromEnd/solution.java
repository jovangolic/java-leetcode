package java.leetcode.removeNthFromEnd;

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

    // Remove Nth Node From End of List
    /*
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode fpt = dummy;
        ListNode spt = dummy;
        // pravljenje prozora
        for (var i = 0; i < n; i++) {
            spt = spt.next;
        }
        while (spt.next != null) {
            fpt = fpt.next;
            spt = spt.next;
        }
        fpt.next = fpt.next.next;
        return dummy.next;
    }
}
