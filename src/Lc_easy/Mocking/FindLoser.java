package Lc_easy.Mocking;

import java.util.ArrayList;

// Lc 2682 找出转圈游戏输家
public class FindLoser {
    public static int[] circularGameLosers(int n, int k) {
        int []arr=new int[n];
        int d=k,l=n;
        for(int i=0;arr[i]<2;d+=k,l--){
            arr[i]++;
            if(arr[i]==2)break;
            i=(i+d)%n;
        }
        int []ans=new int[l];
        for(int i=0,j=0;i<n;i++){
            if(arr[i]==0){
                ans[j++]=i+1;
            }
        }
        return ans;
    }
}
