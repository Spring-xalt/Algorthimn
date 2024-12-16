package Lc_easy.Bitwise;
// Lc 231 2的幂
    //  由二进制转十进制的方法 按位2^x ,只要是2的幂，n转为二进制获得的1只有一个
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }
    public static boolean isPowerOfTwo(int n) {
         int count=0;
         for(;n>0;n>>=1){
             if((n&1)==1){
                 count++;
             }
         }
         return count==1;
    }
}
