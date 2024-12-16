package Lc_mid.BitExercise;
// Lc 2683 相邻值的按位异或
public class XorPostion {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        if(n==1)return derived[0]==0;
        boolean []arr=new boolean[n];
        arr[0]=false;
        for(int i=0;i<n-1;i++){
            if(derived[i]!=0)arr[i+1]=!arr[i];
            else{
                arr[i+1]=arr[i];
            }
        }
        if(arr[n-1]==arr[0]){
            return derived[n-1]==0;
        }
        else{
            return derived[n-1]==1;
        }
    }
}
