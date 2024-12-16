package Lc_mid.DP;
// Lc 300 最长递增子序列
public class MaxRaisingSubArr {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        // dp[i]表示 直到下标为 i 前面的子序列中的递增子序列长度
        int ans=1;// 只有一个元素时候不会进入循环 ，需要设置为1
        if(n==0)return 0;
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
