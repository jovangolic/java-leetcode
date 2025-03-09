package java.leetcode.addTwoNumbers;

public class solution {

    // Add Two Numbers
    /*
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0); // pomocna lista za rezultat
        ListNode pointer = result; // pokazivac na poslednji dodati cvor
        while (l1 != null || l2 != null) {
            int sum = 0 + carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }
        if (carry == 1) {
            pointer.next = new ListNode(1);
        }
        /*
         * Pošto smo result inicijalizovali kao 0, ne želimo da vratimo taj prvi dummy
         * čvor, već samo pravu sumu. Zato vraćamo result.next, tj. prvi pravi čvor u
         * rezultujućoj listi.
         */
        return result.next;
    }
}
