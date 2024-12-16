package Lc_mid.String_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:
 */
public class FindDifferentWord {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> in= new ArrayList<>();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        int len=p.length(); int lens=s.length();
        if(len>lens) {
            return new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            hm1.put(p.charAt(i),hm1.getOrDefault(p.charAt(i),0)+1);
        }


        HashMap<Character, Integer> hm2 = new HashMap<>();
        int l=0,r=0;
        for(;r<len;r++){
            hm2.put(s.charAt(r),hm2.getOrDefault(s.charAt(r),0)+1);
        }
        r--;
        if(hm1.equals(hm2)){
            in.add(l);
        }
        while(r<s.length()){
            if(hm2.get(s.charAt(l))==1){
                hm2.remove(s.charAt(l));
            }
            else{
                hm2.put(s.charAt(l),hm2.get(s.charAt(l))-1);
            }
            l++;
            r++;
            if(r<s.length()){
                hm2.put(s.charAt(r),hm2.getOrDefault(s.charAt(r),0)+1);
            }
            if(hm2.equals(hm1)){
                in.add(l);
            }
        }
        return in;

    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
