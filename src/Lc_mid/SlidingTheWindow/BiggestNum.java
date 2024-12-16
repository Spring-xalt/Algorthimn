package Lc_mid.SlidingTheWindow;
//lc 1456  定长子串中元音的最大数目
public class BiggestNum {
    public int maxVowels(String s, int k) {
        int count=0,l=0;
        int ans=0;
        for(int i=0;i<k;i++){
            if(isMainWord(s.charAt(i))==1)count++;
        }
        ans=count;
        for(;l+k<s.length();l++){
            if(isMainWord(s.charAt(l))<isMainWord(s.charAt(l+k)))count++;
            if(isMainWord(s.charAt(l))>isMainWord(s.charAt(l+k)))count--;
            ans=Math.max(ans,count);
        }
        return ans;
    }
    public int isMainWord(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')?1:0;
    }
}
