package java.leetcode.deleteDuplicates;

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

    // Remove Duplicates from Sorted List II
    /*
     * Input: head = [1,2,3,3,4,4,5]
     * Output: [1,2,5]
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // ako je pronadjen jedan duplikat, proverava se da li ih ima jos
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
