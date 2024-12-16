package Lc_mid.DP;
// Lc 1191 K次串联后最大子数组之和
public class KPlusSubArr {
    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[]{10000,10000,10000,10000,10000,10000,10000,10000,10000,10000},100000));
    }
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int m=arr.length;
        int n=m*k;
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=arr[i%m];
        }
        int max=0;
        int cmax=0;
        for(int i=0;i<n;i++){
            if(cmax<0){
                cmax=a[i];
            }
            else{
                cmax+=a[i];
            }
            max=Math.max(max,cmax);
        }
        return max;
    }
}
