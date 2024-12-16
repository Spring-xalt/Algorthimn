package Lc_easy.Bitwise;
//  Lc 3226 使两个整数相等的位更改次数
public class MakeTwoNumSameChangingTimes {
    public static void main(String[] args) {
        System.out.println(minChanges(14,13));
    }
    public static int minChanges(int n, int k) {
         int ans=0;
         for(;;n>>=1,k>>=1){
             if((n&1)<(k&1))return -1;
             if((n&1)>(k&1))ans++;
             if(n==k&&n==0)break;
         }
         return ans;
    }
}
