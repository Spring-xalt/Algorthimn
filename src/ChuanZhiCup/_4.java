package ChuanZhiCup;

import java.util.HashMap;
import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String str=sc.next();
//        int n=5,k=3;
//        String str="aabcd";
        int length=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        for(;r<n&&map.size()<k;r++){
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
            if(r==str.length()-1&&map.size()<=k) {
                length=n;
                System.out.println(length);
                return;
            }
        }
        r-=1;
        // 此前l到r为满k窗口
        length=Math.max(length,r-l+1);
        r++;
        for(;r<n;r++){
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
            while(map.size()>k){
                int count=map.get(str.charAt(l));
                if(count==1){
                    map.remove(str.charAt(l));
                }
                else{
                    map.put(str.charAt(l),count-1);
                }
                l++;
            }
            length=Math.max(length,r-l+1);
        }
        System.out.println(length);
    }
}
