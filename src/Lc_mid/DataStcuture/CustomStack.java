package Lc_mid.DataStcuture;

import java.util.EmptyStackException;

public class CustomStack {
    int label;
    int []arr;
    public CustomStack(int maxSize) {
        label=-1;
        arr=new int [maxSize];
    }
    public void push(int x) {
        if(label<arr.length-1) {
            arr[++label] = x;
        }
    }
    public int pop() {
        if (label==-1) {
            return -1;
        }
        return arr[label--];
    }
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,label+1);i++){
            arr[i]+=val;
        }
    }

}
