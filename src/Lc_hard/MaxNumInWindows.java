package Lc_hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 滑动窗口最大值  Lc 239
public class MaxNumInWindows {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    // 暴力解法 O(nk)  一定会爆时间
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int r=k-1;
        int []arr=new int[nums.length-r];
        while(r<nums.length){
            arr[r-k+1]=getMaxInSubArray(nums,r-k+1,r);
            r++;
        }
        return arr;
    }
    public static int getMaxInSubArray(int[] nums, int l ,int r) {
        int max=nums[l];
        for(int i=l;i<=r;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }
    // 双端单调队列实现 一次遍历 每次在k范围可视时 遇到小元素pass 遇到大于等于的元素就 去掉队列头部元素 并更新
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n=nums.length;
        int []arr=new int[n-k+1];
        // 存储每个范围内有序元素的下标
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // 遇到小元素
            while(!q.isEmpty() && nums[q.getLast()]<nums[i]){
                  q.removeLast();
            }
            q.addLast(i);
            // 不在视野范围内 即第一个元素到最后一个元素之间距离超过k
            if(i-q.getFirst()>=k){
                q.removeFirst();
            }
            // i要越过第一个窗口前开始 记录答案
            if(i>=k-1){
                // 从第一个窗口开始的 队首元素就是 每个窗口的max
                arr[i-k+1]=nums[q.getFirst()];
            }
        }
        return arr;
    }
}
