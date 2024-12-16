package Lc_mid.DP;

import java.util.Arrays;

// Lc 918 环形子数组最大和
public class HuanSubArrMaxPlus {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        //分为 使用了环 和未使用环
        // 未使用环 求数组内的最大值即可
        // 使用了 则求数组内最小值 做差即可

        int n = nums.length;
        if(n==1)return nums[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int max = Integer.MIN_VALUE;
        int max1 = nums[0];
        max = Math.max(max, max1);
        for (int i = 1; i < n; i++) {
            if (max1 < 0) {
                max1 = nums[i];
            } else {
                max1 += nums[i];
            }
            max = Math.max(max, max1);
        }
        int min1 = nums[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (min1 > 0) {
                min1 = nums[i];
            }
            else {
                min1 += nums[i];
            }
            min = Math.min(min, min1);
        }
        // 原题不允许空子数组 ，防止算出的最小子数组和原数组一样
        int max2=max1;
        if(sum!=min){
            max2=sum-min;
        }
        max = Math.max(max, max2);
        return max;
    }
}
