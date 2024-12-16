package Lc_mid.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Lc 3186 施咒语的最大伤害  注意复习!!!!!!!!!
public class MaxHurtForCharm {
    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new  int[]{1,1,1,1,1,1}));
    }
    public static long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> cnt = new HashMap<>();
        for (int x:power) {
            cnt.merge(x,1, Integer::sum);
        }
        int n=cnt.size();
        int[]a=new int[n];
        int k=0;
        for (int x:cnt.keySet()) {
            a[k++]=x;
        }
        Arrays.sort(a);
        long[] f=new long[n+1];
        int j=0;
        for(int i=0;i<n;i++) {
            int x=a[i];
            while(a[j]<x-2) {
                j++;
            }
            f[i+1]=Math.max(f[i],f[j]+(long)x*cnt.get(x));
        }
        return f[n];
    }
}