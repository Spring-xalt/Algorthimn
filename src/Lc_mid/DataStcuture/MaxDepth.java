package Lc_mid.DataStcuture;

import java.util.Stack;
// Lc  1614 括号的最大深度
public class MaxDepth {
     public static void main(String[] args) {
         System.out.println(maxDepth("()(())((()()))"));
     }
     public static int maxDepth(String s) {
        int ans=0;
        int count=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                count++;
            }
            else if(s.charAt(i)==')'){
                stack.pop();
                count--;
            }
            ans=Math.max(count,ans);
        }
        return ans;
     }
}
