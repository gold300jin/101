package own;

public class BinarySearch {

    public int execute(int[] eles, int data) {
        int len = eles.length;
        if (len == 0) return -1;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data > eles[mid]) {
                l = mid + 1;
            } else if (data < eles[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] a = {1,2,3,4,5,6,7};
        int b = solution.execute(a, 7);
        System.out.println(b);
    }
}
