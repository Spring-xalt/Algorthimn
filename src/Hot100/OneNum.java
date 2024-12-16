package Hot100;
// Lc 136 只出现一次的数字
public class OneNum {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int a=nums[0];
        for(int i=1;i<n;i++){
            a^=nums[i];
        }
        return a;
    }
}
