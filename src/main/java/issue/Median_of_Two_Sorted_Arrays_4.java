package issue;

public class Median_of_Two_Sorted_Arrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] allNums = new int[totalLength];
        for (int i =0, j = 0; i + j < totalLength; ) {
            int count = i + j;
            if (i == nums1.length) {
                allNums[count] = nums2[j++];
                continue;
            }
            if (j == nums2.length) {
                allNums[count] = nums1[i++];
                continue;
            }
            allNums[count] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        int middle = totalLength / 2;
        return totalLength % 2 == 0 ? (allNums[middle] + allNums[middle - 1]) / (double)2 :
                allNums[middle];
    }

    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays_4 solution = new Median_of_Two_Sorted_Arrays_4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
