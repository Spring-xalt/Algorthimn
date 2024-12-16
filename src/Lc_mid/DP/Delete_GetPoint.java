package Lc_mid.DP;

import java.util.Arrays;

// Lc 740 删除能获得点数
public class Delete_GetPoint {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
    }
    public static int deleteAndEarn(int[] nums) {
        int n=nums.length;
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        //dp[i]表示到检索到数字i时的获得的最大点数
        //dp[i]=max(dp[i-1],dp[i-2]+sum[i]*i)
        //sum[i]表示nums[]数组中i的出现次数
        int max=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int []sum=new int[max+1];
        for(int i=0;i<nums.length;i++){
            sum[nums[i]]++;
        }
        int []dp=new int[max+1];
        dp[0]=0;
        dp[1]=sum[1];
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+sum[i]*i);
        }
        return dp[max];
    }
}
