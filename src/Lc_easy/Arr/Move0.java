package Lc_easy.Arr;

import java.util.Arrays;

public class Move0 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }
    // Lc 283 移动0
    public static int[] moveZeroes(int[] nums) {
        if(nums.length==1&&nums[0]==0)return nums;
        int l=nums.length;
        // 数组记录到该下标之前0的个数，即为非0元素向前移动的位数
        int []a=new int[l];
        a[0]=0;
        a[1]=(nums[0]==0)?1:0;
        for(int i=1;i<l;i++){
            if(nums[i-1]==0){
                a[i]=a[i-1]+1;
            }
            else{
                a[i]=a[i-1];
            }
        }
        int count=(nums[l-1]==0)?(a[l-1]+1):a[l-1];
        for(int i=0;i<l;i++){
            if(nums[i]!=0) {
                nums[i-a[i]]=nums[i];
            }
        }
        for(int i=l-1;l-i-1<count;i--){
            nums[i]=0;
        }
        return nums;
    }
}
