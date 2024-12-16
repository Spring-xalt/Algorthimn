package Lc_mid.SlidingTheWindow;

import java.util.HashMap;

// LC 2958  最多k重复元素的最长子数组
public class MaxKRepeatArr {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,2,1,2,1,2},1));
    }
    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int l=0,r=0,count=0,ans=0,n=nums.length;
        for(;r<n;r++){
            if(!m.containsKey(nums[r])){
                m.put(nums[r],1);
            }
            else{
                m.put(nums[r],m.get(nums[r])+1);
            }
            while(m.get(nums[r])>k){
                m.put(nums[l],m.get(nums[l])-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
