package Lc_easy.Bitwise;
// Lc 191 位1的个数
public class CountOF1 {
    public int hammingWeight(int n) {
        int count = 0;
        for(;n>0;n>>=1){
            if((n&1)==1){
                count++;
            }
        }
        return count;
    }
}
