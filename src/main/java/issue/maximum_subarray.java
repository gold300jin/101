package issue;

public class maximum_subarray {
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length - 1).value;
    }

    MaxArray getMax(int[] nums, int l, int r) {
        if (l == r) return new MaxArray(l, r , nums[l]);
        MaxArray leftArray = getMax(nums, l, (l + r) / 2 - 1);
        MaxArray rightArray = getMax(nums,(l + r) / 2,  r);
        int middleValue = 0;
        for (int i = leftArray.right + 1; i < rightArray.left - 1; i++) {
            middleValue+=nums[i];
        }
        if (Math.min(leftArray.value, rightArray.value) + middleValue > 0) {
            return new MaxArray(leftArray.left, rightArray.right, leftArray.value + rightArray.value + middleValue);
        } else {
            return leftArray.value > rightArray.value ? leftArray : rightArray;
        }
    }

    private class MaxArray {
        int left;
        int right;
        int value;
        public MaxArray(int l, int r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }

    public static void main(String[] args) {
        maximum_subarray solution = new maximum_subarray();
        int[] a = {1, -1, 2};
        int b = solution.maxSubArray(a);
        return;
    }
}
