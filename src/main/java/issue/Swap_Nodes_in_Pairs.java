package issue;

import java.util.HashMap;
import java.util.Map;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs2(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode nextHead = head;
        ListNode point = result;
        while(nextHead != null) {
            if (nextHead.next != null) {
                ListNode tmpHead = nextHead.next.next;
                point.next = nextHead.next;
                point = point.next.next = nextHead;
                nextHead = tmpHead;
            } else {
                point = point.next = nextHead;
                nextHead = null;
            }
        }
        point.next = null;
        return result.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next.next;
        ListNode tmpHead = head.next;
        head.next.next = head;
        head.next = swapPairs(next);
        return tmpHead;
    }

    static final int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a","b");

        int a = tableSizeFor(12);
        System.out.println(a);

        Swap_Nodes_in_Pairs solution = new Swap_Nodes_in_Pairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = solution.swapPairs(head);
    }
}
