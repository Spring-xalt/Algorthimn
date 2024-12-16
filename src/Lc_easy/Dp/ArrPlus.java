package Lc_easy.Dp;
// 1480 一维数组动态和
public class ArrPlus {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int []s=new int[n];
        s[0]=nums[0];
        for(int i=1;i<n;i++){
            s[i]=nums[i]+s[i-1];
        }
        return s;
    }
}
