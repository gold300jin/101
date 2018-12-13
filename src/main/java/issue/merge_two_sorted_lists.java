package issue;

public class merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        merge_two_sorted_lists solution = new merge_two_sorted_lists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = null;
        solution.mergeTwoLists(l1, l2);
    }
}
