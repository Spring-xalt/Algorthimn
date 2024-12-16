package Lc_mid.DP;

public class MaxSubArrPlus {
    public static void main(String[] args) {
        System.out.println(max(new int[]{-2,-3,-1}));
    }
    public static int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],Math.max(nums[1],nums[0]+nums[1]));
        int [][]dp=new int[n][n];
        //dp[i][j]表示从i到j的最大子数组的最大和
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }
        for(int i=0;i<n;i++){
            for(int j=n-1;j-i>1;j--){
                if(nums[i]<=0&&nums[j]<=0){
                    dp[i][j]=dp[i+1][j-1];
                }
                if(nums[i]>0&&nums[j]>0){
                    dp[i][j]=dp[i+1][j-1]+nums[i]+nums[j];
                }
                if(nums[i]<=0&&nums[j]>0){
                    dp[i][j]=dp[i+1][j];
                }
                if(nums[i]>0&&nums[j]<=0){
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[0][n-1];
    }
    public static int max(int []nums){
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],Math.max(nums[1],nums[0]+nums[1]));
        int[] s=new int[n];
        s[0]=nums[0];
        for(int i=1;i<n;i++){
            s[i]=s[i-1]+nums[i];
        }
        int i=1,j=n-1;
        int max=s[j];
        while(j-i>1){
            max=Math.max(max,s[j]-s[i-1]);
            if(nums[i]<=0||nums[j]<=0){
                if(nums[i]<=0){
                    i++;
                }
                if(nums[j]<=0){
                    j--;
                }
            }
            else{
                i++;
                j--;
            }
        }
        return max;
    }
}
