package WeekCompetition._20241208;

import java.util.Arrays;

public class _1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{-10,-10})));
    }
    public static int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        if(n==1)return new int[]{nums[0]};
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            int count=i;
            if(nums[i]==0){
                ans[i]=nums[i];
            }
            else if(nums[i]>0){
                count=(i+nums[i])%n;
                ans[i]=nums[count];
            }
            else{
                if(i+nums[i]>=0){
                    count=i+nums[i];
                }
                else{
                    int steps=Math.abs(nums[i])%n;// 取绝对值并对n取模
                    count=(i-steps+n)%n;
                }
                ans[i]=nums[count];
            }
        }
        return ans;
    }
}
