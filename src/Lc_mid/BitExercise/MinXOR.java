package Lc_mid.BitExercise;
// Lc 2429 最小异或
public class MinXOR {
    public static void main(String[] args) {
        System.out.println(minimizeXor(1,12));
    }
    public static int minimizeXor(int num1, int num2) {
        // Integer.bitCount 返回num的二进制形式中1的个数，称为置位数
        int count1=Integer.bitCount(num1);
        int count2=Integer.bitCount(num2);
        int x=num1;
        while(count1>count2) {
            // 要使得 x^nums1 最小，就应当使得最高位的1消失
            // 然而无法使得所有1 消失，故 x 应当是num1 最低位的1变为0
            x&=x-1;
            //清除最低位的 1 改为 0
            count1--;
        }
        while(count1<count2) {
            // 使得 num1 最低位的 0变为1
            x|=x+1;
            // 将最低位的 0 改为 1
            count1++;
        }
        return x;
    }
}
