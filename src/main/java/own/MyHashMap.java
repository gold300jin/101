package own;

public class MyHashMap<K, V> {

    static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;

        Node(K k, V v, int h, Node<K, V> n) {
            this.key = k;
            this.value = v;
            this.hash = h;
            this.next = n;
        }
    }

    private Node<K, V>[] table;
    private int size;

    MyHashMap(int capacity) {
        table = new Node[capacity];
        size = 0;
    }

    public V put(K key, V value) {
        int hash = key.hashCode();
        int index = (table.length - 1) & hash;
        Node<K, V> p, e;
        if ((p = table[index]) == null) {
            table[index] = new Node<>(key, value, hash, null);
        } else {
            if (p.hash == hash && p.key == key) {
                e = p;
            } else {
                for (int binCount = 0;;binCount++) {
                    if ((e = p.next) == null) {
                        p.next = new Node<>(key, value, hash, null);
                        break;
                    }
                    if (e.hash == hash && e.key == key) {
                        break;
                    }
                    p = e;
                }
            }
            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        size++;
        return null;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = (table.length - 1) & hash;
        Node<K, V> first, p;
        if ((p = first = table[index]) != null) {
            if (first.key == key) {
                return first.value;
            }
            while ((p = p.next) != null) {
                if (p.key == key) {
                    return p.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>(10);
        map.put("a", "1");
        map.put("k", "5");
        map.put("a", "21");
        map.put("b", "22");
        map.put("c", "23");
        map.put("d", "24");
        map.put("e", "25");
        map.put("f", "26");
        String a =map.get("f");
        System.out.println(a);
    }
}
