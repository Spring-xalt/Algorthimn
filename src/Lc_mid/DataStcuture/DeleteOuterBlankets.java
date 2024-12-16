package Lc_mid.DataStcuture;

import java.util.Stack;
// Lc 1021 删除最外层的括号
public class DeleteOuterBlankets {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }
    public static String removeOuterParentheses(String s) {
        StringBuffer str= new StringBuffer();
        int l=0,r=0;
        Stack<Character> sta=new Stack<>();
        char[]ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(')sta.push(ch[i]);
            else{
                sta.pop();
            }
            if(sta.isEmpty()){
                r=i;
                str.append(s, l+1, r);
                l=r+1;
                r++;
            }
        }
        return str.toString();
    }
}
