package sort;

import java.util.Arrays;

public class Sort {

    public void selectSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            swap(nums, i, min);
        }
    }

    public void bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
    }

    public void insertSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j , j - 1);
            }
        }
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int[] aux = Arrays.copyOf(nums, nums.length);
        int i = l, j = mid + 1;
        for (int cur = l; cur <= r; cur++) {
            if (i > mid) nums[cur] = aux[j++];
            else if (j > r) nums[cur] = aux[i++];
            else if (aux[i] <= aux[j]) nums[cur] = aux[i++];
            else nums[cur] = aux[j++];
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int index = partition(nums, l, r);
        quickSort(nums, l, index - 1);
        quickSort(nums, index + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        int pivot = nums[(l + r) / 2];
        while (l < r) {
            while (nums[l] < pivot) l++;
            while (nums[r] > pivot) r--;
            if (l < r) {
                swap(nums, l ,r);
            }
        }
        return l;
    }



    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {11, 33, 2, 312, 333, 123, 23};
        Sort sort = new Sort();
        sort.quickSort(nums, 0, nums.length - 1);

        for (int a : nums) {
            System.out.print(a + " ");
        }
        return;
    }
}
