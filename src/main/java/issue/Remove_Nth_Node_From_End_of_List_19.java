package issue;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode(int[] x) {
        if (x.length == 0) return;
        val = x[0];
        if (x.length == 1) {
            return;
        }
        next = new ListNode(x[1]);
        ListNode p = next;
        for (int i = 2; i < x.length; i++) {
            p.next = new ListNode(x[i]);
            p = p.next;
        }
    }
}


public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quickQuery = head;
        ListNode slowQuery = head;
        int count = 1;
        int totalNum = 0;
        while(true) {
            totalNum++;
            quickQuery = quickQuery.next;
            if (quickQuery == null) {
                break;
            }
            if (count > n) {
                slowQuery = slowQuery.next;
            }
            count++;
        }
        if (totalNum == n) {
            return head.next;
        } else {
            slowQuery.next = slowQuery.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        ListNode a = head;
//        a = new ListNode(4);
        a.next = new ListNode(4);
        System.out.println(head.next.val);
    }
}

