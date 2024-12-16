package WeekCompetition._20241208;

public class _3 {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int []{1,2},1));
    }
    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组，用来存储从0到i的和
        int[] prefixSum = new int[n];
        // 填充前缀和
        prefixSum[0] = nums[0];
        for (int i = 0; i < n-1; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i+1];
        }
        int maxSum = Integer.MIN_VALUE;
        // 遍历所有长度是k的倍数的子数组
        for (int length = k; length <= n; length += k) {
            for (int start = 0; start <= n - length-1; start++) {
                int end = start + length-1;
                int sum = 1;
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
