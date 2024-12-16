package Lc_mid.DP;
// Lc 213   打家劫舍2
public class RobII {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{4,1,2}));
    }
    public static int rob(int[] nums) {
        //对于 198打家劫舍的进阶版本，目标数组受到环形限制
        /*对于长度大于3的数组:
            若选择了nums[0],nums[1]和nums[n-1]不能选,即为从数组0到n-2的I版本
            若未选择nums[0],nums[1]和nums[n-1]可以选，则是数组1到n-1的I版本
        */
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        if(n==3)return Math.max(nums[0],Math.max(nums[1],nums[2]));
        boolean first=false;
        int []dp=new int[n];
        int max1=0,max2=0;
        dp[0]=nums[0];
        //选择了nums[0]
        dp[1]=nums[0];
        for(int i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            if(i==n-2)max1=dp[n-2];
        }
        //未选择nums[0]
        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            if(i==n-1)max2=dp[n-1];
        }
        return Math.max(max1,max2);
    }
}
