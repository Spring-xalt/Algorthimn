package Lc_mid.DataStcuture;

import java.util.Stack;

import static java.lang.Character.isDigit;

// Lc 682 棒球比赛
public class BaseballGame {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
    public static int calPoints(String[] operations) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("D")){
                s.push(s.peek()*2);
            }
            else if(operations[i].equals("C")){
                s.pop();
            }
            else if(operations[i].equals("+")){
                int p1=s.pop();
                int count=p1+s.peek();
                s.push(p1);
                s.push(count);
            }
            else{
                s.push(Integer.parseInt(operations[i]));
            }
        }
        int ans=0;
        while(!s.isEmpty()){
            ans+=s.pop();
        }
        return ans;
    }
}
