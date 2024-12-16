package Hot100;
 // Lc 152 乘积最大子数组
public class MaxArr {
     public static void main(String[] args) {
         System.out.println(maxProduct(new int[]{2,3,-2,4}));
     }
    public static int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int []dpMax=new int[n];
        int []dpMin=new int[n];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i]=Math.min(dpMin[i-1]*nums[i],Math.min(dpMax[i-1]*nums[i],nums[i]));
            max=Math.max(max,Math.max(dpMax[i],dpMin[i]));
        }
        return max;
    }
}
