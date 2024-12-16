package Lc_easy.Arr;
//Lc 5 最长回文子串
import java.util.Arrays;

public class arrPingfang {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
