package Lc_easy.Bitwise;
// Lc 476 数字的补数
public class FindComplementNum {
    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
    public static int findComplement(int num) {
        int ans=0;
        int count=0;    //每次取反后的数
        int k=1;        //权重
        for(;num>0;num>>=1,k*=2){
            count=((num&1)==1)?0:1;
            ans+=k*count;
        }
        return ans;
    }
}
