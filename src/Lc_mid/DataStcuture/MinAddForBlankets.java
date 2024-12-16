package Lc_mid.DataStcuture;

import java.util.Stack;
// Lc 921 使括号有效的最小添加
public class MinAddForBlankets {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
    }
    public static int minAddToMakeValid(String str) {
        Stack<Character> s=new Stack<>();
        char[] ch=str.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                s.push(ch[i]);
            }
            else{
                if(s.empty()) {
                    count++;
                } else{
                    if(s.peek()=='(') {
                        s.pop();
                    } else{
                        count++;
                    }
                }
            }
        }
        return (s.empty()?count:s.size()+count);
    }
}
