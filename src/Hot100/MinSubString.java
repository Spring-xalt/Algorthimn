package Hot100;

import java.util.*;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 79 最小覆盖子串
 */
public class MinSubString {
    public static String minWindow(String s, String t) {
        //map 存储字符出现频率 滑动寻找最大
        //  l i分别为子串左右  确定一个l时 i一直右移动 知道能满足 接着 i向右找到能满足的最小的 存储起来
        //  当前l i找完之后 i继续移动 直到走完
        // 要满足的条件
        Map<Character, Integer> mt=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            mt.put(c,mt.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> ms=new HashMap<>();
        int left=0,right=0;
        // 需要匹配的字符个数
        int required=mt.size();
        //当前已经匹配的个数
        int has=0;
        int []res=new int[]{-1,0,0};
        while(right<s.length()){
            char c=s.charAt(right);
            ms.put(c,ms.getOrDefault(c,0)+1);
            if(mt.containsKey(c)&& mt.get(c).equals(ms.get(c))){
                has++;
            }
            // 满足了条件
            while(left<=right&&has==required){

                if(res[0]==-1||res[0]>=right-left+1){   // 解决未处理的和后来加字符导致 不是最小子串的
                    res[0]=right-left+1;
                    res[1]=left;
                    res[2]=right;
                }
                //开始尝试收缩左边界
                char ch=s.charAt(left);
                ms.put(ch,ms.get(ch)-1);
                if(mt.containsKey(ch)&&mt.get(ch)>(ms.get(ch))){
                    has--;
                }
                left++;
            }
            right++;
        }
        return res[0]==-1?"":s.substring(res[1],res[2]+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

}
