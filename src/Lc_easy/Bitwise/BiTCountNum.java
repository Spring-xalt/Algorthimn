package Lc_easy.Bitwise;
 // Lc 338 比特位计数
public class BiTCountNum {
     public static int[] countBits(int n) {
        int []arr=new int[n+1];
        arr[0]=0;
        for(int i=1;i<=n;i++){
            arr[i]=getCount(i);
        }
        return arr;
     }
     public static int getCount(int n){
         int count=0;
         for(;n>0;n>>=1){
             if((n&1)==1){
                 count++;
             }
         }
         return count;
     }
}
