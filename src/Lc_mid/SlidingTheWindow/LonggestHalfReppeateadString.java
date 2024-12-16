package Lc_mid.SlidingTheWindow;

//Lc 2730 最长半重复字符串
public class LonggestHalfReppeateadString {
    public static void main(String[] args) {
        System.out.println(longestSemiRepetitiveSubstring("5494"));
    }
    public static  int longestSemiRepetitiveSubstring(String s) {
        int ans=0,same=0;                   //same记录重复次数
        int l=0,r=1,n=s.length();           //same=1可以继续记录，same>1 left变为上一次重复时的右端点
        int cnt=0;                           //cnt记录每一次最近的右端点
        for(;r<n;r++){
            if(s.charAt(r)==s.charAt(r-1)){
                same++;
                if(same>1){
                    l=Math.max(l,cnt);
                }
                cnt=r;
            }
            ans=Math.max(ans,r-l+1);
        }
        return (n==1)?1:ans;
    }
}