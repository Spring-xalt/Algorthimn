package Lc_easy.Bitwise;
// Lc 342 4的幂
    // 4^x=2^(2x)  类似于2的幂
                // 二进制中只有一个1 但是1的下标必须为奇数
public class IsPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
    }
    public static boolean isPowerOfFour(int n) {
        int count=0;
        int label=0;
        for(;n>0;n>>=1){
            if((n&1)==1){
                count++;
            }
            label++;
        }
        return (count==1)&&(label%2==1);
    }
}
