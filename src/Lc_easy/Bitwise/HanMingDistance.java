package Lc_easy.Bitwise;
// Lc 461 汉明距离
public class HanMingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
    }
    public static int hammingDistance(int x, int y) {
        int ans=0;
        for(;;x>>=1,y>>=1){
            if(((x&1)^(y&1))==1)ans++;
            if(x==y&&y==0)break;
        }
        return ans;
    }
}
