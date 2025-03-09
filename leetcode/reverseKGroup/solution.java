package java.leetcode.reverseKGroup;

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

    // Reverse Nodes in k-Group
    /*
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode groupPrev = dummy;
        while (true) {
            // kth pokazuje na poslednji cvor trenutne grupe
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            // pokazuje na prvi cvor sledece grupe
            ListNode groupNext = kth.next;
            // reverse group, koristimo dva pokazivaca
            ListNode prevNode = kth.next;
            ListNode cur = groupPrev.next;
            while (cur != groupNext) {
                ListNode tempNode = cur.next;
                cur.next = prevNode;
                prevNode = cur;
                cur = tempNode;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = prevNode;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private static ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
