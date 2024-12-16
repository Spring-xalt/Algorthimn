package ChuanZhiCup;

import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        // t1
        //arr[i]下标表示 如今的第几个杯子，arr[i]表示 是最初的第几个
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int K = sc.nextInt();
        int []arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i;
        }
        int i=0;
        while(i<K){
            // 要交换的 两个杯子
            int a = sc.nextInt();
            int b = sc.nextInt();
            int temp=arr[a-1];
            arr[a-1]=arr[b-1];
            arr[b-1]=temp;
            i++;
        }
        for(int j=0;j<N;j++){
            // 对结束交换的数组进行遍历
            if(arr[j]==X-1) System.out.println(j+1);
        }

    }
}