package Hot100;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:   Lc 189 轮转数组
 */
public class GoArr {
    public static void rotate(int[] nums, int k) {
        //用队列实现
        int n=nums.length;
        k%=n;
        Queue<Integer> q=new ArrayDeque<>();
        for(int x=n-k;x<n;x++){
            q.add(nums[x]);
        }
        for(int i=0;i<n-k;i++){
            q.add(nums[i]);
        }
        for(int i=0;i<n;i++) {
            nums[i] = q.poll();
        }
        for(int i=0;i<n;i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
        rotate2(new int[]{1,2,3,4,5,6,7},3);
    }
    public static void rotate2(int[] nums, int k){
        // 三次翻转实现： 先整体翻转 接着翻转前k个 再翻转后n-k个
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] nums,int i,int j) {
        while(i<j) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
