package Lc_mid.DataStcuture;

import java.util.Stack;

// Lc 删除子串后的字符串最小长度
public class MinSubStringAfterDeleting {
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }
    public static int minLength(String s) {
        char[]c=s.toCharArray();
        int n=c.length;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(c[i]!='B'&&c[i]!='D') {
                stack.push(c[i]);
            } else{
                if(stack.isEmpty()){
                    stack.push(c[i]);
                }
                else{
                    if(stack.peek()=='C'||stack.peek()=='A'){
                        while(i<n&&!stack.isEmpty()&&(stack.peek()=='C'||stack.peek()=='A')){
                            if((stack.peek()=='C'&&c[i]=='D')||(stack.peek()=='A'&&c[i]=='B')){
                                stack.pop();
                                i++;
                            }
                            else{
                                stack.push(c[i]);
                                i++;
                            }
                        }
                        i--;
                    }
                    else{
                        stack.push(c[i]);
                    }
                }
            }
        }
        return stack.size();
    }
}
