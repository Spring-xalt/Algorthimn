package Lc_mid.DataStcuture;

import java.io.CharArrayReader;
import java.util.Stack;

// Lc  1190 反转每对括号之间的子串

public class ReverseSubstring {
    public static void main(String[] args) {
        //System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
    public static String reverseParentheses(String s) {
        // 处理嵌套型可使用 ，非嵌套型需要记录各位最内层的()括号位置
        StringBuilder str = new StringBuilder(s);
        int l=0,r=0;
        int count=0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack1.push(s.charAt(i));
                l=i;
            }
            if(s.charAt(i)==')'){
                r=i;
                break;
            }
        }
        while(l>=0&&r<s.length()){
            for(int i=l+1;i<r;i++){
                stack2.push(str.charAt(i));
            }
            for(int i=l+1;i<r;i++){
                str.setCharAt(i,stack2.pop());
            }
            do{
                l--;
            }while(l>=0&&s.charAt(l)!='(');
            do{
                r++;
            }while(r<s.length()&&s.charAt(r)!=')');
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)==')'){
                str.deleteCharAt(i);
                // 遇到连续括号需要调整索引来处理
                i--;
            }
        }
        return str.toString();
    }
}


class T{
    public static void main(String[] args) {
        System.out.println(reverseParentheses("f(ul)ao(t(y)qbn)()sj")); // 预期输出: "leetcode"
    }
    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        // 使用栈存储每个 '(' 的位置
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)=='(') {
                stack.push(i);
            } else if (str.charAt(i)==')') {
                // 弹出栈顶位置，找到匹配的 '('
                int start=stack.pop();
                int end=i;
                // 反转括号中的子字符串
                reverseSubstring(str,start+1, end-1);
            }
        }
        // 删除所有括号
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)=='('||str.charAt(i)==')') {
                str.deleteCharAt(i);
                i--;  // 调整索引以处理连续括号
            }
        }
        return str.toString();
    }
    // 辅助方法，用于反转 StringBuilder 中的子字符串
    private static void reverseSubstring(StringBuilder str,int left,int right) {
        while (left<right) {
            char temp=str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}