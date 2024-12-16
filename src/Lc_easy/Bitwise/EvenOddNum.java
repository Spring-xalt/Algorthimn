package Lc_easy.Bitwise;
// Lc 2595 奇偶位数

 // 1.异或进行0 1数组位的更新
 // 2.移位来遍历二进制数位
 // 3.与运算获得每一位
public class EvenOddNum {
    public int[] evenOddBit(int n) {
        int []arr=new int[2];
        for(int i=0;n>0;i^=1,n>>=1){ // 对数组前后位的更新 ，n的数位移动
            arr[i]+=n&1;
            //将获得的0 1加在奇偶位上
        }
        return  arr;
    }
}
