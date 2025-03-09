package java.leetcode.mergeTwoLists;

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

    // merge two sorted lists
    /*
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if (list1 == null) {
            result.next = list2;
        } else if (list2 == null) {
            result.next = list1;
        }
        /*
         * Na kraju, ako bismo vratili result.next, vratili bismo neki deo liste u
         * sredini. Zato vracamo pt.next, koji pokazuje na prvi pravi cvor u rezultatu.
         */
        return pointer.next;
    }
}
