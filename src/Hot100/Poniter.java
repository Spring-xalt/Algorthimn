package Hot100;

import java.util.*;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 15 三数之和
 */
public class Poniter {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<List<Integer>,Integer> m=new HashMap<>();
        Arrays.sort(nums);

        for(int k=0;k<nums.length;k++){
            for(int j=k+1;j<nums.length && k!=j;j++){
                for(int i=j+1;i<nums.length&&i!=j;i++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l=new ArrayList<>();

                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);

                        Collections.sort(l);
                        if(!m.containsKey(l)){
                            m.put(l,0);
                            res.add(l);
                        }
                    }
                }
            }
        }
        return res;
    }
    // 双指针加 优化
    public static List<List<Integer>> threeSum2(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for(int i=0;i<n-2;i++) {
                int x = nums[i];
                if (x > 0) {
                    break;
                }
                if(i>0&&nums[i]==nums[i-1]) {
                    continue;
                }
                if(i<=n-3&&x+nums[i+1]+nums[i+2]>0) {
                    break;
                }
                if (x + nums[n - 1] + nums[n - 2] < 0) {
                    continue;
                }
            //}
                int j=i+1,k=n-1;
                while(j<k){
                    int ans=x+nums[j]+nums[k];
                    if(ans>0){
                        while(k>j&&nums[k]==nums[--k]){

                        }
                        // k--; 在此处可以 跳过相同元素同时 进行移动元素 缩短时间优化
                    }
                    else if(ans<0){
                        while(j<k&&nums[j]==nums[++j]) {

                        }
                    }
                    else{
                        res.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                        while(j<k&&nums[j]==nums[++j]) {

                        }
                        while(k>j&&nums[k]==nums[--k]){

                        }
                    }
                }
            }
            return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
}
