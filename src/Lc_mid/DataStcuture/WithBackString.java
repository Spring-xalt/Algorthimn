package Lc_mid.DataStcuture;
import java.util.Stack;

// Lc  884 比较含退格符的字符串
public class WithBackString {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c","#a#c"));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack s1=new Stack();
        Stack t1=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#')s1.push(s.charAt(i));
            else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='#')t1.push(t.charAt(i));
            else{
                if(!t1.isEmpty()){
                    t1.pop();
                }
            }
        }
        if(s1.size()!=t1.size())return false;
        else{
            while(!s1.isEmpty()){
                if(s1.pop()!=t1.pop())return false;
            }
        }
        return true;
    }
    public static boolean backspaceCompare2(String S, String T) {
        // O(1)  i,j最后停留到了不需要退后的第一个位置
        int i =S.length()-1,j=T.length()-1;
        int skipS=0,skipT=0;
        while(i>=0||j>=0){
            while(i>=0){
                if(S.charAt(i)=='#') {
                    skipS++;
                    i--;
                }else if(skipS>0) {
                    skipS--;
                    i--;
                } else{
                    break;
                }
            }
            while(j>=0) {
                if(T.charAt(j)=='#') {
                    skipT++;
                    j--;
                }else if(skipT>0) {
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if (i>=0&&j>=0) {
                if(S.charAt(i)!=T.charAt(j)) {
                    return false;
                }
            }else{
                if(i>=0||j>=0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
