package Lc_mid.SlidingTheWindow;
// Lc 2695删除子数组的最大得分
import java.util.HashMap;
public class DeleteSubArr {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int []{5,2,1,2,5,2,1,2,5}));
    }
    public static int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int l=0,r=0,count=0,ans=0,n=nums.length;
        for(;r<n;r++){
            if(!m.containsKey(nums[r])){
                m.put(nums[r],r);
                count+=nums[r];
            }
            else{
                l=Math.max(l,m.get(nums[r])+1);
                count=0;
                for(int i=l;i<=r;i++){
                    count+=nums[i];
                }
                m.put(nums[r],r);
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
