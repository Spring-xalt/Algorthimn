package Hot100;

import java.util.Arrays;

// Lc 215 数组中第k个最大元素
public class KMaxNumInArr {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
