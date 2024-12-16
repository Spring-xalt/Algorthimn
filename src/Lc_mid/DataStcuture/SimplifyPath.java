package Lc_mid.DataStcuture;

import java.util.Objects;
import java.util.Stack;

// Lc 71 简化路径
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/."));
    }
    public static String simplifyPath(String path) {
        // 遇到多个/ 均以一个为准
        Stack<String> s=new Stack<>();
        int countp=0;
        int countDelete=0;
        StringBuffer str= new StringBuffer();
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/'){
                if(s.empty()|| !Objects.equals(s.peek(), "/")){
                    s.push("/");
                }
            }
            else if(path.charAt(i)=='.'){
                countp=0;
                while(i<path.length()&&path.charAt(i)=='.'){
                    countp++;
                    i++;
                }
                i--;
                if(countp==1){
                    s.pop();
                }
                else if(countp==2){
                    countDelete=0;
                    while(!s.empty()&&countDelete<2){
                        if(s.peek().equals("/")){
                            countDelete++;
                        }
                        s.pop();
                    }
                }
                else{
                    for(int k=0;k<countp;k++){
                        s.push(".");
                    }
                }
            }
            else{
                s.push(String.valueOf(path.charAt(i)));
            }
            if(!s.empty()&&i==path.length()-1&&s.peek().equals("/")&&s.size()!=1){
                s.pop();
            }
        }
        if(s.empty()){
            return "/";
        }
        while(!s.empty()){
            str.append(s.pop());
        }
        return str.reverse().toString();
    }
}
