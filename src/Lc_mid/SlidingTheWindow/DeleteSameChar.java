package Lc_mid.SlidingTheWindow;
//LC 1750 删除字符串相同字符后的最短长度
public class DeleteSameChar {
    public int minimumLength(String s) {
        int n=s.length(),l=0,r=n-1;
        if(s.charAt(l)!=s.charAt(r))return n;
        while(l<r&&s.charAt(l)==s.charAt(r)){
            char ch=s.charAt(l);
            while(l<=r&&ch==s.charAt(l))l++;
            while(l<=r&&ch==s.charAt(r))r--;
        }
        return r-l+1;
    }
}
