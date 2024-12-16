package Lc_easy.Dp;

//正负整数的最大值
public class PfPlus {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{5,20,66,1314}));
    }
    public static  int maximumCount(int[] nums) {
        int n=nums.length;
        int z=0,f=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0)z++;
            if(nums[i]>0)f++;
        }
        return (z>=f)?z:f;
    }
}
