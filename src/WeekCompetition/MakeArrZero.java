package WeekCompetition;

import java.util.Arrays;

// Lc 3354 使得数组为0
public class MakeArrZero {
    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{1,0,2,0,3}));
    }
    public static int countValidSelections(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                boolean left = false;  //还未向左运动
                int k = i;
                int []arr= Arrays.copyOf(nums, nums.length);  //拷贝一个新数组，对新数组操作
                //向左运动
                int direction= -1;    //向左运动为-1
                    k+=direction;
                    while (k >= 0 && k < arr.length) {
                        if(arr[k]==0) k += direction;
                        else{
                            arr[k]--;
                            direction*=-1;
                            k+=direction;
                        }
                    }
                    if(allzero(arr))ans++;
                    left = true;
                    arr= Arrays.copyOf(nums, nums.length);
                // 向右
                if(left){
                    k=i;
                    direction=1;
                    k+=direction;
                    while(k >= 0 && k < arr.length) {
                        if(arr[k]==0) k += direction;
                        else{
                            arr[k]--;
                            direction*=-1;
                            k+=direction;
                        }
                    }
                }
                if(allzero(arr))ans++;
                arr= Arrays.copyOf(nums, nums.length);
            }
        }
        return ans;
    }
    public static boolean allzero(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)return false;
        }
        return true;
    }
}