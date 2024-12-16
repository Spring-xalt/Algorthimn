package WeekCompetition.Double145_20241207;
// Lc 3375
import java.util.Arrays;
public class _1 {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(k>nums[0])return -1;
        int []arr=new int[101];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)count++;
        }
        return (k==nums[0])?count-1:count;
    }
}
