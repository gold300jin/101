package issue;

public class insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sorted = new ListNode(Integer.MIN_VALUE);
        // ListNode node;
        // while ((node = head) != null) {
        for(ListNode node = head; node != null;) {
            head = head.next;
            ListNode p = sorted;
            boolean isInserted = false;
            while (p.next != null) {
                if (node.val <= p.next.val) {
                    node.next = p.next;
                    p.next = node;
                    isInserted = true;
                    break;
                } else {
                    p = p.next;
                }
            }
            if (!isInserted) {
                p.next = node;
                p.next.next = null;
            }
        }
        return sorted.next;
    }

    public static void main(String[] args) {
        insertion_sort_list solution = new insertion_sort_list();
        int[] a = {4,2,1,3};
        ListNode node = new ListNode(a);
        solution.insertionSortList(node);
    }
}
