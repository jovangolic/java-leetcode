package java.leetcode.reverseBetween;

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

    // Reverse Linked List II
    /*
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy = head.next;
        ListNode leftPrev = dummy;
        ListNode cur = head;
        for (var i = 0; i < left - 1; i++) {
            leftPrev = leftPrev.next;
            cur = cur.next;
        }
        ListNode subListHead = cur;
        ListNode preNode = null;
        for (var i = 0; i <= right - left; i++) {
            ListNode nextNode = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = nextNode;
        }
        leftPrev.next = preNode;
        subListHead.next = cur;
        return dummy.next;
    }
}
