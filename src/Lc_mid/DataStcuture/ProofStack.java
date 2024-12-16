package Lc_mid.DataStcuture;

import java.util.Stack;

// Lc 946 验证栈序列
public class ProofStack {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int n=pushed.length;
        for(int i=0,j=0;i<n;i++){
            s.push(pushed[i]);
            while(!s.empty()&&s.peek()==popped[j]){
                s.pop();
                j++;
            }
        }
        return s.empty();
    }
}
