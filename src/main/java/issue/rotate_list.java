package issue;


public class rotate_list {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int length = 1;
        ListNode p = head, tail = head;
        while ((p = p.next) != null) {
            tail = p;
            length++;
        }
        int r = length - (k % length + length) % length;
        if (r == 0) return head;
        p = head;
        int r2 = r - 1;
        while (r2-- > 0) {
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        int a = -5;
        int b = a % 3;
        return;
    }
}
