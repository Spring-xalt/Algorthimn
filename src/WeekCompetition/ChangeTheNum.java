package WeekCompetition;

import java.util.Arrays;
// Lc 3300
// 双周赛 140 t1 替换为数位和的最小元素
public class ChangeTheNum {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{10,12,13,14}));
    }
    public static int minElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=getNumPlus(nums[i]);
        }
        Arrays.sort(nums);
        return nums[0];
    }
    public static int getNumPlus(int n){
        int count=0;
        while(n>0){
            count+=n%10;
            n=n/10;
        }
        return count;
    }
}
