package Lc_hard;

import java.util.Stack;
 // Lc 32 最长有效括号
public class TheLonggestUsefulBlankets {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("(()"));
    }
    public static int longestValidParentheses(String s) {
        // O(n^3)
        int n = s.length();
        if(n==0)return 0;
        int ans=0,count=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i;j<s.length();j++){
                if(UsefulBlankets(s.substring(i,j+1)))count=j-i+1;
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
    public static boolean UsefulBlankets(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty())return false;
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

// 优化O(N)
    public static int longestValidParentheses2(String s) {
        int l=0,ans=0;
        int n=s.length();
        Stack<Integer> stack = new Stack<>();
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                // 遇到左括号将左括号下标入栈，用于维护需要匹配的左括号下标
                stack.push(i);
            }
            else{
                //遇到右括号并此时栈不为空
                if(!stack.isEmpty()){
                    // 当前右括号匹配成功，弹出栈顶左括号
                    stack.pop();
                    if(stack.isEmpty()){
                        //若弹出后栈为空 ，区间内即为有效的序列
                        ans=Math.max(i-l+1,ans);
                    }
                    else{
                        //若弹出后栈不为空，i到栈顶左括号下标之间的序列有效,此处不用+1，在于有效左括号已经弹出，用该栈顶元素指示而已
                        ans=Math.max(ans,i-stack.peek());
                    }
                }
                //遇到右括号冰此时栈为空,此时需要更新左端点，因为以该左端点开头的序列均不可能匹配成功
                else{
                    l=i+1;
                }
            }
        }
        return ans;
    }
}
