package Lc_mid.SlidingTheWindow;

import java.util.HashMap;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:
 */
public class SumIsKSubArr {
    public static int subarraySum(int[] nums, int k) {
            int []arr=new int[nums.length];
            arr[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                arr[i] = arr[i-1]+nums[i];
            }
            int ans=0;
            for(int i=0;i<nums.length;i++){
                ans+=arr[i]==k?1:0;
            }
            for(int i=0;i<nums.length-1;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(arr[j]-arr[i]==k){
                        ans++;
                    }
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum2(int[] nums, int k) {
        int []arr=new int[nums.length];
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i] = arr[i-1]+nums[i];
        }
        int res = 0;
        HashMap<Integer,Integer> preCnt=new HashMap<>();
        for (int sj:arr){
            int si=sj-k;
            if (preCnt.containsKey(si)) { //已遍历元素中存在si
                res+=preCnt.get(si);  //加上相应的个数
            }
            // 记录sj出现次数
            preCnt.put(sj, preCnt.getOrDefault(sj, 0) + 1);
        }
        return res;


    }
}
