package Lc_easy;

import java.util.ArrayList;
import java.util.List;

public class FindNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<Integer>();
        boolean []hasExist = new boolean[n+1];
        for(int i=0;i<n;i++){
            hasExist[nums[i]]=true;
        }
        for(int i=1;i<=n;i++){
            if(!hasExist[i]){
                l.add(i);
            }
        }
        return l;
    }
}