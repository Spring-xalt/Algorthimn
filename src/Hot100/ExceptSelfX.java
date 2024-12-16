package Hot100;

import java.util.Arrays;

// Lc 238 除自身以外数字的乘积
public class ExceptSelfX {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int []{1,0})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];   // left[i]表示长度为i的前缀乘积
        int[] right=new int[n];   // right[i]表示长度为i的后缀乘积
        int []ans=new int[n];
        left[1]=nums[0];
        for(int i=2;i<n;i++){
            left[i]=nums[i-1]*left[i-1];
        }
        right[1]=nums[n-1];
        for(int i=2;i<n;i++){
            right[i]=nums[n-i]*right[i-1];
        }
        if(n==2){
            return new int[]{right[1],left[1]};
        }
        for(int i=1;i<n-1;i++){
            // 要求ans[i]时候 应该是 (左边的长度为 i的前缀*右边的长度为n-i-1的后缀)
            ans[0]=right[n-1];
            ans[n-1]=left[n-1];
            ans[i]=left[i]*right[n-i-1];
        }
        return ans;
    }
}
