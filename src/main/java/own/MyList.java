package own;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T v) {
        this.value = v;
        next = null;
    }
}

public class MyList<T> {
    Node<T> head;
    Node<T> tail;

    public MyList() {
        head = tail = new Node(0);
    }

    public void add(T value) {
        tail = tail.next = new Node(value);
    }

    private Node<T> get(int index) {
        if (index < 0) return null;
        int count = index;
        Node<T> p = head;
        while(count-- > 0 && (p = p.next) != null);
        return p;
    }

    public T remove(int index) {
        Node<T> pre = get(index);
        if (pre == null || pre.next == null) return null;
        T value = pre.next.value;
        pre.next = pre.next.next;
        return value;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = a -1;
        int c = b * 10 + 3;
        MyList<Integer> list = new MyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        int a = list.remove(3);
        System.out.println(a);
        return;
    }
}


