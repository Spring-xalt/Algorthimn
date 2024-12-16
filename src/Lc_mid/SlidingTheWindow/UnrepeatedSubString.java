package Lc_mid.SlidingTheWindow;

import java.util.HashMap;
// Lc 3 无重复字符的最长子串
public class UnrepeatedSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> x = new HashMap<Character,Integer>();
        int n=s.length();
        int l=0,r=0;
        int ans=0,count=0;
        for(;l<=r&&r<n;r++){
            if(x.containsKey(s.charAt(r))) {
                l=x.get(s.charAt(r))+1;
            }
            x.put(s.charAt(r),r);
            count=r-l+1;
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
