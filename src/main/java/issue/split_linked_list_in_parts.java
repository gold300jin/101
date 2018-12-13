package issue;

public class split_linked_list_in_parts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k <= 0) return null;
        ListNode[] result = new ListNode[k];
        if (root == null) return result;
        if (k == 1) {
            result[0] = root;
            return result;
        }
        int length = 1;
        ListNode p = root;
        while ((p = p.next) != null) length++;
        int m = length / k;
        int n = length % k;
        p = root;
        result[0] = p;
        for (int i = 1; i < k; i++) {
            int count = m;
            if (i <= n)count++;
            ListNode pre = p;
            if (count == 0) {
                result[i] = null;
                continue;
            }
            while (count-- > 0) {
                p = p.next;
                if (count > 0) pre = pre.next;
            }
            pre.next = null;
            result[i] = p;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode a = new ListNode(x);
        split_linked_list_in_parts solution = new split_linked_list_in_parts();
        ListNode[] result = solution.splitListToParts(a, 3);
        return;
    }
}
