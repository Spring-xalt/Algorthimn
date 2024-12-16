package Lc_mid.Onehalf;
import java.util.Arrays;
//lc 2300 咒语和药水的成功数
public class SuccessNum {
    public static void main(String[] args) {
        System.out.println(successfulPairs(new int []{3,1,2},new int[]{8,5,8},16));
    }
    public static  int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m=spells.length;
        int []arr=new int[m];
        //目标数组
        Arrays.sort(potions);
        int n=potions.length;
        for(int i=0;i<m;i++){
            int l=0,r=n;
            while(l<r){
                int mid=l+(r-l)/2;
                if(potions[mid]<=success/spells[i]){
                    l=mid+1;
                }
                else{
                    r=mid;
                }
            }
            arr[i]=n-r;
        }
        return arr;
    }
}
