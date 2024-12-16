package Lc_mid.DataStcuture;

import java.util.Arrays;
import java.util.Stack;

// lc 3170 删除星号以后的字典序最小的字符串
public class DeleteCharacter {
    public static void main(String[] args) {
        System.out.println(clearStars("aaba*"));
    }
    public static String clearStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer str = new StringBuffer();
        char[]ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='*'){
                if(stack.isEmpty()){
                    stack.push(ch[i]);
                }
                else{
                    if((int)stack.peek()<(int)ch[i]){
                        char temp=stack.pop();
                        stack.push(ch[i]);
                        stack.push(temp);
                    }else{
                        stack.push(ch[i]);
                    }
                }
            }
            else{
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
