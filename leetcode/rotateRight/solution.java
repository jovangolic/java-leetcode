package java.leetcode.rotateRight;

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

    // rotate list
    /*
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     */
    /*
     * Ako želiš da obradiš celu listu, koristi while (tail != null).
     * Ako želiš da nađeš poslednji čvor, koristi while (tail.next != null).
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode cur = head;
        for (var i = 0; i < len - k - 1; i++) {
            cur = cur.next;
        }
        ListNode newCur = cur.next;
        cur.next = null;
        tail.next = head;
        return newCur;
    }
}
